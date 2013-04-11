package ca.attractors.dot;

/**
 * @see AbstractEdgeAttributes for the generic documentation for these types of classes 
 * (i.e. AbstractXxxAttributes where Xxx is variable. )
 **/

public abstract class AbstractGraphAttributes extends AbstractDotLanguageObject {
	private static final String BG_COLOR = "bgcolor";
	private static final String SPLINES = "splines";
	private static final String RANK_SEP = "ranksep";

	public void setBackgroundColor(String aString) {
		set(BG_COLOR, aString);
	}

	public String getBackgroundColor() {
		return getString(BG_COLOR);
	}

	public void setSplines(String aString) {
		set(SPLINES, aString);
	}

	public String getSplines() {
		return getString(SPLINES);
	}

	public void setRankSep(String aString) {
		set(RANK_SEP, aString);
	}

	public String getRankSep() {
		return getString(RANK_SEP);
	}
}
