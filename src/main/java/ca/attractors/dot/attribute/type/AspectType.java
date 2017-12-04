package ca.attractors.dot.attribute.type;

import ca.attractors.util.Strings;

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

	public String toDotString() {
		return Strings.quoted(getValue());
	}

}
