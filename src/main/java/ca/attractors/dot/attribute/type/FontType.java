package ca.attractors.dot.attribute.type;

import ca.attractors.util.Strings;

public enum FontType implements IDotAttributeValue {
	Antiqua("Antiqua"),
	Arial("Arial"),
	Avqest("Avqest"),
	Blackletter("Blackletter"),
	Calibri("Calibri"),
	ComicSans("Comic Sans MS"),
	Courier("Courier"),
	Decorative("Decorative"),
	Fraktur("Fraktur"),
	Frosty("Frosty"),
	Garamond("Garamond"),
	Georgia("Georgia"),
	Helvetica("Helvetica"),
	Impact("Impact"),
	Minion("Minion"),
	Modern("Modern"),
	Monospace("Monospace"),
	Palatino("Palatino"),
	Roman("Roman"),
	Script("Script"),
	Swiss("Swiss"),
	TimesNewRoman("Times New Roman"),
	Verdana("Verdana");
	
	private final String value;
	
	private FontType(String aValue) {
		value = aValue;
	}
	
	public String getValue() {
		return value;
	}

	public String toDotString() {
		return Strings.quoted(getValue());
	}

}
