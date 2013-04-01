package ca.attractors.dot;

public class EdgeAttributes extends DotObjectAttributes {
	private static final String LABEL = "label";
	private static final String FILLCOLOR = "fillcolor";
	private static final String COLOR = "color";
	private static final String STYLE = "style";

	public String getFillColor() {
		return get(FILLCOLOR);
	}

	public void setStyle(String aStyle) {
		set(STYLE, aStyle);
	}

	@Override
	protected CharSequence getDefinition() {
		return "Edge";
	}

}
