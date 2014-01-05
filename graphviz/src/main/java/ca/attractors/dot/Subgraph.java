package ca.attractors.dot;

public class Subgraph extends Graph implements IGraphElement {

	private static final String RANK = "rank";

	protected Subgraph(String aName, GraphType aGraphType) {
		super(aName, aGraphType);
	}

	protected String getGraphTypeString() {
		return "subgraph";
	}

	@Override
	public boolean equals(Object aObj) {
		if (!(aObj instanceof Subgraph))
			return false;
		Subgraph other = (Subgraph) aObj;
		return other.getName().equals(getName());
	}

	public String getRank() {
		return getString(RANK);
	}

	public void setRank(String aRank) {
		set(RANK, aRank);
	}

}
