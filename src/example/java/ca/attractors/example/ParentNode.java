package ca.attractors.example;

import java.util.List;

import ca.attractors.dot.Graph;


public class ParentNode {
	private List<String> childrenNames;
	private String name;
	
	public String getName() {
		return name;
	}
	
	public ParentNode(String aName, List<String> aListOfChildrenNames) {
		childrenNames = aListOfChildrenNames;
	}
	
	public List<String> getChildren() {
		return childrenNames;
	}

	public void addToGraph(Graph aGraph) {
		aGraph.newNode(getName());
		addChildrenToGraph(aGraph);
	}

	private void addChildrenToGraph(Graph aGraph) {
		for (String childName : childrenNames) {
			aGraph.newEdge(getName(), childName);
		}
	}
}
