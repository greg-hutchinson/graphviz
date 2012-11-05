package ca.attractors.dot;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public abstract class DotType extends DotObject {
	private static final String FONTNAME = "fontname";
	private static final String URL = "URL";
	private static final String COLOR_SCHEME = "colorscheme";
	private static final String COMMENT = "comment";
	private Map<String, String> attributes = new HashMap<String, String>();

	protected Map<String, String> getAttributes() {
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
		if (attributes.isEmpty())
			return "";
		StringBuilder builder = new StringBuilder();
		builder.append(" [");
		builder.append(getRawAttributesAsDotString());
		builder.append(']');
		return builder.toString();
	}

	protected String getRawAttributesAsDotString() {
		StringBuilder builder = new StringBuilder();
		String comma = "";
		for (Entry<String, String> entry : attributes.entrySet()) {
			builder.append(comma + entry.getKey() + "=\"" + entry.getValue() + "\"");
			comma = ", ";
		}
		return builder.toString();
	}

	protected String get(String aKey) {
		return attributes.get(aKey);
	}

	protected void set(String aKey, String aValue) {
		if (aValue == null || aValue == "") {
			attributes.remove(aKey);
			return;
		}
		attributes.put(aKey, aValue);
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
