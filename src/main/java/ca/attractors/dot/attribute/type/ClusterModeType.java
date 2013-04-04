package ca.attractors.dot.attribute.type;

import ca.attractors.util.Strings;

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

	public String toDotString() {
		return Strings.quoted(getValue());
	}

}
