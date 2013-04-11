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

	public HtmlTable setBgcolor(IColor aColor) {
		bgcolor = aColor;
		return this;
	}

	public HtmlTable setBorder(int aBorder) {
		border = aBorder;
		return this;
	}

	public HtmlTable setCellborder(int aCellBorder) {
		cellborder = aCellBorder;
		return this;
	}

	public HtmlTable setCellpadding(int aCellPadding) {
		cellpadding = aCellPadding;
		return this;
	}

	public HtmlTable setCellspacing(int aCellSpacing) {
		cellspacing = aCellSpacing;
		return this;
	}

	public HtmlTable setColor(IColor aColor) {
		color = aColor;
		return this;
	}

	public HtmlTable setFixedsize(boolean aFixedSize) {
		fixedsize = aFixedSize;
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
