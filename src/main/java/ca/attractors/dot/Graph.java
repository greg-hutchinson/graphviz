package ca.attractors.dot;

import java.util.ArrayList;
import java.util.List;

public class Graph extends DotType {
	private static final String BG_COLOR = "bgColor";

	private String name;
	private GraphType type;
	private List<DotType> objects = new ArrayList<DotType>();

	public Graph() {
		this("", GraphType.DIGRAPH);
	}

	public Graph(String aName, GraphType aGraphType) {
		if (aName == null)
			throw new NullPointerException("aName must not be null");
		name = aName;
		type = aGraphType;
	}

	public void setBackgroundColor(String aString) {
		set(BG_COLOR, aString);
	}

	public String getBackgroundColor() {
		return get(BG_COLOR);
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
		for (DotType type : objects) {
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

	public void addObject(DotType aType) {
		objects.add(aType);
	}


}
