package ca.attractors.dot.color;

import java.util.List;

public class ColorList implements IDotColor {
	private List<IDotColor> colors;

	public String getValue() {
		String colon = "";
		String result = "";
		for (IDotColor color : colors) {
			result = result + colon + color.getValue();
			colon = ":";
		}
		return result;
	}

}
