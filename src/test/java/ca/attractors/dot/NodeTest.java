package ca.attractors.dot;

import ca.attractors.dot.attribute.type.DotNamedColor;
import ca.attractors.util.Strings;

public class NodeTest extends DotTestCase {

	public void testToDotString() {
		Node node = new Node("abc");
		node.setFillColor(DotNamedColor.BLUE);
		node.setLabel("lab");
		assertDotStringOnlyContains(Strings.quoted("abc"), "label=lab, fillcolor=blue", node.toDotString());
	}

}
