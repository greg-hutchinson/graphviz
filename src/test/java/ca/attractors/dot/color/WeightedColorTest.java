package ca.attractors.dot.color;

import junit.framework.TestCase;

public class WeightedColorTest extends TestCase {

	public void testGetValue() {
		WeightedColor color = new WeightedColor(X11NamedColor.ALICEBLUE);
		assertEquals("\"aliceblue\"", color.getValue());
		color = new WeightedColor(X11NamedColor.ALICEBLUE, (float) 0.21);
		assertEquals("\"aliceblue;0.21\"", color.getValue());
	}

}
