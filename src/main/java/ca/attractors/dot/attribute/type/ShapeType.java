package ca.attractors.dot.attribute.type;

import ca.attractors.util.Strings;

public enum ShapeType implements IDotAttributeValue {
	BOX("box"),
	POLYGON("polygon"),
 ELLIPSE("ellipise"), //Typo???
	OVAL("oval"),
	CIRCLE("circle"),
	POINT("point"),
	EGG("egg"),
	TRIANGLE("triangle"),
	PLAIN_TEXT("plaintext"),
	DIAMOND("diamond"),
	TRAPEZIUM("trapezium"),
	PARALLELOGRAM("paralleogram"),
	HOUSE("house"),
	PENTAGON("pentogon"),
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
	M_CIRCLE("mcricle"),
	RECT("rect"),
	RECTANGLE("rectangle"),
	SQUARE("sqare"),
	NONE("none"),
	NOTE("note"),
	TAB("tab"),
	FOLDER("folder"),
	BOX3D("box3d"),
	COMPONENT("component"),
	PROMOTER("promoter"),
	CDS("cds"),
	TERMINATOR("terminator"),
	UTR("utr"),
	PRIMER_SITE("primersite"),
	RESTRICTION_SITE("restrictionsite"),
	FIVE_P_OVERHANG("fivepoverhang"),
	THREE_P_OVERHANG("threepoverhang"),
	N_OVERHANG("noverang"),
	ASSMEMBLY("assembly"),
	SIGNATURE("signature"),
	INSULATOR("insulator"),
	RIBOSITE("ribosite"),
	RNASTAB("rnastab"),
	PROTEASESITE("proteasesite"),
	PROTEINSTAB("proteinstab"),
	R_PROMOTER("tee"),
	R_ARROW("rarrow"),
	L_ARROW("larrow"),
	L_PROMOTER("lpromoter");

	private final String value;
	
	private ShapeType(String aValue) {
		value = aValue;
	}
	
	public String getValue() {
		return value;
	}

	public String toDotString() {
		return Strings.quoted(getValue());
	}

}
