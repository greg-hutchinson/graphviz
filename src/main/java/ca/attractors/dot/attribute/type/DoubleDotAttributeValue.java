package ca.attractors.dot.attribute.type;

import ca.attractors.util.Strings;

public class DoubleDotAttributeValue implements IDotAttributeValue {
	
	private final Double value;
	
	public DoubleDotAttributeValue(Double aValue) {
		if (aValue == null)
			throw new NullPointerException("cannot construct with null value");
		value = aValue;
	}
	
	public Double getDoubleValue() {
		return value;
	}
	
	public String getValue() {
		return value.toString();
	}

	public String toDotString() {
		return Strings.quoted(getValue());
	}

}
