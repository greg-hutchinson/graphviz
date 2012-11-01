package ca.attractors.dot;

public enum GraphType {
	DIGRAPH, GRAPH;

	public String getEdgeString() {
		if (this == DIGRAPH)
			return "->";
		return "--";
	}

}
