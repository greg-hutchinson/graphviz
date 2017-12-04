package ca.attractors.dot.attribute.type;

import ca.attractors.util.Strings;

public enum RankType implements IDotAttributeValue {
	SAME("same"),
	MIN("min"),
	SOURCE("source"),
	MAX("max"),
	SINK("sink");
	
	private final String value;
	
	private RankType(String aValue) {
		value = aValue;
	}
	
	public String getValue() {
		return value;
	}

	public String toDotString() {
		return Strings.quoted(getValue());
	}

}
