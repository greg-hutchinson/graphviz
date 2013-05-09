package ca.attractors.dot;

import ca.attractors.dot.attribute.type.RatioType;
import ca.attractors.dot.color.IColor;

/**
 * @see AbstractEdgeAttributes for the generic documentation for these types of classes 
 * (i.e. AbstractXxxAttributes where Xxx is variable. )
 **/

public abstract class AbstractGraphAttributes extends AbstractDotLanguageObject {
	private static final String BG_COLOR = "bgcolor";
	private static final String SPLINES = "splines";
	private static final String RANK_SEP = "ranksep";
	private static final String NODE_SEP = "nodesep";
	private static final String RATIO = "ratio";
	
	private static final String PAGE_SIZE = "page";
	private static final String SIZE = "size";

	public void setBackgroundColor(IColor aColor) {
		set(BG_COLOR, aColor);
	}

	public IColor getBackgroundColor() {
		return (IColor) get(BG_COLOR);
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

	public void setNodeSep(String aString) {
		set(NODE_SEP, aString);
	}

	public String getNodeSep() {
		return getString(NODE_SEP);
	}
	
	public RatioType getRatio() {
		return (RatioType) get(RATIO);
	}
	
	public void setRatio(RatioType aRatio) {
		set(RATIO, aRatio);
	}
	
	public String getNumericRatio() {
		return getString(RATIO);
	}
	
	public void setNumericRatio(String aRatio) {
		set(RATIO, aRatio);
	}
	
	public Dimension getPageDimension() {
		return (Dimension) get(PAGE_SIZE);
	}
	
	public void setPageDimension(Dimension aDimension) {
		set(PAGE_SIZE, aDimension);
	}
	
	public Dimension getSizeDimension() {
		return (Dimension) get(SIZE);
	}
	
	public void setSizeDimension(Dimension aDimension) {
		set(SIZE, aDimension);
	}
}
