package ca.attractors.dot.attribute.type;

import ca.attractors.util.Strings;

public enum NodeStyleType implements IDotAttributeValue {
	Filled("filled"),
	Invisible("invisible"),
	Diagonals("diagonals"),
	Rounded("rounded"),
	Dashed("dashed"),
	Dotted("dotted"),
	Solid("solid"),
	Bold("bold");
	
	private final String value;
	
	private NodeStyleType(String aValue) {
		value = aValue;
	}
	
	public String getValue() {
		return value;
	}

	public String toDotString() {
		return Strings.quoted(getValue());
	}

}
