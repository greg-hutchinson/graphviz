package ca.attractors.dot.attribute.type;

import ca.attractors.util.Strings;

public class IntegerDotAttributeValue implements IDotAttributeValue {
	
	private final Integer value;
	
	public IntegerDotAttributeValue(Integer aValue) {
		if (aValue == null)
			throw new NullPointerException("cannot construct with null value");
		value = aValue;
	}
	
	public Integer getIntegerValue() {
		return value;
	}
	
	public String getValue() {
		return value.toString();
	}

	public String toDotString() {
		return Strings.quoted(getValue());
	}

}
