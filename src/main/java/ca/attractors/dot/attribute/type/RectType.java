package ca.attractors.dot.attribute.type;

import ca.attractors.util.Strings;

public final class RectType implements IDotAttributeValue {
	
	private final double llx;
	private final double lly;
	private final double urx;
	private final double ury;
	
	public RectType(double aLowerLeftX, double aLowerLeftY, double anUpperRightX, double anUpperRightY) {
		llx = aLowerLeftX;
		lly = aLowerLeftY;
		urx = anUpperRightX;
		ury = anUpperRightY;
	}
	
	public String getValue() {
		return String.valueOf(llx) + "," + String.valueOf(lly) + "," + String.valueOf(urx) + "," + String.valueOf(ury);
	}

	public String toDotString() {
		return Strings.quoted(getValue());
	}

}
