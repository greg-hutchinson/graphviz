package ca.attractors.dot.attribute.type;

import ca.attractors.util.Strings;

public class BooleanDotAttributeValue implements IDotAttributeValue {
	private boolean value;

	public BooleanDotAttributeValue(boolean aValue) {
		value = aValue;
	}

	public String getValue() {
		return Boolean.toString(value);
	}

	public boolean getBooleanValue() {
		return value;
	}

	public String toDotString() {
		return Strings.quoted(getValue());
	}

}
