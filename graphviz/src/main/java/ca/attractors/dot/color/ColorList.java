package ca.attractors.dot.color;

import java.util.ArrayList;
import java.util.List;

import ca.attractors.dot.attribute.type.ColorSchemeType;
import ca.attractors.util.Strings;

public class ColorList implements IColorList {
	private List<IColor> colors = new ArrayList<IColor>();
	private ColorSchemeType colorScheme;

	public String getValue() {
		String colon = "";
		String result = "";
		for (IColor color : colors) {
			result = result + colon + color.getValue();
			colon = ":";
		}
		return result;
	}

	public String toString() {
		return getValue();
	}
	public String toDotString() {
		return Strings.quoted(getValue());
	}

	public void addColor(IColor aColor) {
		if (aColor == null)
			throw new NullPointerException("cannot add null to color list");
		if (colorScheme == null)
			colorScheme = aColor.getColorScheme();
		if (aColor.getColorScheme() != colorScheme)
			throw new IllegalArgumentException("cannot mix color schemes in a color list");
		
		colors.add(aColor);
	}

	public ColorSchemeType getColorScheme() {
		return colorScheme;
	}
}
