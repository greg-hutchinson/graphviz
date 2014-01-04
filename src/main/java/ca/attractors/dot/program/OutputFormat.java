package ca.attractors.dot.program;

public enum OutputFormat {
	PDF("pdf"), SVG("svg"), PNG("png");
	private String format;

	private OutputFormat(String aString) {
		format = aString;
	}
	public String getFormat() {
		return format;
	}
}
