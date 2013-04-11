package ca.attractors.dot.html;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class HtmlTableRow extends HtmlBase {

	private HtmlTable owner;
	private List<HtmlTableCell> cells = new ArrayList<HtmlTableCell>();
	
	HtmlTableRow(HtmlTable anOwner) {
		owner = anOwner;
	}
	
	public HtmlTableCell newCell() {
		HtmlTableCell cell = new HtmlTableCell();
		cells.add(cell);
		return cell;
	}
	
	public HtmlTable getTable() {
		return owner;
	}

	
	@Override
	void basicToDotStringOn(PrintStream aPrintStream) {
		aPrintStream.append("<tr>");
		for (HtmlTableCell cell : cells) {
			cell.toDotStringOn(aPrintStream);
		}
		aPrintStream.append("</tr>");
	}
}
