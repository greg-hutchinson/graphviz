package ca.attractors.dot.attribute.type;

public final class AspectType implements IDotAttributeValue {
	
	private final double aspectRatio;
	private final Integer maximumPassCount;
	
	public AspectType(double anAspectRatio) {
		aspectRatio = anAspectRatio;
		maximumPassCount = null;
	}
	
	public AspectType(double anAspectRatio, int aMaximumPassCount) {
		aspectRatio = anAspectRatio;
		maximumPassCount = aMaximumPassCount;
	}
	
	public String getValue() {
		return String.valueOf(aspectRatio) + (maximumPassCount != null ? "," + maximumPassCount : "");
	}

}
