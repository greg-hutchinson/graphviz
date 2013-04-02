package ca.attractors.dot;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public abstract class DotObjectAttributes extends DotElement implements IGraphElement {
	private static final String FONTNAME = "fontname";
	private static final String URL = "URL";

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

	public String getUrl() {
		return get(URL);
	}

	public void setUrl(String aUrl) {
		set(URL, aUrl);
	}

	public String getColor() {
		return null;
	}

	public void setColor(String aString) {
	}

	public void setStyle(String aStyle) {
	}

	public String getStyle() {
		return null;
	}

	public void setFillColor(String aFillColor) {
	}

	public String getFillColor() {
		return null;
	}

	public void setLabel(String aLabel) {
	}

	public String getLabel() {
		return null;
	}

}
