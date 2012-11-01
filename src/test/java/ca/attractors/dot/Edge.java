package ca.attractors.dot;

public class Edge extends DotType {
	private String from;
	private String to;
	private EdgeAttributes attributes;
	private GraphType graphType;

	public Edge(String aFrom, String aTo, GraphType aGraphType) {
		from = aFrom;
		to = aTo;
		attributes = new EdgeAttributes();
		graphType = aGraphType;
	}

	public EdgeAttributes getAttributes() {
		return attributes;
	}

	public String toDotString() {
		return from + " " + getEdgeString() + " " + to + " " + attributes.toDotString() + "\n";
	}

	private String getEdgeString() {
		return graphType.getEdgeString();
	}
}
