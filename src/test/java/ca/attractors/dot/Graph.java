package ca.attractors.dot;

import java.util.ArrayList;
import java.util.List;

public class Graph extends DotType {
	private GraphType type;
	private GraphAttributes attributes;
	private String name;
	private List<DotType> objects = new ArrayList<DotType>();

	public Graph() {
		this("", GraphType.DIGRAPH);
	}

	public String getName() {
		return name;
	}

	public Graph(String aName, GraphType aGraphType) {
		if (aName == null)
			throw new NullPointerException("aName must not be null");
		name = aName;
		attributes = new GraphAttributes();
		type = aGraphType;
	}

	public GraphAttributes getAttributes() {
		return attributes;
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
