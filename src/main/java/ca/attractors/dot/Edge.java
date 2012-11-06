package ca.attractors.dot;

public class Edge extends DotObject<EdgeAttributes> implements IGraphElement {

	private String from;
	private String to;
	private GraphType graphType;

	protected Edge(String aFrom, String aTo, GraphType aGraphType) {
		super(new EdgeAttributes());
		from = aFrom;
		to = aTo;
		graphType = aGraphType;
	}

	protected Edge(Node aFromNode, Node aToNode, GraphType aType) {
		this(aFromNode.getName(), aToNode.getName(), aType);
	}

	public String getDefinition() {
		return from + " " + getEdgeString() + " " + to;
	}

	@Override
	protected CharSequence getDefinitionBody() {
		return getAttributes().getDefinitionBody();
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

	private String getEdgeString() {
		return graphType.getEdgeString();
	}
}
