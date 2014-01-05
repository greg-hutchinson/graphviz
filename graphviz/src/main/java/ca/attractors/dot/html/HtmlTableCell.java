package ca.attractors.dot.html;

import java.io.PrintStream;

public class HtmlTableCell extends HtmlTableBase<HtmlTableCell> {
	
	private VerticalAlignment valign;
	private String href;
	private HtmlText content;
	private String tooltip;

	
	public HtmlText setContent(String aText) {
		content = new HtmlText(aText);
		return content;
	}

	public HtmlTableCell setValign(VerticalAlignment aValign) {
		this.valign = aValign;
		return this;
	}

	public HtmlTableCell setHref(String aHref) {
		this.href = aHref;
		return this;
	}

	public HtmlTableCell setToolTip(String aToolTip) {
		this.tooltip = aToolTip;
		return this;
	}

	@Override
	void basicToDotStringOn(PrintStream aPrintStream) {
		aPrintStream.append("<td ");
		appendCommonAttributes(aPrintStream);
		appendIfNotNull("VALIGN", valign, aPrintStream);
		appendIfNotNull("HREF", href, aPrintStream);
		appendIfNotNull("TOOLTIP", tooltip, aPrintStream);
		aPrintStream.append(">");
		content.basicToDotStringOn(aPrintStream);
		aPrintStream.append("</td>");
	}
}
