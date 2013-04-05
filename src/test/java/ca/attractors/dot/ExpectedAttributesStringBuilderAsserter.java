package ca.attractors.dot;

import java.util.HashMap;
import java.util.Map;

import junit.framework.Assert;

/**
 * Usually this is a bad idea. (Writing code in a test case)
 * However, with this said, I am trying out since I am comparing a lot of strings
 * and the test cases were becoming unreadable because of all of the escaped quotes within the String and the "[" and "]\n" 
 * surrounding every attribute String.
 * So this class trys to tidy that up by taking the following String
 *     key=value1, key = value2
 * and turning it into the following
 *      [key="value1", key="value2"]\n
 * since this is how all attribute key values should look in the end.
 * Note: there is one space before the [ as well
 */

public class ExpectedAttributesStringBuilderAsserter {
	private String nonAttributePart;
	private String expectedAttributeListString;
	private String actualDotString;

	public ExpectedAttributesStringBuilderAsserter(String aNonAttributePart, String anExpectedAttributeListString, String anActualDotString) {
		nonAttributePart = aNonAttributePart;
		expectedAttributeListString = anExpectedAttributeListString;
		actualDotString = anActualDotString;
	}

	protected void assertDotString() {
		if (!actualDotString.startsWith(nonAttributePart)) {
			String message = "First part did not match correctly";
			Assert.assertEquals(message, nonAttributePart + " [this part has been inserted by the test case]", actualDotString);
		}
		String rest = actualDotString.replaceFirst(nonAttributePart, "");
		if (rest.trim().equals(expectedAttributeListString.trim()))
			return;
		Assert.assertTrue(rest.endsWith("]\n"));
		rest = rest.substring(0, rest.length() - 2); // drop ]\n
		if (expectedAttributeListString.trim().length() == 0) {
			Assert.assertEquals("No Attribute list was expected but " + rest + " was found", "", rest.trim());
			return;
		}
		Assert.assertTrue("Attribute list must start with [", rest.startsWith(" ["));
		rest = rest.substring(2); // Now only attributes left
		assertAttributesEqual(expectedAttributeListString, rest);
	}

	private void assertAttributesEqual(String aAnExpectedAttributeListString, String anActualAttributeString) {
		Map<String, String> expectedMap = getMapFromArray(aAnExpectedAttributeListString, "\"");
		Map<String, String> actualMap = getMapFromArray(anActualAttributeString, "");
		for (String expectedKey : expectedMap.keySet()) {
			Assert.assertTrue("Expected Key " + expectedKey + " not found in actual string (" + anActualAttributeString + ")",
					actualMap.containsKey(expectedKey));
			String actualValue = actualMap.get(expectedKey);
			String expectedValue = expectedMap.get(expectedKey);
			Assert.assertEquals("Values do not match for key " + expectedKey + " ", expectedValue, actualValue);
			actualMap.remove(expectedKey);
		}
		Assert.assertTrue("The actual string still contains the following keys " + actualMap.toString(), actualMap.isEmpty());
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
