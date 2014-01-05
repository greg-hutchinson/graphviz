package ca.attractors.dot;

import ca.attractors.util.Strings;

public class Edge extends AbstractEdgeAttributes {
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

	@Override
	public String getDefinition() {
		return Strings.quoted(from) + " " + getEdgeString() + " " + Strings.quoted(to);
	}

	private String getEdgeString() {
		return graphType.getEdgeString();
	}

	@Override
	protected boolean isRedundantDefinition() {
		return false; //Edges are never redundant
	}

}
