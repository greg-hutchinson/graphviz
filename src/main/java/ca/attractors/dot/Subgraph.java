package ca.attractors.dot;

public class Subgraph extends Graph implements IGraphElement {

	protected Subgraph(String aName, GraphType aGraphType) {
		super(aName, aGraphType);
	}

	protected String getGraphTypeString() {
		return "subgraph";
	}

}
