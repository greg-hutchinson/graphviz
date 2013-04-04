package ca.attractors.dot.attribute.type;

import ca.attractors.util.Strings;

public enum ArrowShapeType implements IDotAttributeValue {
	BOX("box"),
	CROW("crow"),
	CURVE("curve"),
	DIAMOND("diamond"),
	DOT("dot"),
	INV("inv"),
	NONE("none"),
    NORMAL("normal"),
	TEE("tee"),
	VEE("vee");
	
	private final String value;
	
	private ArrowShapeType(String aValue) {
		value = aValue;
	}
	
	public String getValue() {
		return value;
	}

	public String toDotString() {
		return Strings.quoted(getValue());
	}

}
