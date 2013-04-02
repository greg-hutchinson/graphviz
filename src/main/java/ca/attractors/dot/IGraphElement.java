package ca.attractors.dot;

public interface IGraphElement {
	protected static final String LABEL = "label";

	public abstract String getColor();

	public abstract void setColor(String aString);

	public abstract void setStyle(String aStyle);

	public abstract String getStyle();

	public abstract void setFillColor(String aFillColor);

	public abstract String getFillColor();

	public abstract void setLabel(String aLabel);

	public abstract String getLabel();

	protected static final String FILLCOLOR = "fillcolor";
	protected static final String COLOR = "color";
	protected static final String STYLE = "style";

	public String toDotString();

}
