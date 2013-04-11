package ca.attractors.dot.html;

import java.io.PrintStream;

public class HtmlTableCell extends HtmlBase {
	
	private String text = "";

	HtmlTableCell() {
	}

	public void setText(String text) {
		this.text = text;
	}


	@Override
	void basicToDotStringOn(PrintStream aPrintStream) {
		aPrintStream.append("<td>");
		aPrintStream.append(text);
		aPrintStream.append("</td>");
	}
}
