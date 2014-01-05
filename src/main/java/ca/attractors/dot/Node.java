package ca.attractors.dot;

import ca.attractors.dot.color.X11NamedColor;
import ca.attractors.util.Strings;

public class Node extends AbstractNodeAttributes {

	private String name;
	private boolean createdImplicitely = false; //Was the Node was explicitly created or created as a side effect of a -> b (defines 2 nodes implicitely)

	protected Node(String aName) {
		name = aName;
	}

	@Override
	protected String getDefinition() {
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

	@Override
	protected boolean isRedundantDefinition() {
		if (!super.isRedundantDefinition())
			return false;
		return createdImplicitely;
	}

	protected void markCreatedImplicitely() {
		createdImplicitely = true;
	}


}
