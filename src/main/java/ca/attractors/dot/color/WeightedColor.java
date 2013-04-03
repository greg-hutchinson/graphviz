package ca.attractors.dot.color;

/**
 * This class is not quite accurate because a color cannot be a colorList
 * I also can't seem to make any sense out of these weighted colors in practice
 */

public class WeightedColor implements IDotColor {

	private Float weight;
	private IDotColor color;

	public String getValue() {
		if (weight == null)
			return color.getValue();
		return color.getValue() + ";" + weight.toString();
	}

	public WeightedColor(IDotColor aColor, Float aWeight) {
		color = aColor;
		weight = aWeight;
	}

}
