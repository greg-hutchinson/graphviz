package ca.attractors.dot.color;

import ca.attractors.util.Strings;

/**
 * This class is not quite accurate because a color cannot be a colorList
 * I also can't seem to make any sense out of these weighted colors in practice
 */

public class WeightedColor implements IBasicColor {

	private Float weight;
	private IBasicColor color;

	public WeightedColor(IBasicColor aColor) {
		color = aColor;
		weight = null;
	}

	public WeightedColor(IBasicColor aColor, Float aWeight) {
		if (aWeight == null)
			throw new NullPointerException("Weight should not be null - see other constructors");
		color = aColor;
		weight = aWeight;
	}

	public String getValue() {
		String string = color.getValue();
		if (weight != null)
			string += ";" + weight.toString();
		return Strings.quoted(string);
	}


}
