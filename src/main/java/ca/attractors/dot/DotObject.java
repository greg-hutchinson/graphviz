package ca.attractors.dot;

public abstract class DotObject<M extends AbstractDotObjectAttributes> extends OldDotObject {
	public DotObject(M aAttributes) {
		attributes = aAttributes;
	}

	private M attributes;

	protected M getAttributes() {
		return attributes;
	}

	@Override
	public String toDotString() {
		return getStartDefinitionAsDotString() + getAttributesAsDotString() + getEndDefinitionAsDotString();
	}

	protected String getEndDefinitionAsDotString() {
		return "\n";
	}

	protected abstract String getStartDefinitionAsDotString();

	protected abstract String getAttributesAsDotString();

	protected String getBracketedAttributesAsDotString() {
		return attributes.getBracketAttributesAsDotString();
	}

	protected String getRawAttributesAsDotString() {
		return attributes.getRawAttributesAsDotString();
	}

	public String getFontname() {
		return attributes.getFontname();
	}

	public void setFontname(String aFontname) {
		attributes.setFontname(aFontname);
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
