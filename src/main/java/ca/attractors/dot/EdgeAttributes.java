package ca.attractors.dot;

public class EdgeAttributes extends DotObject {
	@Override
	protected CharSequence getDefinition() {
		return "Edge";
	}

	public String getLabel() {
		return get(LABEL);
	}

	public void setLabel(String aLabel) {
		set(LABEL, aLabel);
	}

	public String getFillColor() {
		return get(FILLCOLOR);
	}

	public void setFillColor(String aFillColor) {
		set(FILLCOLOR, aFillColor);
	}

	public String getStyle() {
		return get(STYLE);
	}

	@Override
	public void setStyle(String aStyle) {
		set(STYLE, aStyle);
	}

	@Override
	public void setColor(String aString) {
		set(COLOR, aString);
	}

	@Override
	public String getColor() {
		return get(COLOR);
	}

}
