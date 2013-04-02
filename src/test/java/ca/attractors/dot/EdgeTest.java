package ca.attractors.dot;

import junit.framework.TestCase;
import ca.attractors.dot.attribute.type.DirType;
import ca.attractors.util.Strings;

public class EdgeTest extends TestCase {

	public void testToDotString() {
		Edge edge = new Edge("from", "to", GraphType.DIGRAPH);
		edge.setFillColor("blue");
		edge.setLabel("lab");
		edge.setDir(DirType.BOTH);
		assertEquals(Strings.quoted("from") + " -> " + Strings.quoted("to") + " [label=\"lab\", fillcolor=\"blue\", dir=\"both\"]\n",
				edge.toDotString());
	}

}
