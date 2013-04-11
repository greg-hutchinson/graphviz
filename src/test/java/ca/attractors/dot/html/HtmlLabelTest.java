package ca.attractors.dot.html;

import junit.framework.TestCase;

public class HtmlLabelTest extends TestCase {
	public void testNewTable() {
		HtmlLabel htmlLabel = new HtmlLabel();
		htmlLabel.newTable("Test Table");
		assertEquals("<<table></table>>", htmlLabel.toDotString());
	}
	
	public void testRow(){
		HtmlLabel htmlLabel = new HtmlLabel();
		HtmlTable table = htmlLabel.newTable("Test Table");
		HtmlTableRow row = table.newRow();
		HtmlTableCell cell = row.newCell();
		cell.setText("Test Cell");
		assertEquals("<<table><tr><td>Test Cell</td></tr></table>>", htmlLabel.toDotString());
	}
}
