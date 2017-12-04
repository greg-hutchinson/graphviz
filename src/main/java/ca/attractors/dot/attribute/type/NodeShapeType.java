package ca.attractors.dot.attribute.type;

import ca.attractors.util.Strings;

public enum NodeShapeType implements IDotAttributeValue {
	BOX("box"),
	POLYGON("polygon"),
	ELIPSE("elipse"),
	OVAL("oval"),
	CIRCLE("circle"),
	POINT("point"),
	EGG("egg"),
	TRIANGLE("triangle"),
	PLAIN_TEXT("plaintext"),
	DIAMOND("diamond"),
	TRAPEZIUM("trapezium"),
	PARALLELOGRAM("parallelogram"),
	HOUSE("house"),
	PENTAGON("pentagon"),
	HEXAGON("hexagon"),
	SEPTAGON("septagon"),
	OCTAGON("octagon"),
	DOUBLE_CIRCLE("doublecircle"),
	DOUBLE_OCTAGON("doubleoctagon"),
	TRIPLE_OCTAGON("tripleoctagon"),
	INV_TRIANGLE("invtriangle"),
	INV_TRAPEZIUM("invtrapezium"),
	INV_HOUSE("invhouse"),
	M_DIAMOND("mdiamond"),
	M_SQUARE("msquare"),
	M_CIRCLE("mcircle"),
	RECT("rect"),
	RECTANGLE("rectangle"),
	SQUARE("square"),
	NOTE("note"),
	TAB("tab"),
	FOLDER("folder"),
	BOX_3D("box3d"),
	COMPONENT("component"),
	PROMOTER("promoter"),
	CDS("cds"),
	TERMINATOR("terminator"),
	UTR("utr"),
	PRIMERSITE("primersite"),
	RESTRICTION_SITE("restrictionsite"),
	FIVE_POVERHANG("fivepoverhang"),
	THREE_POVERHANG("threepoverhang"),
	NOVERHANG("noverhang"),
	ASSEMBLY("assembly"),
	SIGNATURE("signature"),
	INSULATOR("insulator"),
	RIBOSITE("ribosite"),
	RNASTAB("rnastab"),
	PROTEASESITE("proteasesite"),
	PROTEINSTAB("proteinstab"),
	R_PROMOTER("rpromoter"),
	R_ARROW("rarrow"),
	L_ARROW("larrow"),
	L_PROMOTER("lpromoter");
	
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
