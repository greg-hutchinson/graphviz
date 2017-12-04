package ca.attractors.dot.attribute.type;

import ca.attractors.util.Strings;

public enum ColorSchemeType implements IDotAttributeValue {
	X11("X11"), SVG("SVG");
	
	private final String value;
	
	private ColorSchemeType(String aValue) {
		value = aValue;
	}
	
	public String getValue() {
		return value;
	}

	public String toDotString() {
		return Strings.quoted(getValue());
	}

}
