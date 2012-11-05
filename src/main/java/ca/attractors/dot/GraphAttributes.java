package ca.attractors.dot;

public class GraphAttributes extends DotObjectAttributes {
	private static final String BG_COLOR = "bgcolor";

	public void setBackgroundColor(String aString) {
		set(BG_COLOR, aString);
	}

	public String getBackgroundColor() {
		return get(BG_COLOR);
	}

	@Override
	protected CharSequence getDefinition() {
		return "graph";
	}

}
