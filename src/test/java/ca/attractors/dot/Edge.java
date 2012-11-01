package ca.attractors.dot;

public class Edge extends DotType {
	private String from;
	private String to;
	private EdgeAttributes attributes;

	public Edge(String aFrom, String aTo) {
		from = aFrom;
		to = aTo;
		attributes = new EdgeAttributes();
	}

	public EdgeAttributes getAttributes() {
		return attributes;
	}

	public String toDotString() {
		return from + " -> " + to + " " + attributes.toDotString() + "\n";
	}
}
