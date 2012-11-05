package ca.attractors.dot;

import ca.attractors.dot.graphelements.GraphElementAttributes;

public abstract class DotType<M extends GraphElementAttributes> extends DotObject {
	private static final String FONTNAME = "fontname";
	private static final String URL = "URL";
	private static final String COLOR_SCHEME = "colorscheme";
	private static final String COMMENT = "comment";
	private M attributes;

	protected M getAttributes() {
		return attributes;
	}


	@Override
	public String toDotString() {
		return getStartDefinitionAsDotString() + getAttributesAsDotString() + getEndDefinitionAsDotString();
	}

	protected String getEndDefinitionAsDotString() {
		return "\n";
	}

	protected abstract String getStartDefinitionAsDotString();

	protected abstract String getAttributesAsDotString();

	protected String getBracketedAttributesAsDotString() {
		return attributes.getBracketAttributesAsDotString();
	}

	protected String getRawAttributesAsDotString() {
		return attributes.getRawAttributesAsDotString();
	}

	protected String get(String aKey) {
		return attributes.get(aKey);
	}

	protected void set(String aKey, String aValue) {
		attributes.set(aKey, aValue);
	}

	public String getFontname() {
		return get(FONTNAME);
	}

	public void setFontname(String aFontname) {
		set(FONTNAME, aFontname);
	}

	public String getUrl() {
		return get(URL);
	}

	public void setUrl(String aUrl) {
		set(URL, aUrl);
	}

	public String getColorScheme() {
		return get(COLOR_SCHEME);
	}

	public void setColorScheme(String aColorScheme) {
		set(COLOR_SCHEME, aColorScheme);
	}

	public String getComment() {
		return get(COMMENT);
	}

	public void setComment(String aComment) {
		set(COMMENT, aComment);
	}

}
