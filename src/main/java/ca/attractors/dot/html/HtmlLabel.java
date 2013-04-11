package ca.attractors.dot.html;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class HtmlLabel extends HtmlBase {
	
	private List<HtmlTable> tables = new ArrayList<HtmlTable>();
	
	public HtmlTable newTable(String aName) {
		HtmlTable table = new HtmlTable(aName);
		tables.add(table);
		return table;
	}

	@Override
	final void basicToDotStringOn(PrintStream aPrintStream) {
		aPrintStream.append("<");
		for (HtmlTable table : tables) {
			aPrintStream.append(table.toDotString());
		}
		aPrintStream.append(">");
	}
}
