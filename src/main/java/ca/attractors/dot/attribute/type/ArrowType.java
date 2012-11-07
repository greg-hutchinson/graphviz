package ca.attractors.dot.attribute.type;

//TODO,Arrows are actually more complex than just an enum--see other Arrow*Type classes,RF
public enum ArrowType implements IDotAttributeValue {
	BOX("box"),
	CROW("crow"),
	DIAMOND("diamond"),
	DOT("dot"),
	EDIAMOND("ediamond"),
	EMPTY("empty"),
	NONE("none"),
	NORMAL("normal"),
	HALFOPEN("halfopen"),
	INV("inv"),
	INVDOT("invdot"),
	INVEMPTY("invempty"),
	INVODOT("invodot"),
	OBOX("obox"),
	ODIAMOND("odiamond"),
	ODOT("odot"),
	OPEN("open"),
	TEE("tee"),
	VEE("vee");
	
	private final String value;
	
	private ArrowType(String aValue) {
		value = aValue;
	}
	
	public String getValue() {
		return value;
	}
}
