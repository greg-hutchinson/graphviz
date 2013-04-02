package ca.attractors.dot;

import ca.attractors.util.Strings;

public class Node extends AbstractNodeAttributes {

	private String name;

	protected Node(String aName) {
		name = aName;
	}

	@Override
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
