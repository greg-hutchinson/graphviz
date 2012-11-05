package ca.attractors.dot;

public class Edge extends DotType {
	private static final String LABEL = "label";
	private static final String FILLCOLOR = "fillcolor";
	private static final String COLOR = "color";
	private static final String STYLE = "style";

	private String from;
	private String to;
	private GraphType graphType;

	public Edge(String aFrom, String aTo, GraphType aGraphType) {
		from = aFrom;
		to = aTo;
		graphType = aGraphType;
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

	public void setStyle(String aStyle) {
		set(STYLE, aStyle);
	}

	public void setColor(String aString) {
		set(COLOR, aString);
	}

	public String getColor() {
		return get(COLOR);
	}

	protected String getAttributesAsDotString() {
		return getBracketedAttributesAsDotString();
	}


	public String getStartDefinitionAsDotString() {
		return from + " " + getEdgeString() + " " + to;
	}

	private String getEdgeString() {
		return graphType.getEdgeString();
	}
}
