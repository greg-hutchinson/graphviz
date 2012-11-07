package ca.attractors.dot.attribute.type;

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
}
