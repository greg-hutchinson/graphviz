package ca.attractors.dot;


public abstract class AbstractGraphAttributes extends DotObject {
	private static final String BG_COLOR = "bgcolor";

	public void setBackgroundColor(String aString) {
		set(BG_COLOR, aString);
	}

	public String getBackgroundColor() {
		return get(BG_COLOR);
	}

}
