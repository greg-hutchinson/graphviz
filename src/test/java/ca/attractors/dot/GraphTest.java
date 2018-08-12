package ca.attractors.dot;

import junit.framework.TestCase;
import ca.attractors.dot.attribute.type.FontType;
import ca.attractors.dot.attribute.type.NodeStyleType;
import ca.attractors.dot.attribute.type.RatioType;
import ca.attractors.dot.color.X11NamedColor;
import ca.attractors.dot.html.HtmlLabel;
import ca.attractors.dot.html.HtmlTable;
import ca.attractors.dot.html.HtmlTableRow;

public class GraphTest extends TestCase {

	public void testToDotString() {
		Graph graph = new Graph("name", GraphType.DIGRAPH);
		graph.setBackgroundColor(X11NamedColor.RED);
		String actualString = graph.toDotString();
		assertEquals("digraph \"name\" {\ngraph [bgcolor=\"red\"]\n}\n", actualString);
	}

	public void testRankDir() {
		Graph graph = new Graph("name", GraphType.DIGRAPH);
		String actualString = graph.toDotString();
		assertEquals("digraph \"name\" {\n}\n", actualString);

		graph = new Graph("name", GraphType.DIGRAPH, RankDir.BOTTOM_TO_TOP);
		actualString = graph.toDotString();
		assertEquals("digraph \"name\" {\nrankDir=BT\n}\n", actualString);

		graph = new Graph("name", GraphType.DIGRAPH);
		actualString = graph.toDotString();
		assertEquals("digraph \"name\" {\n}\n", actualString);

		graph = new Graph("name", GraphType.DIGRAPH, RankDir.LEFT_TO_RIGHT);
		actualString = graph.toDotString();
		assertEquals("digraph \"name\" {\nrankDir=LR\n}\n", actualString);
	}

	public void testToDotStringComplex() {
		Graph graph = new Graph("name", GraphType.DIGRAPH);
		graph.newNode("node1");
		graph.setBackgroundColor(X11NamedColor.RED);
		graph.newEdge("a", "b");
		graph.newEdge("a", "c");
		DefaultEdgeAttributes edgeAttributes = graph.newDefaultEdgeAttributes();
		edgeAttributes.setColor(X11NamedColor.BLUE);
		DefaultNodeAttributes nodeAttributes = graph.newDefaultNodeAttributes();
		nodeAttributes.setFillColor(X11NamedColor.BLUE);
		Subgraph subgraph = graph.newSubgraph("sub1");
		subgraph.newNode("d");
		DefaultGraphAttributes defaultGraphAttributes = graph.newDefaultGraphAttributes();
		defaultGraphAttributes.setBackgroundColor(X11NamedColor.BLUE);
		String actualString = graph.toDotString();
		assertEquals(getExpectedComplexString(), actualString);
	}

	public void testEqualsHashcode() {
		Graph graph = new Graph("name", GraphType.DIGRAPH);
		Graph graph2 = new Graph("name", GraphType.DIGRAPH);
		Graph graph3 = new Graph("different", GraphType.DIGRAPH);
		assertEquals(graph, graph2);
		assertNotSame(graph, graph2);
		assertFalse(graph.equals(graph3));
		assertFalse(graph.equals(new Object()));
		assertEquals(graph.hashCode(), graph2.hashCode());
	}

	public void testGetDefinition() {
		Graph graph = new Graph("name", GraphType.DIGRAPH);
		assertEquals("", graph.getDefinition());
		graph.setFontFace(FontType.Arial);
		assertFalse("".equals(graph.getDefinition()));

	}

	public void testConstructors() {
		Graph graph = new Graph();
		assertEquals(GraphType.DIGRAPH, graph.getType());

		try {
			new Graph(null, GraphType.DIGRAPH);
			fail("Expected exception did not occur");
		} catch (NullPointerException e) {
		}
		try {
			new Graph("name", null);
			fail("Expected exception did not occur");
		} catch (NullPointerException e) {
		}
	}

	private String getExpectedComplexString() {
		StringBuilder builder = new StringBuilder();
		builder.append("digraph \"name\" {\n");
		builder.append("graph [bgcolor=\"red\"]\n");
		builder.append("\"node1\"\n");
		builder.append("\"a\" -> \"b\"\n");
		builder.append("\"a\" -> \"c\"\n");
		builder.append("Edge [color=\"blue\"]\n");
		builder.append("Node [fillcolor=\"blue\"]\n");
		builder.append("subgraph \"sub1\" {\n");
		builder.append("\"d\"\n");
		builder.append("}\n");
		builder.append("graph [bgcolor=\"blue\"]\n");
		builder.append("}\n");
		return builder.toString();
	}

	public static void main(String[] args) {
		Graph graph = new Graph("name", GraphType.DIGRAPH);
		graph.setPageDimension(new Dimension("8.5", "11"));
		graph.setNumericRatio(1.5);
		assertEquals("numeric ratio", RatioType.Numeric, graph.getRatio());
		graph.setNodeSep(2.12);
		
		Node newNode = graph.newNode("node1");
		newNode.setHeight("20");
		newNode.setWidth("20");
		newNode.setFillColor(X11NamedColor.ANTIQUEWHITE);
		newNode.setStyle(NodeStyleType.Filled);
		graph.setBackgroundColor(X11NamedColor.RED);
		graph.newEdge("a", "b");
		DefaultEdgeAttributes edgeAttributes = graph.newDefaultEdgeAttributes();
		edgeAttributes.setWeight(15);
		edgeAttributes.setColor(X11NamedColor.BLUE);
		Subgraph subgraph = graph.newSubgraph("sub1");
		subgraph.newNode("d");
		
		Node node = graph.newNode("html node");
		HtmlLabel label = new HtmlLabel();
		HtmlTable table = label.newTable();
		HtmlTableRow row = table.newRow();
		row.newCell().setContent("Hello");
		row.newCell().setContent("World").setColor(X11NamedColor.WHEAT3);
		node.setHtmlLabel(label);
		
		String actualString = graph.toDotString();
		
		System.out.println(actualString);
	}

}
