package ca.attractors.dot;

import junit.framework.TestCase;

public class GraphTest extends TestCase {

	public void testToDotString() {
		Graph graph = new Graph("name", GraphType.DIGRAPH);
		graph.setBackgroundColor("red");
		assertEquals("digraph name {\nGraph [bgColor=\"red\"]\n}", graph.toDotString());
	}

}
