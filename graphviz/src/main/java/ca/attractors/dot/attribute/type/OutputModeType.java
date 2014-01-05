package ca.attractors.dot.attribute.type;

import ca.attractors.util.Strings;

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

	public String toDotString() {
		return Strings.quoted(getValue());
	}

}
