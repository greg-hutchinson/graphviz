package ca.attractors.dot.color;

import junit.framework.TestCase;

public class ColorListTest extends TestCase {

	private ColorList list1;
	private ColorList list2;
	private WeightedColor color;

	@Override
	protected void setUp() throws Exception {
		list1 = new ColorList();
		list2 = new ColorList();
		color = new WeightedColor(X11NamedColor.ALICEBLUE, (float) 0.21);
		list2.addColor(color);
		list1.addColor(color);
		list1.addColor(list2);
	}
	public void testGetValue() {
		assertEquals("aliceblue;0.21", list2.getValue());
		assertEquals("aliceblue;0.21:aliceblue;0.21", list1.getValue());
	}

	public void testToDotString() {
		assertEquals("\"aliceblue;0.21\"", list2.toDotString());
		assertEquals("\"aliceblue;0.21:aliceblue;0.21\"", list1.toDotString());
	}

}
