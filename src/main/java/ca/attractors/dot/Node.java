package ca.attractors.dot;

import java.io.PrintStream;

import ca.attractors.util.Strings;

public class Node extends NodeAttributes implements IGraphElement {

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
