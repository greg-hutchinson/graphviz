package ca.attractors.dot.attribute.type;

import ca.attractors.util.Strings;

public enum RankDirType implements IDotAttributeValue {
	TB("TB"),
	LR("LR"),
	BT("BT"),	//This used to be BR - no such thing
	RL("RL");
	
	private final String value;
	
	private RankDirType(String aValue) {
		value = aValue;
	}
	
	public String getValue() {
		return value;
	}

	public String toDotString() {
		return Strings.quoted(getValue());
	}

}
