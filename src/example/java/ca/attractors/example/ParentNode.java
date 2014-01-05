package ca.attractors.example;

import java.util.Arrays;
import java.util.List;

import ca.attractors.dot.Graph;
import ca.attractors.util.IParentNode;


public class ParentNode implements IParentNode {
	private List<String> childrenNodeNames;
	private String name;
	
	public String getName() {
		return name;
	}
	
	public ParentNode(String aName, List<String> aListOfChildrenNames) {
		name = aName;
		childrenNodeNames = aListOfChildrenNames;
	}

	public ParentNode(String aName, String... aListOfChildrenNames) {
		this(aName, Arrays.asList(aListOfChildrenNames));
	}
	
	public List<String> getChildren() {
		return childrenNodeNames;
	}

	public void addToGraph(Graph aGraph) {
		aGraph.newNode(getName());
		addChildrenToGraph(aGraph);
	}

	private void addChildrenToGraph(Graph aGraph) {
		for (String childName : childrenNodeNames) {
			aGraph.newEdge(getName(), childName);
		}
	}
}
