package ca.attractors.dot;

import junit.framework.TestCase;
import ca.attractors.util.Strings;

public class NodeTest extends TestCase {

	public void testToDotString() {
		Node node = new Node("abc");
		node.setFillColor("blue");
		node.setLabel("lab");
		assertEquals(Strings.quoted("abc") + " [label=\"lab\", fillcolor=\"blue\"]\n", node.toDotString());
	}

}
