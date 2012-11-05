package ca.attractors.dot;

import java.util.ArrayList;
import java.util.List;

public class Graph extends DotObject<GraphAttributes> {

	private String name;
	private GraphType type;
	private List<DotObject<? extends DotObjectAttributes>> objects = new ArrayList<DotObject<? extends DotObjectAttributes>>();

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
	public boolean equals(Object aObj) {
		if (!(aObj instanceof Node))
			return false;
		Graph other = (Graph) aObj;
		return other.getName().equals(getName());
	}

	public int hashCode() {
		return name.hashCode();
	}

	public void addObject(DotObject<? extends DotObjectAttributes> aType) {
		objects.add(aType);
	}

	@Override
	protected CharSequence getDefinitionBody() {
		StringBuilder builder = new StringBuilder();
		builder.append(getAttributes().toDotString());
		for (DotObject<?> type : objects) {
			builder.append(type.toDotString());
		}
		return builder.toString();
	}

	@Override
	protected CharSequence getDefinitionEnd() {
		return "}";
	}

	@Override
	protected CharSequence getDefinition() {
		String textName = name;
		if (name != "")
			textName += " ";
		return type.toString() + " " + textName + "{\n";
	}
}
