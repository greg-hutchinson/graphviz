package ca.attractors.dot;

import ca.attractors.util.Strings;

public class Node extends DotObject implements IGraphElement {
	private String name;

	protected Node(String aName) {
		name = aName;
	}


	protected CharSequence getDefinition() {
		return Strings.quoted(name);
	}

	public String getName() {
		return name;
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


	public String getColor() {
		return null;
	}


	public void setColor(String aString) {
	}

}
