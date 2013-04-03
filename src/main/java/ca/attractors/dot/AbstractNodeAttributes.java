package ca.attractors.dot;

import ca.attractors.dot.attribute.type.IDotColor;

/**
 * @see AbstractEdgeAttributes for the generic documentation for these types of classes 
 * (i.e. AbstractXxxAttributes where Xxx is variable. )
 **/

public abstract class AbstractNodeAttributes extends AbstractDotLanguageObject implements IGraphElement {
	private static final String LABEL = "label";
	private static final String FILLCOLOR = "fillcolor";
	private static final String STYLE = "style";


	public String getLabel() {
		return getString(LABEL);
	}

	public void setLabel(String aLabel) {
		set(LABEL, aLabel);
	}

	public IDotColor getFillColor() {
		return (IDotColor) get(FILLCOLOR);
	}

	public void setFillColor(IDotColor aFillColor) {
		set(FILLCOLOR, aFillColor);
	}

	public String getStyle() {
		return getString(STYLE);
	}

	public void setStyle(String aStyle) {
		set(STYLE, aStyle);
	}

}
