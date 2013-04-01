package ca.attractors.dot.attribute.type;

public class StringDotAttributeValue implements IDotAttributeValue {
	private String value;

	public StringDotAttributeValue(String aValue) {
		value = aValue;
	}

	public String getValue() {
		return value;
	}

}
