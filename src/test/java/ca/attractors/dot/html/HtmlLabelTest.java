package ca.attractors.dot.html;

import junit.framework.TestCase;

public class HtmlLabelTest extends TestCase {
	public void testNewTable() {
		HtmlLabel htmlLabel = new HtmlLabel();
		htmlLabel.newTable();
		assertEquals("<<table ></table>>", htmlLabel.toDotString());
	}
	
	public void testRow(){
		HtmlLabel htmlLabel = new HtmlLabel();
		HtmlTable table = htmlLabel.newTable();
		HtmlTableRow row = table.newRow();
		HtmlTableCell cell = row.newCell();
		cell.setContent("Test Cell");
		assertEquals("<<table ><tr><td >Test Cell</td></tr></table>>", htmlLabel.toDotString());
	}
	
	public void testTableAttributes(){
		HtmlLabel htmlLabel = new HtmlLabel();
		HtmlTable table = htmlLabel.newTable();
		table.setAlign("center").setBgcolor("white").setBorder(1).setCellborder(0).setCellpadding(1).setCellspacing(2).setColor("black").setFixedsize(false);
		assertEquals("<<table ALIGN=\"center\" BGCOLOR=\"white\" BORDER=\"1\" CELLBORDER=\"0\" CELLPADDING=\"1\" CELLSPACING=\"2\" COLOR=\"black\" FIXEDSIZE=\"false\" ></table>>", htmlLabel.toDotString());
	}
	
	public void testCellAttributes(){
		HtmlLabel htmlLabel = new HtmlLabel();
		HtmlTable table = htmlLabel.newTable();
		HtmlTableRow row = table.newRow();
		row.newCell().setAlign("center").setHref("asdf/asdf").setContent("Text").setFace("SANS SERIF");
		assertEquals("<<table ><tr><td ALIGN=\"center\" HREF=\"asdf/asdf\" ><font FACE=\"SANS SERIF\" >Text</font></td></tr></table>>", htmlLabel.toDotString());
	}
}
