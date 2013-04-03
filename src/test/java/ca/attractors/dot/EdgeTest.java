package ca.attractors.dot;

import junit.framework.TestCase;
import ca.attractors.dot.attribute.type.DirType;

public class EdgeTest extends TestCase {

	public void testToDotString() {
		Edge edge = new Edge("from", "to", GraphType.DIGRAPH);
		edge.setFillColor("blue");
		edge.setLabel("lab");
		edge.setDir(DirType.BOTH);
		String expectedAttributes = new ExpectedAttributesStringBuilder("label=lab,    fillcolor=blue, dir=both").toQuotedAttributeString();
		String fromAndTo = "\"from\" -> \"to\""; //  "from" -> "to"
		String expected = fromAndTo + expectedAttributes;
		assertEquals(expected, edge.toDotString());
	}

}

