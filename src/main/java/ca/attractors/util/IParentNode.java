package ca.attractors.util;

import java.util.List;

import ca.attractors.dot.Graph;

public interface IParentNode {

	String getName();

	List<String> getChildren();

	void addToGraph(Graph aGraph);

}