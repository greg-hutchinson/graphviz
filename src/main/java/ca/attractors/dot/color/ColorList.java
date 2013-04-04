package ca.attractors.dot.color;

import java.util.List;

public class ColorList implements IColorList {
	private List<IColor> colors;

	public String getValue() {
		String colon = "";
		String result = "";
		for (IColor color : colors) {
			result = result + colon + color.getValue();
			colon = ":";
		}
		return result;
	}

}
