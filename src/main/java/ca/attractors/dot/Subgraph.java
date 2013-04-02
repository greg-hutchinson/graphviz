package ca.attractors.dot;

public class Subgraph extends Graph implements IGraphElement {

	protected Subgraph(String aName, GraphType aGraphType) {
		super(aName, aGraphType);
	}

	protected String getGraphTypeString() {
		return "subgraph";
	}

	public String getColor() {
		return null;
	}

	public void setColor(String aString) {
	}

	public void setStyle(String aStyle) {
	}

	public String getStyle() {
		return null;
	}

	public void setFillColor(String aFillColor) {
	}

	public String getFillColor() {
		return null;
	}

	public void setLabel(String aLabel) {
	}

	public String getLabel() {
		return null;
	}

}
