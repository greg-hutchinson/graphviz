package ca.attractors.dot;


public abstract class AbstractNodeAttributes extends DotObject implements IGraphElement {
	private static final String LABEL = "label";
	private static final String FILLCOLOR = "fillcolor";
	private static final String STYLE = "style";


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

	public void setStyle(String aStyle) {
		set(STYLE, aStyle);
	}

}
