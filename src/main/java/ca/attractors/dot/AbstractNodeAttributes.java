package ca.attractors.dot;

import ca.attractors.dot.attribute.type.NodeShapeType;
import ca.attractors.dot.attribute.type.NodeStyleType;
import ca.attractors.dot.color.IColor;

/**
 * @see AbstractEdgeAttributes for the generic documentation for these types of classes 
 * (i.e. AbstractXxxAttributes where Xxx is variable. )
 **/

public abstract class AbstractNodeAttributes extends AbstractDotLanguageObject implements IGraphElement {
	private static final String FILLCOLOR = "fillcolor";
	private static final String BACKGROUND_COLOR = "bgcolor";
	private static final String COLOR = "color";
	private static final String SHAPE = "shape";
	private static final String STYLE = "style";
	private static final String WIDTH = "width";
	private static final String HEIGHT = "height";

	public void setBackgroundColor(IColor aColor) {
		set(BACKGROUND_COLOR, aColor);
	}

	public IColor getBackgroundColor() {
		return (IColor) get(BACKGROUND_COLOR);
	}
	
	public void setColor(IColor aString) {
		set(COLOR, aString);
	}

	public IColor getColor() {
		return (IColor) get(COLOR);
	}


	public IColor getFillColor() {
		return (IColor) get(FILLCOLOR);
	}

	public void setFillColor(IColor aFillColor) {
		set(FILLCOLOR, aFillColor);
	}

	public NodeShapeType getShape() {
		return (NodeShapeType) get(SHAPE);
	}

	public void setShape(NodeShapeType aShape) {
		set(SHAPE, aShape);
	}

	public NodeStyleType getStyle() {
		return (NodeStyleType) get(STYLE);
	}

	public void setStyle(NodeStyleType aStyle) {
		set(STYLE, aStyle);
	}

	public String getWidth() {
		return getString(WIDTH);
	}

	public void setWidth(String aStyle) {
		set(WIDTH, aStyle);
	}

	public String getHeight() {
		return getString(HEIGHT);
	}

	public void setHeight(String aStyle) {
		set(HEIGHT, aStyle);
	}

}
