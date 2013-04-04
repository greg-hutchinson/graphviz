package ca.attractors.dot.attribute.type;

import ca.attractors.util.Strings;

public enum PageDirType implements IDotAttributeValue {
	BL("BL"),
	BR("BR"),
	TL("TL"),
	TR("TR"),
	RB("RB"),
	RT("RT"),
	LB("LB"),
	LT("LT");
	
	private final String value;
	
	private PageDirType(String aValue) {
		value = aValue;
	}
	
	public String getValue() {
		return value;
	}

	public String toDotString() {
		return Strings.quoted(getValue());
	}

}
