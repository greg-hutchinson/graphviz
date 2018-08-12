package ca.attractors.dot;


public class SubgraphTest extends DotTestCase {

	public void testEqualsHashcode() {
		Subgraph Subgraph = new Subgraph("name", GraphType.DIGRAPH);
		Subgraph Subgraph2 = new Subgraph("name", GraphType.DIGRAPH);
		Subgraph Subgraph3 = new Subgraph("different", GraphType.DIGRAPH);
		Subgraph subgraph4 = new Subgraph("different", GraphType.DIGRAPH, RankDir.LEFT_TO_RIGHT);
		assertEquals(Subgraph, Subgraph2);
		assertNotSame(Subgraph, Subgraph2);
		assertFalse(Subgraph.equals(Subgraph3));
		assertFalse(Subgraph.equals(new Object()));
		assertEquals(Subgraph.hashCode(), Subgraph2.hashCode());
	}

}
