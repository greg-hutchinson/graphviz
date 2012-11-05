package ca.attractors.dot;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public abstract class DotType extends DotObject {
	private Map<String, String> attributes = new HashMap<String, String>();

	protected Map<String, String> getAttributes() {
		return attributes;
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

	@Override
	public String toDotString() {
		return getDefinitionString() + getAttributesAsDotString() + "\n";
	}

	protected abstract String getDefinitionString();

	private String getAttributesAsDotString() {
		if (attributes.isEmpty())
			return "";
		String comma = "";
		StringBuilder builder = new StringBuilder();
		builder.append(" [");
		for (Entry<String, String> entry : attributes.entrySet()) {
			builder.append(comma + entry.getKey() + "=\"" + entry.getValue() + "\"");
			comma = ", ";
		}
		builder.append(']');
		return builder.toString();
	}

}
