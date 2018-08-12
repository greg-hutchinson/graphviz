package ca.attractors.dot;

import ca.attractors.dot.attribute.type.DoubleDotAttributeValue;
import ca.attractors.dot.attribute.type.RankDirType;
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
	private static final String RANK_DIR_TYPE = "rankdir";
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

	public void setRankSep(Double aValue) {
		set(RANK_SEP, new DoubleDotAttributeValue(aValue));
	}

	public Double getRankSep() {
		return ((DoubleDotAttributeValue) get(RANK_SEP)).getDoubleValue();
	}

	public void setNodeSep(Double aValue) {
		set(NODE_SEP, new DoubleDotAttributeValue(aValue));
	}

	public Double getNodeSep() {
		return ((DoubleDotAttributeValue) get(NODE_SEP)).getDoubleValue();
	}
	
	public RatioType getRatio() {
		Object o = get(RATIO);
		if (o == null)
			return null;
		if (o instanceof RatioType)
			return (RatioType) o;
		if (o instanceof DoubleDotAttributeValue)
			return RatioType.Numeric;
		 throw new IllegalStateException("some strange object found in the ratio: " + o);
	}
	
	public void setRatio(RatioType aRatio) {
		set(RATIO, aRatio);
	}
	
	public Double getNumericRatio() {
		return ((DoubleDotAttributeValue) get(RATIO)).getDoubleValue();
	}
	
	public void setNumericRatio(Double aRatio) {
		set(RATIO, new DoubleDotAttributeValue(aRatio));
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

	public RankDirType getRankDirType() {
		return (RankDirType) get(RANK_DIR_TYPE);
	}

	public void setRankDir(RankDirType aType) {
		set(RANK_DIR_TYPE, aType);
	}
}
