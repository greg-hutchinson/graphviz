package ca.attractors.dot;

import ca.attractors.dot.attribute.type.IDotAttributeValue;
import ca.attractors.util.Strings;

/**
 * Describes a dimension. Units are implicitly inches.
 */
public class Dimension implements IDotAttributeValue {
	private String height, width;
	
	/**
	 * @param anInches the size of the length of a square in inches
	 */
	Dimension(String anInches) {
		if (anInches == null)
			throw new NullPointerException("cannot have null dimension");
		height = anInches;
	}

	Dimension(String aHeight, String aWidth) {
		if ((aHeight == null) || (aWidth == null))
			throw new NullPointerException("cannot have null dimension");
		height = aHeight;
		width = aWidth;
	}

	public String getHeight() {
		return height;
	}

	public String getWidth() {
		return width;
	}
	
	public String getValue() {
		return (width == null) ? height : height + "," + width;
	}
	
	public String toDotString() {
		return Strings.quoted(getValue());
	}
}
