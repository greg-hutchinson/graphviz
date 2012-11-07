package ca.attractors.dot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.attractors.util.Strings;

public class Graph extends DotObject<GraphAttributes> {
	private String name;
	private GraphType type;
	private List<IGraphElement> objects = new ArrayList<IGraphElement>();
	private Map<String, Node> nodes = new HashMap<String, Node>();

	public Graph() {
		this("", GraphType.DIGRAPH);
	}

	public Graph(String aName, GraphType aGraphType) {
		super(new GraphAttributes());
		if (aName == null)
			throw new NullPointerException("aName must not be null");
		name = aName;
		type = aGraphType;
	}

	public void setBackgroundColor(String aString) {
		getAttributes().setBackgroundColor(aString);
	}

	public String getBackgroundColor() {
		return getAttributes().getBackgroundColor();
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

	@Override
	protected CharSequence getDefinitionBody() {
		if (getAttributes().isEmpty())
			return "";
		StringBuilder builder = new StringBuilder();
		builder.append(getAttributes().toDotString());
		for (IGraphElement type : objects) {
			builder.append(type.toDotString());
		}
		return builder.toString();
	}

	@Override
	protected CharSequence getDefinitionEnd() {
		return "}\n";
	}

	@Override
	protected CharSequence getDefinition() {
		String textName = name;
		if (name != "")
			textName = Strings.quoted(textName) + " ";
		return getGraphTypeString() + " " + textName + "{\n";
	}

	protected String getGraphTypeString() {
		return type.toString();
	}

	public Node newNode(String aString) {
		return (Node) addGraphElement(new Node(aString));
	}

	private Node getNodeNamed(String aString) {
		if (nodes.containsKey(aString))
			return nodes.get(aString);
		//FIXME, GH - Not sure about this yet. Changing my mind.		
		//return newNode(aString);
		return new Node(aString);
	}

	public Edge newEdge(String aFromName, String aToName) {
		Edge edge = new Edge(getNodeNamed(aFromName), getNodeNamed(aToName), type);
		return (Edge) addGraphElement(edge);
	}

	public Subgraph newSubgraph(String aName) {
		return (Subgraph) addGraphElement(new Subgraph(aName, type));
	}

	@Override
	public boolean equals(Object aObj) {
		if (!(aObj instanceof Node))
			return false;
		Graph other = (Graph) aObj;
		return other.getName().equals(getName());
	}

	public int hashCode() {
		return name.hashCode();
	}

}
