package ca.attractors.dot;

import ca.attractors.dot.color.X11NamedColor;
import ca.attractors.util.Strings;

public class NodeTest extends DotTestCase {

	public void testToDotString() {
		Node node = new Node("abc");
		node.setFillColor(X11NamedColor.BLUE);
		node.setLabel("someValue");
		assertDotStringOnlyContains(Strings.quoted("abc"), "label=someValue, fillcolor=blue", node.toDotString());
	}

	public void testEqualsHashcode() {
		Node node = new Node("abc");
		Node node2 = new Node("abc");
		Node node3 = new Node("different");
		assertEquals(node, node2);
		assertNotSame(node, node2);
		assertFalse(node.equals(node3));
		assertFalse(node.equals(new Object()));
		assertEquals(node.hashCode(), node2.hashCode());
	}

}
