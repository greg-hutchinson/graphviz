package ca.attractors.dot.attribute.type;

public enum OutputModeType implements IDotAttributeValue {
	BREADTH_FIRST("breadthfirst"),
	NODES_FIRST("nodesfirst"),
	EDGES_FIRST("edgesfirst");
	
	private final String value;
	
	private OutputModeType(String aValue) {
		value = aValue;
	}
	
	public String getValue() {
		return value;
	}
}
