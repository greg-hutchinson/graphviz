package ca.attractors.dot;

import junit.framework.TestCase;
import ca.attractors.util.Strings;

public class EdgeTest extends TestCase {

	public void testToDotString() {
		Edge edge = new Edge("from", "to", GraphType.DIGRAPH);
		edge.setFillColor("blue");
		edge.setLabel("lab");
		assertEquals(Strings.quoted("from") + " -> " + Strings.quoted("to") + " [label=\"lab\", fillcolor=\"blue\"]\n", edge.toDotString());
	}

}
