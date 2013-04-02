package ca.attractors.dot;

import junit.framework.TestCase;

public class GraphTest extends TestCase {

	public void testToDotString() {
		Graph graph = new Graph("name", GraphType.DIGRAPH);
		graph.setBackgroundColor("red");
		String actualString = graph.toDotString();
		assertEquals("digraph \"name\" {\ngraph [bgcolor=\"red\"]\n}\n", actualString);
	}

	public void testToDotStringComplex() {
		Graph graph = new Graph("name", GraphType.DIGRAPH);
		Node node = graph.newNode("node1");
		graph.setBackgroundColor("red");
		IGraphElement edge = graph.newEdge("a", "b");
		EdgeAttributes edgeAttributes = graph.newEdgeAttributes();
		edgeAttributes.set(Edge.COLOR, "blue");
		Subgraph subgraph = graph.newSubgraph("sub1");
		subgraph.newNode("d");
		String actualString = graph.toDotString();
		assertEquals(getExpectedComplexString(), actualString);
	}

	private String getExpectedComplexString() {
		StringBuilder builder = new StringBuilder();
		builder.append("digraph \"name\" {\n");
		builder.append("graph [bgcolor=\"red\"]\n");
		builder.append("\"node1\"\n");
		builder.append("\"a\" -> \"b\"\n");
		builder.append("Edge [color=\"blue\"]\n");
		builder.append("subgraph \"sub1\" {\n");
		builder.append("\"d\"\n");
		builder.append("}\n}\n");
		return builder.toString();
	}
}
