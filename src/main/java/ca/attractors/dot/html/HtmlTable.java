package ca.attractors.dot.html;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import ca.attractors.dot.color.IColor;

public class HtmlTable extends HtmlTableBase {

	private List<HtmlTableRow> rows = new ArrayList<HtmlTableRow>();

	public HtmlTable setAlign(Alignment anAlign) {
		this.align = anAlign;
		return this;
	}

	public HtmlTable setBgcolor(IColor color) {
		this.bgcolor = color;
		return this;
	}

	public HtmlTable setBorder(int border) {
		this.border = border;
		return this;
	}

	public HtmlTable setCellborder(int cellborder) {
		this.cellborder = cellborder;
		return this;
	}

	public HtmlTable setCellpadding(int cellpadding) {
		this.cellpadding = cellpadding;
		return this;
	}

	public HtmlTable setCellspacing(int cellspacing) {
		this.cellspacing = cellspacing;
		return this;
	}

	public HtmlTable setColor(IColor color) {
		this.color = color;
		return this;
	}

	public HtmlTable setFixedsize(boolean fixedsize) {
		this.fixedsize = fixedsize;
		return this;
	}

	public HtmlTableRow newRow() {
		HtmlTableRow row = new HtmlTableRow(this);
		rows.add(row);
		return row;
	}

	@Override
	void basicToDotStringOn(PrintStream aPrintStream) {
		aPrintStream.append("<table ");
		appendCommonAttributes(aPrintStream);
		aPrintStream.append(">");
		for (HtmlTableRow row : rows) {
			row.toDotStringOn(aPrintStream);
		}
		aPrintStream.append("</table>");
	}
}
