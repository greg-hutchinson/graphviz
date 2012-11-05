package ca.attractors.dot;

import java.util.ArrayList;
import java.util.List;

public class Graph extends DotObject<GraphAttributes> {

	private String name;
	private GraphType type;
	private List<DotObject> objects = new ArrayList<DotObject>();

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

	@Override
	protected String getStartDefinitionAsDotString() {
		String textName = name;
		if (name != "")
			textName += " ";
		return type.toString() + " " + textName + "{\n";
	}

	@Override
	public String getAttributesAsDotString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getRawAttributesAsDotString() + "\n");
		for (DotObject type : objects) {
			builder.append(type.toDotString());
		}
		return builder.toString();
	}

	protected String getEndDefinitionAsDotString() {
		return "}\n";
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

	public void addObject(DotObject aType) {
		objects.add(aType);
	}


}
