package ca.attractors.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ca.attractors.dot.Graph;
import ca.attractors.dot.GraphType;
import ca.attractors.dot.program.Dot;
import ca.attractors.dot.program.OutputFormat;

public class PrerequisiteExample {

	private List<ParentNode> parentNodes;
	private Graph graph;
	public PrerequisiteExample(List<ParentNode> aListOfParentNodes) {
		parentNodes = aListOfParentNodes;
	}
	private Graph getGraph() {
		initializeGraph();
		return graph;
	}



	private void initializeGraph() {
		if (graph != null)
			return;
		graph = new Graph("Prerequisite Graph", GraphType.DIGRAPH);
		for (ParentNode node : parentNodes) {
			node.addToGraph(graph);
		}
	}
	
	public static void main(String[] args) {
		PrerequisiteExample example = new PrerequisiteExample(getParentNodes());
		Dot dot = new Dot(OutputFormat.PNG);
		dot.writeToFile(example.getGraph());
	}



	private static List<ParentNode> getParentNodes() {
		List<ParentNode> parents = new ArrayList<ParentNode>();
		parents.add(new ParentNode("BlackJackUi", Arrays.asList("Guava", "BlackJack", "Commons")));
		parents.add(new ParentNode("BlackJack", Arrays.asList("Deck")));
		parents.add(new ParentNode("Deck", Arrays.asList("StringUtil", "Cards")));
		return parents;
	}

}
