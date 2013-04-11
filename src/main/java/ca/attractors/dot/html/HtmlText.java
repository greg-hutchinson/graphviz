package ca.attractors.dot.html;

import java.io.PrintStream;

public class HtmlText extends HtmlBase {
	
	private String color;
	private String pointSize;
	private String face;
	private String text;
	
	HtmlText(String aText) {
		text = aText;
	}

	public HtmlText setColor(String aColor) {
		this.color = aColor;
		return this;
	}

	public HtmlText setPointSize(String aPointSize) {
		this.pointSize = aPointSize;
		return this;
	}

	public HtmlText setFace(String aFace) {
		this.face = aFace;
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
