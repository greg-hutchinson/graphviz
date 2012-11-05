package ca.attractors.dot;

public abstract class DotObject<M extends DotObjectAttributes> extends DotElement {
	public DotObject(M aAttributes) {
		attributes = aAttributes;
	}

	private M attributes;

	protected M getAttributes() {
		return attributes;
	}


	public String getFontname() {
		return attributes.getFontname();
	}

	public void setFontname(String aFontname) {
		attributes.setFontname(aFontname);
	}

	public String getFontsize() {
		return attributes.getFontsize();
	}

	public void setFontsize(String aFontsize) {
		attributes.setFontsize(aFontsize);
	}
	public String getUrl() {
		return attributes.getUrl();
	}

	public void setUrl(String aUrl) {
		attributes.setUrl(aUrl);
	}

	public String getColorScheme() {
		return getAttributes().getColorScheme();
	}

	public void setColorScheme(String aColorScheme) {
		getAttributes().setColorScheme(aColorScheme);
	}

	public String getComment() {
		return getAttributes().getComment();
	}

	public void setComment(String aComment) {
		getAttributes().setComment(aComment);
	}

}
