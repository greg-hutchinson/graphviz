package ca.attractors.dot.attribute.type;

public enum DirType  implements IDotAttributeValue {
	FORWARD("forward"),
	BACK("back"),
	BOTH("both"),
	NONE("none");
	
	private final String value;
	
	private DirType(String aValue) {
		value = aValue;
	}
	
	public String getValue() {
		return value;
	}
}
