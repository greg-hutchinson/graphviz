package ca.attractors.dot.attribute.type;

import ca.attractors.util.Strings;

public enum RatioType implements IDotAttributeValue {
	Numeric("numeric"),
	Fill("fill"),
	Compress("compress"),
	Expand("expand"),
	Auto("auto");
	
	private final String value;
	
	private RatioType(String aValue) {
		value = aValue;
	}
	
	public String getValue() {
		return value;
	}

	public String toDotString() {
		return Strings.quoted(getValue());
	}

}
