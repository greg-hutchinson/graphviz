package ca.attractors.dot.attribute.type;

import ca.attractors.util.Strings;

public enum NodeShapeType implements IDotAttributeValue {
	Box("box"),
	Polygon("polygon"),
	Elipse("elipse"),
	NONE("none");
	
	private final String value;
	
	private NodeShapeType(String aValue) {
		value = aValue;
	}
	
	public String getValue() {
		return value;
	}

	public String toDotString() {
		return Strings.quoted(getValue());
	}

}