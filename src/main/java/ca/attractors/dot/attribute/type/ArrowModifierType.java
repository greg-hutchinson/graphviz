package ca.attractors.dot.attribute.type;

import ca.attractors.util.Strings;

public enum ArrowModifierType implements IDotAttributeValue {
	OPEN("o");
	
	private final String value;
	
	private ArrowModifierType(String aValue) {
		value = aValue;
	}
	
	public String getValue() {
		return value;
	}

	public String toDotString() {
		return Strings.quoted(getValue());
	}
}
