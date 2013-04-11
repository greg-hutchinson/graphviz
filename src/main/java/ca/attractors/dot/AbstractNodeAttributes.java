package ca.attractors.dot;

import ca.attractors.dot.color.IColor;
import ca.attractors.dot.html.HtmlLabel;

/**
 * @see AbstractEdgeAttributes for the generic documentation for these types of classes 
 * (i.e. AbstractXxxAttributes where Xxx is variable. )
 **/

public abstract class AbstractNodeAttributes extends AbstractDotLanguageObject implements IGraphElement {
	private static final String LABEL = "label";
	private static final String FILLCOLOR = "fillcolor";
	private static final String SHAPE = "shape";
	private static final String STYLE = "style";
	private static final String WIDTH = "width";
	private static final String HEIGHT = "height";

	public String getLabel() {
		return getString(LABEL);
	}

	public void setLabel(String aLabel) {
		set(LABEL, aLabel);
	}
	
	public HtmlLabel getHtmlLabel() {
		return getHtmlLabel(LABEL);
	}
	
	public void setHtmlLabel(HtmlLabel aLabel) {
		set(LABEL, aLabel);
	}

	public IColor getFillColor() {
		return (IColor) get(FILLCOLOR);
	}

	public void setFillColor(IColor aFillColor) {
		set(FILLCOLOR, aFillColor);
	}

	public String getShape() {
		return getString(SHAPE);
	}

	public void setShape(String aShape) {
		set(SHAPE, aShape);
	}

	public String getStyle() {
		return getString(STYLE);
	}

	public void setStyle(String aStyle) {
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
