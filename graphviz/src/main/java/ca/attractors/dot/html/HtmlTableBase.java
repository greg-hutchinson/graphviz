package ca.attractors.dot.html;

import java.io.PrintStream;

import ca.attractors.dot.color.IColor;

abstract class HtmlTableBase<T> extends HtmlBase {

	Alignment align;
	IColor bgcolor;
	Integer border;
	Integer cellborder;
	Integer cellpadding;
	Integer cellspacing;
	IColor color;
	Boolean fixedsize;
	
	@SuppressWarnings("unchecked")
	private T getThis() {
		return (T) this;
	}

	public T setAlign(Alignment anAlign) {
		align = anAlign;
		return getThis();
	}
	public T setBgcolor(IColor aColor) {
		bgcolor = aColor;
		return getThis();
	}

	public T setBorder(int aBorder) {
		border = aBorder;
		return getThis();
	}

	public T setCellborder(int aCellBorder) {
		cellborder = aCellBorder;
		return getThis();
	}

	public T setCellpadding(int aCellPadding) {
		cellpadding = aCellPadding;
		return getThis();
	}

	public T setCellspacing(int aCellSpacing) {
		cellspacing = aCellSpacing;
		return getThis();
	}

	public T setColor(IColor aColor) {
		color = aColor;
		return getThis();
	}

	public T setFixedsize(boolean aFixedSize) {
		fixedsize = aFixedSize;
		return getThis();
	}

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
