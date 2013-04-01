package ca.attractors.dot;

import java.io.PrintStream;

import ca.attractors.util.Strings;

public class Node extends DotObject implements IGraphElement {
	private static final String LABEL = "label";
	private static final String FILLCOLOR = "fillcolor";
	private static final String STYLE = "style";

	private String name;

	protected Node(String aName) {
		name = aName;
	}

	public void toDotStringOn(PrintStream aPrintStream) {
		aPrintStream.append(getDefinition());
		aPrintStream.append(attributesToDotString());
		aPrintStream.append("\n");
	}

//	@Override
//	protected CharSequence getDefinitionBody() {
//		return getAttributesDefinitionBody();
//	}

	protected CharSequence getDefinition() {
		return Strings.quoted(name);
	}

	public String getName() {
		return name;
	}

	public String getLabel() {
		return get(LABEL);
	}

	public void setLabel(String aLabel) {
		set(LABEL, aLabel);
	}

	public String getFillColor() {
		return get(FILLCOLOR);
	}

	public void setFillColor(String aFillColor) {
		set(FILLCOLOR, aFillColor);
	}

	public String getStyle() {
		return get(STYLE);
	}

	public void setStyle(String aStyle) {
		set(STYLE, aStyle);
	}


	@Override
	public boolean equals(Object aObj) {
		if (!(aObj instanceof Node))
			return false;
		Node other = (Node) aObj;
		return other.getName().equals(getName());
	}

	public int hashCode() {
		return name.hashCode();
	}

}
