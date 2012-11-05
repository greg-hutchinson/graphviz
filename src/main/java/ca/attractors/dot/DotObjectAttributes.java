package ca.attractors.dot;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public abstract class DotObjectAttributes extends DotElement implements IGraphElement {
	private static final String FONTNAME = "fontname";
	private static final String URL = "URL";
	private static final String COLOR_SCHEME = "colorscheme";
	private static final String COMMENT = "comment";
	private static final String FONTSIZE = "fontsize";

	private Map<String, String> attributes = new HashMap<String, String>();

	public boolean isEmpty() {
		return attributes.isEmpty();
	}

	public String getDefinitionBody() {
		if (isEmpty())
			return "";
		StringBuilder builder = new StringBuilder();
		builder.append(" [");
		String comma = "";
		for (Entry<String, String> entry : attributes.entrySet()) {
			builder.append(comma + entry.getKey() + "=\"" + entry.getValue() + "\"");
			comma = ", ";
		}
		builder.append(']');
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

	public String getFontsize() {
		return get(FONTSIZE);
	}

	public void setFontsize(String aFontsize) {
		set(FONTSIZE, aFontsize);
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
