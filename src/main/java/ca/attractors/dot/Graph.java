package ca.attractors.dot;

import java.util.ArrayList;
import java.util.List;

public class Graph extends DotObject<GraphAttributes> {
	private String name;
	private GraphType type;
	private List<IGraphElement> objects = new ArrayList<IGraphElement>();

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


	protected IGraphElement addObject(IGraphElement aType) {
		objects.add(aType);
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
			textName += " ";
		return getGraphTypeString() + " " + textName + "{\n";
	}

	protected String getGraphTypeString() {
		return type.toString();
	}

	public Node newNode(String aString) {
		return (Node) addObject(new Node(aString));
	}

	public Edge newEdge(String aFromName, String aToName) {
		return (Edge) addObject(new Edge(aFromName, aToName, type));
	}

	public Subgraph newSubgraph(String aName) {
		return (Subgraph) addObject(new Subgraph(aName, type));
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
