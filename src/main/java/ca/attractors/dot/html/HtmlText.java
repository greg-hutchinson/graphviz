package ca.attractors.dot.html;

import java.io.PrintStream;

import ca.attractors.dot.color.IColor;

public class HtmlText extends HtmlBase {
	
	private IColor color;
	private String pointSize;
	private String face;
	private String text;
	
	HtmlText(String aText) {
		text = aText;
	}

	public HtmlText setColor(IColor aColor) {
		color = aColor;
		return this;
	}

	public HtmlText setPointSize(String aPointSize) {
		pointSize = aPointSize;
		return this;
	}

	public HtmlText setFace(String aFace) {
		face = aFace;
		return this;
	}
	
	private boolean renderFont() {
		if (color != null)
			return true;
		if (pointSize != null)
			return true;
		if (face != null)
			return true;
		return false;
	}

	@Override
	void basicToDotStringOn(PrintStream aPrintStream) {
		if (renderFont()) {
			aPrintStream.append("<font ");
			appendIfNotNull("COLOR", color, aPrintStream);
			appendIfNotNull("POINT-SIZE", pointSize, aPrintStream);
			appendIfNotNull("FACE", face, aPrintStream);
			aPrintStream.append(">");
		}
		aPrintStream.append(text);
		if (renderFont())
			aPrintStream.append("</font>");
	}
}
