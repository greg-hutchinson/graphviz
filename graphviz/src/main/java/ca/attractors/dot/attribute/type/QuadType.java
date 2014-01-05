package ca.attractors.dot.attribute.type;

import ca.attractors.util.Strings;

public enum QuadType implements IDotAttributeValue {
	NORMAL("normal"),
	FAST("fast"),
	NONE("none");
	
	private final String value;
	
	private QuadType(String aValue) {
		value = aValue;
	}
	
	public String getValue() {
		return value;
	}

	public String toDotString() {
		return Strings.quoted(getValue());
	}

}
