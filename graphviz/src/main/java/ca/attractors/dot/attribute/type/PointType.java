package ca.attractors.dot.attribute.type;

import ca.attractors.util.Strings;

public final class PointType implements IDotAttributeValue {
	
	private final double x;
	private final double y;
	private final Double z;
	private final boolean nodePositionShouldNotChange;
	
	public PointType(double anX, double aY) {
		this(anX, aY, false);
	}
	
	public PointType(double anX, double aY, double aZ) {
		this(anX, aY, aZ, false);
	}
	
	public PointType(double anX, double aY, boolean aNodePositionShouldNotChange) {
		x = anX;
		y = aY;
		z = null;
		nodePositionShouldNotChange = aNodePositionShouldNotChange;
	}
	
	public PointType(double anX, double aY, double aZ, boolean aNodePositionShouldNotChange) {
		x = anX;
		y = aY;
		z = aZ;
		nodePositionShouldNotChange = aNodePositionShouldNotChange;
	}
	
	public String getValue() {
		return String.valueOf(x) + "," + String.valueOf(y) + (z != null ? "," + z : "") + (nodePositionShouldNotChange ? "!" : "");
	}

	public String toDotString() {
		return Strings.quoted(getValue());
	}

}
