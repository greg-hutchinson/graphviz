package ca.attractors.dot;

public class NodeAttributes extends DotObjectAttributes {
	private static final String LABEL = "label";
	private static final String FILLCOLOR = "fillcolor";
	private static final String STYLE = "style";

	@Override
	protected CharSequence getDefinition() {
		return "Node";
	}

}
