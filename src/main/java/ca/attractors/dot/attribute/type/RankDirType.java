package ca.attractors.dot.attribute.type;

public enum RankDirType implements IDotAttributeValue {
	TB("TB"),
	LR("LR"),
	BR("BR"),
	RL("RL");
	
	private final String value;
	
	private RankDirType(String aValue) {
		value = aValue;
	}
	
	public String getValue() {
		return value;
	}
}
