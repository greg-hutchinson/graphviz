package ca.attractors.dot.attribute.type;

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
}
