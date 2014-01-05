package ca.attractors.dot.attribute.type;

import ca.attractors.util.Strings;

public enum ArrowSideType implements IDotAttributeValue {
	LEFT("l"),
	RIGHT("r");
	
	private final String value;
	
	private ArrowSideType(String aValue) {
		value = aValue;
	}
	
	public String getValue() {
		return value;
	}

	public String toDotString() {
		return Strings.quoted(getValue());
	}

}
