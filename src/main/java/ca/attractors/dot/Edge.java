package ca.attractors.dot;

public class Edge extends DotObject<EdgeAttributes> {

	private String from;
	private String to;
	private GraphType graphType;

	public Edge(String aFrom, String aTo, GraphType aGraphType) {
		super(new EdgeAttributes());
		from = aFrom;
		to = aTo;
		graphType = aGraphType;
	}

	public String getLabel() {
		return getAttributes().getLabel();
	}

	public void setLabel(String aLabel) {
		getAttributes().setLabel(aLabel);
	}

	public String getFillColor() {
		return getAttributes().getFillColor();
	}

	public void setFillColor(String aFillColor) {
		getAttributes().setFillColor(aFillColor);
	}

	public String getStyle() {
		return getAttributes().getStyle();
	}

	public void setStyle(String aStyle) {
		getAttributes().setStyle(aStyle);
	}

	public void setColor(String aString) {
		getAttributes().setColor(aString);
	}

	public String getColor() {
		return getAttributes().getColor();
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
