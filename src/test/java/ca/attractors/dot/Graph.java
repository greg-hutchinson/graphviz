package ca.attractors.dot;

import java.util.ArrayList;
import java.util.List;

public class Graph extends DotType {
	private String name;
	private GraphType type;
	private List<DotType> objects = new ArrayList<DotType>();
	private static final String COLOR = "color";

	public Graph() {
		this("", GraphType.DIGRAPH);
	}

	public Graph(String aName, GraphType aGraphType) {
		if (aName == null)
			throw new NullPointerException("aName must not be null");
		name = aName;
		type = aGraphType;
	}

	public String getColor() {
		return get(COLOR);
	}

	public void setColor(String aFillColor) {
		set(COLOR, aFillColor);
	}

	public String getName() {
		return name;
	}

	@Override
	protected String getDefinitionString() {
		throw new IllegalStateException("Not yet implemented");
	}

	public String toDotString() {
		StringBuilder builder = new StringBuilder();
		builder.append(type.toString() + " " + name + " {\n");
		for (DotType type : objects) {
			builder.append(type.toDotString());
		}
		builder.append("}");
		return builder.toString();
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
