package ca.attractors.dot;

public interface IGraphElement {

	public abstract String getColor();

	public abstract void setColor(String aString);

	public abstract void setStyle(String aStyle);

	public abstract String getStyle();

	public abstract void setFillColor(String aFillColor);

	public abstract String getFillColor();

	public abstract void setLabel(String aLabel);

	public abstract String getLabel();

	public String toDotString();

}
