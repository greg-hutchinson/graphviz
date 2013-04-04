package ca.attractors.dot.color;

import junit.framework.TestCase;

public class ColorListTest extends TestCase {

	public void testGetValue() {
		ColorList list1 = new ColorList();
		ColorList list2 = new ColorList();
		WeightedColor color = new WeightedColor(X11NamedColor.ALICEBLUE, (float) 0.21);
		list1.addColor(color);
		assertEquals("aliceblue;0.21", list1.getValue());
		assertEquals("\"aliceblue;0.21\"", list1.toDotString());
		list2.addColor(color);
		list1.addColor(list2);
		assertEquals("aliceblue;0.21:aliceblue;0.21", list1.getValue());
		assertEquals("\"aliceblue;0.21:aliceblue;0.21\"", list1.toDotString());
		System.out.println(list1.getValue());
	}

}
