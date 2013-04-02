package ca.attractors.dot;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import ca.attractors.dot.attribute.type.IDotAttributeValue;
import ca.attractors.dot.attribute.type.StringDotAttributeValue;

public abstract class DotObject {
	private static final String FONTNAME = "fontname";
	private static final String URL = "URL";
	private static final String COLOR_SCHEME = "colorscheme";
	private static final String COMMENT = "comment";
	private static final String FONTSIZE = "fontsize";

	private Map<String, IDotAttributeValue> attributes = new HashMap<String, IDotAttributeValue>();

	public DotObject() {
	}

	public final String toDotString() {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		PrintStream stream = new PrintStream(out);
		toDotStringOn(stream);
		return out.toString();
	}

	public void toDotStringOn(PrintStream aPrintStream) {
		basicToDotStringOn(aPrintStream);
	}

	public final void basicToDotStringOn(PrintStream aPrintStream) {
		CharSequence sequence = getDefinition();
		String string = attributesToDotString();
		aPrintStream.append(sequence);
		aPrintStream.append(string);
		if (string.length() + sequence.length() > 0)
			aPrintStream.append("\n");
	}

	protected abstract CharSequence getDefinition();

	protected String attributesToDotString() {
		if (attributes.isEmpty())
			return "";
		StringBuilder builder = new StringBuilder();
		builder.append(" [");
		String comma = "";
		for (Entry<String, IDotAttributeValue> entry : attributes.entrySet()) {
			builder.append(comma + entry.getKey() + "=\"" + entry.getValue().getValue() + "\"");
			comma = ", ";
		}
		builder.append(']');
		return builder.toString();

	}

	protected final boolean isAttributesEmpty() {
		return attributes.isEmpty();
	}

	protected final String get(String aKey) {
		return attributes.get(aKey).getValue();
	}

	protected final void set(String aKey, String aValue) {
		if (aValue == null || aValue == "") {
			attributes.remove(aKey);
			return;
		}
		attributes.put(aKey, new StringDotAttributeValue(aValue));
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
