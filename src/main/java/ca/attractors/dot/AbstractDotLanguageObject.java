package ca.attractors.dot;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import ca.attractors.dot.attribute.type.BooleanDotAttributeValue;
import ca.attractors.dot.attribute.type.ColorSchemeType;
import ca.attractors.dot.attribute.type.FontType;
import ca.attractors.dot.attribute.type.IDotAttributeValue;
import ca.attractors.dot.attribute.type.StringDotAttributeValue;
import ca.attractors.dot.color.IColor;
import ca.attractors.dot.html.HtmlLabel;

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
	private static final String LABEL = "label";

	private static final String COLOR_SCHEME = "colorscheme";
	private static final String COMMENT = "comment";
	private static final String FONTNAME = "fontname";
	private static final String FONTSIZE = "fontsize";
	private static final String URL = "URL";

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
		if (isRedundantDefinition())
			return;
		String definition = getDefinition();
		String attributeString = attributesToDotString();
		aPrintStream.append(definition);
		aPrintStream.append(attributeString);
		if (attributeString.length() + definition.length() > 0)
			aPrintStream.append("\n");
	}

	public String getLabel() {
		return getString(LABEL);
	}

	public void setLabel(String aLabel) {
		set(LABEL, aLabel);
	}

	public HtmlLabel getHtmlLabel() {
		return getHtmlLabel(LABEL);
	}

	public void setHtmlLabel(HtmlLabel aLabel) {
		set(LABEL, aLabel);
	}

	/**
	 * This method is to be overridden if the object should dump itself as a string, even if it has no attributes defined.
	 * (Edges for example).
	 */
	protected boolean isRedundantDefinition() {
		return isAttributesEmpty();
	}

	protected abstract String getDefinition();

	protected final String attributesToDotString() {
		return new AttributeStringBuilder().toString();
	}

	protected final boolean isAttributesEmpty() {
		return attributes.isEmpty();
	}

	protected final String getString(String aKey) {
		return get(aKey).getValue();
	}

	protected final HtmlLabel getHtmlLabel(String aKey) {
		return (HtmlLabel) get(aKey);
	}

	protected final IDotAttributeValue get(String aKey) {
		return attributes.get(aKey);
	}

	protected final void set(String aKey, String aValue) {
		set(aKey, new StringDotAttributeValue(aValue));
	}

	protected final void set(String aKey, boolean aValue) {
		set(aKey, new BooleanDotAttributeValue(aValue));
	}

	protected final void set(String aKey, IDotAttributeValue aValue) {
		if (aValue == null) {
			attributes.remove(aKey);
			return;
		}
		attributes.put(aKey, aValue);
		setDerivitives(aKey, aValue);
	}
	
	private void setDerivitives(String aKey, IDotAttributeValue aValue) {
		if (aValue instanceof IColor) {
			setColorSchemeFromColor((IColor) aValue);
		}
	}

	private void setColorSchemeFromColor(IColor aColor) {
		ColorSchemeType scheme = aColor.getColorScheme();
		switch (scheme) {
		case X11:
			// suppress the default
			setColorScheme(null);
			break;
		default:
			setColorScheme(scheme);
			break;
		}
	}

	/**
	 * @deprecated - use getFontName instead
	 */
	public FontType getFontface() {
		return (FontType) get(FONTNAME);
	}

	/**
	 * @deprecated - use setFontName instead
	 */
	public void setFontFace(FontType aFontFace) {
		set(FONTNAME, aFontFace);
	}

	public void setFontname(FontType aFontType) {
		set(FONTNAME, aFontType);
	}

	public FontType getFontname() {
		return (FontType) get(FONTNAME);
	}
	
	public String getFontsize() {
		return getString(FONTSIZE);
	}

	public void setFontsize(String aFontsize) {
		set(FONTSIZE, aFontsize);
	}

	public String getUrl() {
		return getString(URL);
	}

	public void setUrl(String aUrl) {
		set(URL, aUrl);
	}

	public ColorSchemeType getColorScheme() {
		return (ColorSchemeType) get(COLOR_SCHEME);
	}

	protected void setColorScheme(ColorSchemeType aColorScheme) {
		set(COLOR_SCHEME, aColorScheme);
	}

	public String getComment() {
		return getString(COMMENT);
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
				builder.append(entry.getValue().toDotString());
				comma = ", ";
			}
			return builder.toString() + "]";
		}
	}
}
