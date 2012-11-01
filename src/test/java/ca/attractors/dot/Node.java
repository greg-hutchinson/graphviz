package ca.attractors.dot;

public class Node extends DotType {
	private String name;
	private NodeAttributes attributes;

	public Node(String aName) {
		name = aName;
		attributes = new NodeAttributes();
	}

	public String getName() {
		return name;
	}

	public NodeAttributes getAttributes() {
		return attributes;
	}

	public String toDotString() {
		return name + attributes.toDotString() + "\n";
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
