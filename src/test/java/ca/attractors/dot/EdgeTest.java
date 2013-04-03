package ca.attractors.dot;

import ca.attractors.dot.attribute.type.DirType;

public class EdgeTest extends DotTestCase {

	public void testToDotString() {
		Edge edge = new Edge("from", "to", GraphType.DIGRAPH);
		edge.setFillColor("blue");
		edge.setLabel("lab");
		edge.setDir(DirType.BOTH);
		assertDotStringOnlyContains("\"from\" -> \"to\"", "label=lab, def=ddd, fillcolor=blue, dir=both", edge.toDotString());
	}

}

