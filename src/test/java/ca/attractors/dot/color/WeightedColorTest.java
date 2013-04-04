package ca.attractors.dot.color;

import junit.framework.TestCase;

public class WeightedColorTest extends TestCase {

	public void testGetValue() {
		WeightedColor color = new WeightedColor(X11NamedColor.ALICEBLUE);
		System.out.println(color.getValue());
		color = new WeightedColor(X11NamedColor.ALICEBLUE, (float) 0.21);
		System.out.println(color.getValue());

	}

}
