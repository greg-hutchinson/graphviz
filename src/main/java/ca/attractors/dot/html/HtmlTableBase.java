package ca.attractors.dot.html;

import java.io.PrintStream;

import ca.attractors.dot.color.IColor;

abstract class HtmlTableBase extends HtmlBase {

	Alignment align;
	IColor bgcolor;
	Integer border;
	Integer cellborder;
	Integer cellpadding;
	Integer cellspacing;
	IColor color;
	Boolean fixedsize;
	
	void appendCommonAttributes(PrintStream aPrintStream) {
		appendIfNotNull("ALIGN", align, aPrintStream);
		appendIfNotNull("BGCOLOR", bgcolor, aPrintStream);
		appendIfNotNull("BORDER", border, aPrintStream);
		appendIfNotNull("CELLBORDER", cellborder, aPrintStream);
		appendIfNotNull("CELLPADDING", cellpadding, aPrintStream);
		appendIfNotNull("CELLSPACING", cellspacing, aPrintStream);
		appendIfNotNull("COLOR", color, aPrintStream);
		appendIfNotNull("FIXEDSIZE", fixedsize, aPrintStream);

	}
}
