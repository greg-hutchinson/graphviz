package ca.attractors.dot.color;

import java.util.ArrayList;
import java.util.List;

import ca.attractors.util.Strings;

public class ColorList implements IColorList {
	private List<IColor> colors = new ArrayList<IColor>();

	public String getValue() {
		String colon = "";
		String result = "";
		for (IColor color : colors) {
			result = result + colon + color.getValue();
			colon = ":";
		}
		return result;
	}

	public String toDotString() {
		return Strings.quoted(getValue());
	}

	public void addColor(IColor aColor) {
		colors.add(aColor);
	}

}
