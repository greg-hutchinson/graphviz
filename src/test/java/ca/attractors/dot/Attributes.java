package ca.attractors.dot;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public abstract class Attributes extends DotObject {
	private Map<String, String> map = new HashMap<String, String>();

	public String get(String aKey) {
		return map.get(aKey);
	}

	public void set(String aKey, String aValue) {
		if (aValue == null || aValue == "") {
			map.remove(aKey);
			return;
		}
		map.put(aKey, aValue);
	}

	public String toDotString() {
		if (map.isEmpty())
			return "";
		String comma = "";
		StringBuilder builder = new StringBuilder();
		builder.append('[');
		for (Entry<String, String> entry : map.entrySet()) {
			builder.append(comma + entry.getKey() + "=\"" + entry.getValue() + "\"");
			comma = ", ";
		}
		builder.append(']');
		return builder.toString();
	}
}
