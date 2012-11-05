package ca.attractors.dot;

public class Node extends DotType {
	private static final String LABEL = "label";
	private static final String FILLCOLOR = "fillcolor";
	private static final String STYLE = "style";

	private String name;

	public Node(String aName) {
		name = aName;
	}

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

	public String getName() {
		return name;
	}

	protected String getAttributesAsDotString() {
		return getBracketedAttributesAsDotString();
	}

	public String getStartDefinitionAsDotString() {
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
