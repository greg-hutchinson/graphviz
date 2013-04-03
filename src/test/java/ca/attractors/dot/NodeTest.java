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

}
