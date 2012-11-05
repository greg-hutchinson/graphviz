package ca.attractors.dot;

import junit.framework.TestCase;

public class GraphTest extends TestCase {

	public void testToDotString() {
		Graph graph = new Graph("name", GraphType.DIGRAPH);
		graph.setBackgroundColor("red");
		assertEquals("digraph name {\ngraph [bgcolor=\"red\"]\n}\n", graph.toDotString());
	}

	public void testToDotStringComplex() {
		Graph graph = new Graph("name", GraphType.DIGRAPH);
		Node node = graph.newNode("node1");
//		node.setFontname("abc");
		graph.setBackgroundColor("red");
		Edge edge = graph.newEdge("a", "b");
		Subgraph subgraph = graph.newSubgraph("sub1");
		subgraph.newNode("d");
		assertEquals(getExpectedComplexString(), graph.toDotString());
	}

	private String getExpectedComplexString() {
		StringBuilder builder = new StringBuilder();
		builder.append("digraph name {\n");
		builder.append("graph [bgcolor=\"red\"]\n");
		builder.append("node1\n");
		builder.append("a -> b\n");
		builder.append("subgraph sub1 {\n");
		builder.append("}\n}\n");
		return builder.toString();
	}
}
