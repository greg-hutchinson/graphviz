package ca.attractors.dot;

import junit.framework.TestCase;

public abstract class DotTestCase extends TestCase {

	/**
	 * The method will assert that anActualDotString matches aNonAttributePart and that all the key value pairs in anExpectedAttributeListString
	 * are actually in anActualDotString. Order is not important and all values will be Quoted.
	 */

	protected void assertDotStringOnlyContains(String aNonAttributePart, String anExpectedAttributeListString, String anActualDotString) {
		new ExpectedAttributesStringBuilderAsserter(aNonAttributePart, anExpectedAttributeListString, anActualDotString).assertDotString();
	}
}