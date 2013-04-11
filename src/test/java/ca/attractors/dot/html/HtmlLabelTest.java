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
		table.setAlign("CENTER").setBgcolor("white").setBorder(1).setCellborder(0).setCellpadding(1).setCellspacing(2).setColor("black").setFixedsize(false);
		assertEquals("<<table ALIGN=\"CENTER\" BGCOLOR=\"WHITE\" BORDER=\"1\" CELLBORDER=\"0\" CELLPADDING=\"1\" CELLSPACING=\"2\" COLOR=\"BLACK\" FIXEDSIZE=\"FALSE\" ></table>>", htmlLabel.toDotString());
	}
	
	public void testCellAttributes(){
		HtmlLabel htmlLabel = new HtmlLabel();
		HtmlTable table = htmlLabel.newTable();
		HtmlTableRow row = table.newRow();
		row.newCell().setAlign("CENTER").setHref("asdf/asdf").setContent("Text").setFace("SANS SERIF");
		assertEquals("<<table ><tr><td ALIGN=\"CENTER\" HREF=\"ASDF/ASDF\" ><font FACE=\"SANS SERIF\" >Text</font></td></tr></table>>", htmlLabel.toDotString());
	}
}
