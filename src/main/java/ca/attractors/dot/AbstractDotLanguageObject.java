package ca.attractors.dot;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import ca.attractors.dot.attribute.type.IDotAttributeValue;
import ca.attractors.dot.attribute.type.StringDotAttributeValue;
import ca.attractors.util.Strings;

/** 
 * This class represents the abstraction of all the DOT Language defined objects. (See all concrete subclasses for the complete list) 
 * and cross reference this with this link http://www.graphviz.org/content/dot-language . Note Not all languageElements have been implemented, only
 * those that were deemed necessary.
 * This is not to be confused with the Interface - IGraphElement which is used to document all objects (elements) that can be added to a Graph
 */
public abstract class AbstractDotLanguageObject {
	/* Here the common attribute values are defined. Note: these must be valid for 
	 * Graphs, Subgraphs, Nodes, and Edges.
	 */
	private static final String FONTNAME = "fontname";
	private static final String URL = "URL";
	private static final String COLOR_SCHEME = "colorscheme";
	private static final String COMMENT = "comment";
	private static final String FONTSIZE = "fontsize";

	private Map<String, IDotAttributeValue> attributes = new HashMap<String, IDotAttributeValue>();

	protected AbstractDotLanguageObject() {
	}

	public final String toDotString() {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		PrintStream stream = new PrintStream(out);
		toDotStringOn(stream);
		return out.toString();
	}

	/* This method is sometimes overridden */
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

	protected final String attributesToDotString() {
		return new AttributeStringBuilder().toString();
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

	class AttributeStringBuilder {
		public String toString() {
			if (attributes.isEmpty())
				return "";
			return getAttributesString();
		}

		private String getAttributesString() {
			String comma = "";
			StringBuilder builder = new StringBuilder(" [");
			for (Entry<String, IDotAttributeValue> entry : attributes.entrySet()) {
				builder.append(comma + entry.getKey());
				builder.append("=");
				builder.append(Strings.quoted(entry.getValue().getValue()));
				comma = ", ";
			}
			return builder.toString() + "]";
		}
	}
}
