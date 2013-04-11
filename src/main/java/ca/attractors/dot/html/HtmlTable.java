package ca.attractors.dot.html;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class HtmlTable extends HtmlBase {

	private String name;
	private List<HtmlTableRow> rows = new ArrayList<HtmlTableRow>();
	
	public HtmlTable(String aName) {
		name = aName;
	}
	
	public HtmlTableRow newRow() {
		HtmlTableRow row = new HtmlTableRow(this);
		rows.add(row);
		return row;
	}

	@Override
	void basicToDotStringOn(PrintStream aPrintStream) {
		aPrintStream.append("<table>");
		for (HtmlTableRow row : rows) {
			row.toDotStringOn(aPrintStream);
		}
		aPrintStream.append("</table>");
	}
	
}
