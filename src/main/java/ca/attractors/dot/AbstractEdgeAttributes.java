package ca.attractors.dot;

import ca.attractors.dot.attribute.type.DirType;

/**
 * This class represents all the attribute definitions for its subclasses. Normally there should be no other behaviour here other than
 * the constants that defined the attribute names and the corresponding getters/setters.
 */
public abstract class AbstractEdgeAttributes extends AbstractDotLanguageObject implements IGraphElement {
	private static final String LABEL = "label";
	private static final String FILLCOLOR = "fillcolor";
	private static final String HEADPORT = "headport";
	private static final String TAILPORT = "tailport";
	private static final String COLOR = "color";
	private static final String STYLE = "style";
	private static final String DIR = "dir";

	public DirType getDir() {
		return (DirType) get(DIR);
	}

	public void setDir(DirType aDirType) {
		set(DIR, aDirType);
	}

	public String getLabel() {
		return getString(LABEL);
	}

	public void setLabel(String aLabel) {
		set(LABEL, aLabel);
	}

	public String getFillColor() {
		return getString(FILLCOLOR);
	}

	public void setFillColor(String aFillColor) {
		set(FILLCOLOR, aFillColor);
	}

	public String getStyle() {
		return getString(STYLE);
	}

	public void setStyle(String aStyle) {
		set(STYLE, aStyle);
	}

	public void setColor(String aString) {
		set(COLOR, aString);
	}

	public String getColor() {
		return getString(COLOR);
	}

	public void setHeadPort(String aString) {
		set(HEADPORT, aString);
	}

	public String getHeadPort() {
		return getString(HEADPORT);
	}

	public void setTailPort(String aString) {
		set(TAILPORT, aString);
	}

	public String getTailPort() {
		return getString(TAILPORT);
	}
}
