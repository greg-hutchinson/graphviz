package ca.attractors.dot;

import ca.attractors.dot.attribute.type.DirType;

public class EdgeTest extends DotTestCase {

	public void testToDotString() {
		Edge edge = new Edge("from", "to", GraphType.DIGRAPH);
		edge.setFillColor("blue");
		edge.setLabel("lab");
		edge.setDir(DirType.BOTH);
		assertDotStringOnlyContains("\"from\" -> \"to\"", "label=lab, fillcolor=blue, dir=both", edge.toDotString());

		edge = new Edge("from", "to", GraphType.GRAPH);
		assertDotStringOnlyContains("\"from\" -- \"to\"", "", edge.toDotString());
	}
}

