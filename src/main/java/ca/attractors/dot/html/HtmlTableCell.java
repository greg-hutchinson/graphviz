package ca.attractors.dot.html;

import java.io.PrintStream;

public class HtmlTableCell extends HtmlTableBase {
	
	private String valign;
	private String href;
	private HtmlText content;
	
	public HtmlText setContent(String aText) {
		content = new HtmlText(aText);
		return content;
	}

	public HtmlTableCell setValign(String aValign) {
		this.valign = aValign;
		return this;
	}

	public HtmlTableCell setHref(String aHref) {
		this.href = aHref;
		return this;
	}

	public HtmlTableCell setAlign(String anAlign) {
		this.align = anAlign;
		return this;
	}

	public HtmlTableCell setBgcolor(String bgcolor) {
		this.bgcolor = bgcolor;
		return this;
	}

	public HtmlTableCell setBorder(int border) {
		this.border = border;
		return this;
	}

	public HtmlTableCell setCellborder(int cellborder) {
		this.cellborder = cellborder;
		return this;
	}

	public HtmlTableCell setCellpadding(int cellpadding) {
		this.cellpadding = cellpadding;
		return this;
	}

	public HtmlTableCell setCellspacing(int cellspacing) {
		this.cellspacing = cellspacing;
		return this;
	}

	public HtmlTableCell setColor(String color) {
		this.color = color;
		return this;
	}

	public HtmlTableCell setFixedsize(boolean fixedsize) {
		this.fixedsize = fixedsize;
		return this;
	}

	@Override
	void basicToDotStringOn(PrintStream aPrintStream) {
		aPrintStream.append("<td ");
		appendCommonAttributes(aPrintStream);
		appendIfNotNull("VALIGN", valign, aPrintStream);
		appendIfNotNull("HREF", href, aPrintStream);
		aPrintStream.append(">");
		content.basicToDotStringOn(aPrintStream);
		aPrintStream.append("</td>");
	}
}
