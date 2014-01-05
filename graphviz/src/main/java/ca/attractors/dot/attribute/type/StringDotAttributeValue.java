package ca.attractors.dot.attribute.type;

import ca.attractors.util.Strings;

public class StringDotAttributeValue implements IDotAttributeValue {
	private String value;

	public StringDotAttributeValue(String aValue) {
		value = aValue;
	}

	public String getValue() {
		return value;
	}

	public String toDotString() {
		return Strings.quoted(getValue());
	}

}
