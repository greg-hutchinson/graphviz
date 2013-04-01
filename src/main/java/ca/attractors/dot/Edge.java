package ca.attractors.dot;

import java.io.PrintStream;

import ca.attractors.util.Strings;

public class Edge extends DotObject implements IGraphElement {
	private static final String LABEL = "label";
	private static final String FILLCOLOR = "fillcolor";
	private static final String COLOR = "color";
	private static final String STYLE = "style";


	private String from;
	private String to;
	private GraphType graphType;

	protected Edge(String aFrom, String aTo, GraphType aGraphType) {
		from = aFrom;
		to = aTo;
		graphType = aGraphType;
	}

	protected Edge(Node aFromNode, Node aToNode, GraphType aType) {
		this(aFromNode.getName(), aToNode.getName(), aType);
	}

	public String getDefinition() {
		return Strings.quoted(from) + " " + getEdgeString() + " " + Strings.quoted(to);
	}

	protected String getQuotedFrom() {
		return Strings.quoted(from);
	}

	public void toDotStringOn(PrintStream aPrintStream) {
		aPrintStream.append(getDefinition());
		aPrintStream.append(attributesToDotString());
		aPrintStream.append("\n");
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

	private String getEdgeString() {
		return graphType.getEdgeString();
	}
}
