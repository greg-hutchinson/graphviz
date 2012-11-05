package ca.attractors.dot;

import junit.framework.TestCase;

public class NodeAttributesTest extends TestCase {

	public void testToDotString() {
		NodeAttributes attributes = new NodeAttributes();
		attributes.setLabel("lab");
		assertEquals("Node [label=\"lab\"]\n", attributes.toDotString());
	}

}
