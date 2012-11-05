package ca.attractors.dot;

public class Node extends DotType {
	private String name;
	private static final String LABEL = "label";
	private static final String FILLCOLOR = "fillcolor";
	private static final String STYLE = "style";

	public String getLabel() {
		return get(LABEL);
	}

	public void setLabel(String aLabel) {
		set(LABEL, aLabel);
	}

	public String getFillColor() {
		return get(FILLCOLOR);
	}

	public void setFillColor(String aFillColor) {
		set(FILLCOLOR, aFillColor);
	}

	public String getStyle() {
		return get(STYLE);
	}

	public void setStyle(String aStyle) {
		set(STYLE, aStyle);
	}

	public Node(String aName) {
		name = aName;
	}

	public String getName() {
		return name;
	}

	public String getDefinitionString() {
		return name;
	}

	@Override
	public boolean equals(Object aObj) {
		if (!(aObj instanceof Node))
			return false;
		Node other = (Node) aObj;
		return other.getName().equals(getName());
	}

	public int hashCode() {
		return name.hashCode();
	}
}
