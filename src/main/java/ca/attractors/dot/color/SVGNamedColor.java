package ca.attractors.dot.color;

import java.awt.Color;

import ca.attractors.dot.attribute.type.ColorSchemeType;
import ca.attractors.util.Strings;

public enum SVGNamedColor implements ITerminalColor {
	MEDIUM_BLUE(0, 0, 205);

	private final Color color;

	private SVGNamedColor(int r, int g, int b) {
		color = new Color(r, g, b);
	}

	public Color getColor() {
		return color;
	}

	public String getValue() {
		return name().toLowerCase();
	}

	public String toDotString() {
		return Strings.quoted(getValue());
	}

	public ColorSchemeType getColorScheme() {
		return ColorSchemeType.SVG;
	}

}
