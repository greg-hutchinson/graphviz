package ca.attractors.dot;

/**
 * @see AbstractEdgeAttributes for the generic documentation for these types of classes 
 * (i.e. AbstractXxxAttributes where Xxx is variable. )
 **/

public abstract class AbstractGraphAttributes extends AbstractDotLanguageObject {
	private static final String BG_COLOR = "bgcolor";

	public void setBackgroundColor(String aString) {
		set(BG_COLOR, aString);
	}

	public String getBackgroundColor() {
		return getString(BG_COLOR);
	}

}
