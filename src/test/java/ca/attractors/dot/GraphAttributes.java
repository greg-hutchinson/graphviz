package ca.attractors.dot;


public class GraphAttributes extends Attributes {
	private static final String COLOR = "color";

	public GraphAttributes() {
	}

	public String getColor() {
		return get(COLOR);
	}
	public void setColor(String aFillColor) {
		set(COLOR, aFillColor);
	}
}
