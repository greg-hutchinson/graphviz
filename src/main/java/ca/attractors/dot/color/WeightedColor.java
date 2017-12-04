package ca.attractors.dot.color;

import ca.attractors.dot.attribute.type.ColorSchemeType;
import ca.attractors.util.Strings;

/**
 * This class is not quite accurate because a color cannot be a colorList
 * I also can't seem to make any sense out of these weighted colors in practice
 */

public class WeightedColor implements ITerminalColor {

	private Float weight;
	private ITerminalColor color;

	public WeightedColor(ITerminalColor aColor) {
		color = aColor;
		weight = null;
	}

	public WeightedColor(ITerminalColor aColor, Float aWeight) {
		if (aWeight == null)
			throw new NullPointerException("Weight should not be null - see other constructors");
		color = aColor;
		weight = aWeight;
	}

	public String getValue() {
		if (weight == null)
			return color.getValue();
		return color.getValue() + ";" + weight.toString();
	}

	public String toDotString() {
		return Strings.quoted(getValue());
	}

	public ColorSchemeType getColorScheme() {
		return color.getColorScheme();
	}

}
