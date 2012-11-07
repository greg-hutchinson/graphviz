package ca.attractors.dot.attribute.type;

public enum ClusterModeType implements IDotAttributeValue {
	LOCAL("local"),
	GLOBAL("global"),
	NONE("none");
	
	private final String value;
	
	private ClusterModeType(String aValue) {
		value = aValue;
	}
	
	public String getValue() {
		return value;
	}
}
