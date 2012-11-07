package ca.attractors.dot.attribute.type;

public enum SmoothType implements IDotAttributeValue {
	NONE("none"),
	AVG_DIST("avg_dist"),
	GRAPH_DIST("graph_dist"),	
	POWER_DIST("power_dist"),	
	RNG("rng"),	
	SPRING("spring"),	
	TRIANGLE("triangle");

	private final String value;
	
	private SmoothType(String aValue) {
		value = aValue;
	}
	
	public String getValue() {
		return value;
	}
}
