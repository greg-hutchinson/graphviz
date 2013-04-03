package ca.attractors.dot;

import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;
import ca.attractors.dot.attribute.type.DirType;

public class EdgeTest extends TestCase {

	public void testToDotString() {
		Edge edge = new Edge("from", "to", GraphType.DIGRAPH);
		edge.setFillColor("blue");
		edge.setLabel("lab");
		edge.setDir(DirType.BOTH);
		String fromAndTo = "\"from\" -> \"to\""; //  "from" -> "to"
		assertDotStringEquals(fromAndTo, "label=lab,  fillcolor=blue, dir=both", edge.toDotString());
	}

	protected void assertDotStringEquals(String aNonAttributePart, String anExpectedAttributeListString, String anActualDotString) {
		if (!anActualDotString.startsWith(aNonAttributePart)) {
			String message = "First part did not match correctly";
			assertEquals(message, aNonAttributePart + " [this part has been inserted by the test case]", anActualDotString);
		}
		String rest = anActualDotString.replaceFirst(aNonAttributePart, "");
		assertTrue(rest.endsWith("]\n"));
		rest = rest.substring(0, rest.length() - 2); // drop ]\n
		if (anExpectedAttributeListString.trim().length() == 0) {
			assertEquals("", rest.trim());
			return;
		}
		assertTrue(rest.startsWith(" ["));
		rest = rest.substring(2); // Now only attributes left
		assertAttributesEqual(anExpectedAttributeListString, rest);
	}

	private void assertAttributesEqual(String aAnExpectedAttributeListString, String anActualAttributeString) {
		Map<String, String> expectedMap = getMapFromArray(aAnExpectedAttributeListString, "\"");
		Map<String, String> actualMap = getMapFromArray(anActualAttributeString, "");
		for (String expectedKey : expectedMap.keySet()) {
			assertTrue("Key " + expectedKey + " not found in actual string (" + anActualAttributeString + ")", actualMap.containsKey(expectedKey));
			String actualValue = actualMap.get(expectedKey);
			String expectedValue = expectedMap.get(expectedKey);
			assertEquals("Values do not match for key " + expectedKey + " ", expectedValue, actualValue);
			actualMap.remove(expectedKey);
		}
		assertTrue("The actual string still contains the following keys " + actualMap.toString(), actualMap.isEmpty());
	}

	private Map<String, String> getMapFromArray(String aAnExpectedAttributeListString, String aDelimiter) {
		String[] expectedPairs = aAnExpectedAttributeListString.split(",");
		Map<String, String> map = new HashMap<String, String>();
		for (String string : expectedPairs) {
			String[] keyValue = string.split("=");
			map.put(keyValue[0].trim(), aDelimiter + keyValue[1] + aDelimiter);
		}
		return map;
	}

}

