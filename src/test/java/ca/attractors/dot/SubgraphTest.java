package ca.attractors.dot;


public class SubgraphTest extends DotTestCase {

//	public void testToDotString() {
//		Node node = new Node("abc");
//		node.setFillColor(X11NamedColor.BLUE);
//		node.setLabel("someValue");
//		assertDotStringOnlyContains(Strings.quoted("abc"), "label=someValue, fillcolor=blue", node.toDotString());
//	}

	public void testEqualsHashcode() {
		Subgraph Subgraph = new Subgraph("name", GraphType.DIGRAPH);
		Subgraph Subgraph2 = new Subgraph("name", GraphType.DIGRAPH);
		Subgraph Subgraph3 = new Subgraph("different", GraphType.DIGRAPH);
		assertEquals(Subgraph, Subgraph2);
		assertNotSame(Subgraph, Subgraph2);
		assertFalse(Subgraph.equals(Subgraph3));
		assertFalse(Subgraph.equals(new Object()));
		assertEquals(Subgraph.hashCode(), Subgraph2.hashCode());
	}

}
