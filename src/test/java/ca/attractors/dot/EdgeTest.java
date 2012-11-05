package ca.attractors.dot;

import junit.framework.TestCase;

public class EdgeTest extends TestCase {

	public void testToDotString() {
		Edge edge = new Edge("from", "to", GraphType.DIGRAPH);
		edge.setFillColor("blue");
		edge.setLabel("lab");
		assertEquals("from -> to [label=\"lab\", fillcolor=\"blue\"]\n", edge.toDotString());
	}

}
