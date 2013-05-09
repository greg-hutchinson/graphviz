package ca.attractors.dot;

import ca.attractors.dot.attribute.type.DoubleDotAttributeValue;
import ca.attractors.dot.attribute.type.IntegerDotAttributeValue;
import junit.framework.TestCase;

public class AttributeTest extends TestCase {

	public void testIntegerRepresentations() {
		IntegerDotAttributeValue value = new IntegerDotAttributeValue(10);
		assertEquals("quoted value", "\"10\"", value.toDotString());
	}

	public void testDoubleRepresentations() {
		DoubleDotAttributeValue value = new DoubleDotAttributeValue(10.0);
		assertEquals("quoted value", "\"10.0\"", value.toDotString());
	}
}
