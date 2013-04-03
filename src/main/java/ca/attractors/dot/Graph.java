package ca.attractors.dot;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.attractors.util.Strings;

public class Graph extends AbstractGraphAttributes {

	private String name;
	private GraphType type;
	private List<IGraphElement> objects = new ArrayList<IGraphElement>();
	private Map<String, Node> nodes = new HashMap<String, Node>();

	public Graph() {
		this("", GraphType.DIGRAPH);
	}

	public Graph(String aName, GraphType aGraphType) {
		super();
		if (aName == null)
			throw new NullPointerException("aName must not be null");
		if (aGraphType == null)
			throw new NullPointerException("aGraphType must not be null");
		name = aName;
		type = aGraphType;
	}

	public void toDotStringOn(PrintStream aPrintStream) {
		aPrintStream.append(getGraphString());
		basicToDotStringOn(aPrintStream);
		printComponentsOn(aPrintStream);
		aPrintStream.append("}\n");
	}

	private void printComponentsOn(PrintStream aPrintStream) {
		for (IGraphElement element : objects) {
			aPrintStream.append(element.toDotString());
		}
	}

	@Override
	protected String getDefinition() {
		if (isAttributesEmpty())
			return "";
		return "graph";
	}

	protected CharSequence getGraphString() {
		String textName = name;
		if (name != "")
			textName = Strings.quoted(textName) + " ";
		return getGraphTypeString() + " " + textName + "{\n";
	}

	public String getName() {
		return name;
	}

	private Node addNode(Node aNode) {
		nodes.put(aNode.getName(), aNode);
		return aNode;
	}

	private IGraphElement addGraphElement(IGraphElement aType) {
		objects.add(aType);
		if (aType instanceof Node)
			addNode((Node) aType);
		return aType;
	}


	protected String getGraphTypeString() {
		return type.toString();
	}

	private Node getNodeNamed(String aString) {
		if (nodes.containsKey(aString))
			return nodes.get(aString);
		//FIXME, GH - Not sure about this yet. Changing my mind.		
		//return newNode(aString);
		return new Node(aString);
	}

	public Node newNode(String aString) {
		return (Node) addGraphElement(new Node(aString));
	}

	public Edge newEdge(String aFromName, String aToName) {
		Edge edge = new Edge(getNodeNamed(aFromName), getNodeNamed(aToName), type);
		return (Edge) addGraphElement(edge);
	}

	public Subgraph newSubgraph(String aName) {
		return (Subgraph) addGraphElement(new Subgraph(aName, type));
	}


	public DefaultEdgeAttributes newEdgeAttributes() {
		return (DefaultEdgeAttributes) addGraphElement(new DefaultEdgeAttributes());
	}

	public DefaultNodeAttributes newNodeAttributes() {
		return (DefaultNodeAttributes) addGraphElement(new DefaultNodeAttributes());
	}

	public DefaultGraphAttributes newGraphAttributes() {
		return (DefaultGraphAttributes) addGraphElement(new DefaultGraphAttributes());
	}

	@Override
	public boolean equals(Object aObj) {
		if (!(aObj instanceof Graph))
			return false;
		Graph other = (Graph) aObj;
		return other.getName().equals(getName());
	}

	public int hashCode() {
		return name.hashCode();
	}

}
