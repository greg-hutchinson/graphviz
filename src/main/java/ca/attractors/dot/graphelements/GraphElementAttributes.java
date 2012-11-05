package ca.attractors.dot.graphelements;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class GraphElementAttributes {
	private Map<String, String> attributes = new HashMap<String, String>();

	public boolean isEmpty() {
		return true;
	}

	public String getBracketAttributesAsDotString() {
		if (attributes.isEmpty())
			return "";
		StringBuilder builder = new StringBuilder();
		builder.append(" [");
		builder.append(getRawAttributesAsDotString());
		builder.append(']');
		return builder.toString();
	}
	
	public String getRawAttributesAsDotString() {
		StringBuilder builder = new StringBuilder();
		String comma = "";
		for (Entry<String, String> entry : attributes.entrySet()) {
			builder.append(comma + entry.getKey() + "=\"" + entry.getValue() + "\"");
			comma = ", ";
		}
		return builder.toString();
	}

	public String get(String aKey) {
		return attributes.get(aKey);
	}

	public void set(String aKey, String aValue) {
		if (aValue == null || aValue == "") {
			attributes.remove(aKey);
			return;
		}
		attributes.put(aKey, aValue);
	}
}
