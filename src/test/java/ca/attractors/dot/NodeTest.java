package ca.attractors.dot;

import junit.framework.TestCase;

public class NodeTest extends TestCase {

	public void testToDotString() {
		Node node = new Node("abc");
		node.setFillColor("blue");
		node.setLabel("lab");
		assertEquals("abc [label=\"lab\", fillcolor=\"blue\"]\n", node.toDotString());
	}

}
