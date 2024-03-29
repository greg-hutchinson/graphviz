package ca.attractors.dot;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.attractors.dot.program.IRenderer;
import ca.attractors.example.ParentNode;
import ca.attractors.util.IParentNode;
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
		if (!name.equals(""))
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
		Node newNode = newNode(aString);
		newNode.markCreatedImplicitely();
		return newNode;
	}

	public Node newNode(String aString) {
		return (Node) addGraphElement(new Node(aString));
	}

	public Edge newEdge(String aFromName, String aToName) {
		Edge edge = new Edge(getNodeNamed(aFromName), getNodeNamed(aToName), type);
		return (Edge) addGraphElement(edge);
	}

	public Edge newEdge(Node aFromNode, Node aToNode) {
		return newEdge(aFromNode.getName(), aToNode.getName());
	}

	public Subgraph newSubgraph(String aName) {
		return (Subgraph) addGraphElement(new Subgraph(aName, type));
	}


	public DefaultEdgeAttributes newDefaultEdgeAttributes() {
		return (DefaultEdgeAttributes) addGraphElement(new DefaultEdgeAttributes());
	}

	public DefaultNodeAttributes newDefaultNodeAttributes() {
		return (DefaultNodeAttributes) addGraphElement(new DefaultNodeAttributes());
	}

	public DefaultGraphAttributes newDefaultGraphAttributes() {
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

	public GraphType getType() {
		return type;
	}

	public void visitParentNodes(List<IParentNode> aParentNodes) {
		for (IParentNode node : aParentNodes) {
			node.addToGraph(this);
		}
	}

	public void renderUsing(IRenderer aRenderer) {
		aRenderer.render(this);
	}

}
