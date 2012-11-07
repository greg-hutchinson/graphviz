package ca.attractors.dot.attribute.type;

public enum ArrowModifierType implements IDotAttributeValue {
	OPEN("o");
	
	private final String value;
	
	private ArrowModifierType(String aValue) {
		value = aValue;
	}
	
	public String getValue() {
		return value;
	}
}
