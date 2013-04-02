package ca.attractors.dot;

import ca.attractors.util.Strings;

public class Edge extends EdgeAttributes {
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

	private String getEdgeString() {
		return graphType.getEdgeString();
	}
}
