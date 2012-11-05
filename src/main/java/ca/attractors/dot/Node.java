package ca.attractors.dot;

public class Node extends DotObject<NodeAttributes> {
	private String name;
	public Node(String aName) {
		super(new NodeAttributes());
		name = aName;
	}

	@Override
	protected CharSequence getDefinitionBody() {
		return getAttributes().getDefinitionBody();
	}

	@Override
	protected CharSequence getDefinition() {
		return name;
	}

	public String getName() {
		return name;
	}

	public String getLabel() {
		return getAttributes().getLabel();
	}

	public void setLabel(String aLabel) {
		getAttributes().setLabel(aLabel);
	}

	public String getFillColor() {
		return getAttributes().getFillColor();
	}

	public void setFillColor(String aFillColor) {
		getAttributes().setFillColor(aFillColor);
	}

	public String getStyle() {
		return getAttributes().getStyle();
	}

	public void setStyle(String aStyle) {
		getAttributes().setStyle(aStyle);
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
