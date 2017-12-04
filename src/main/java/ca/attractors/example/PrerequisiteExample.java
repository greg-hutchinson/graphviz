package ca.attractors.example;

import java.util.ArrayList;
import java.util.List;

import ca.attractors.dot.Graph;
import ca.attractors.dot.GraphType;
import ca.attractors.dot.program.Dot;
import ca.attractors.dot.program.OutputFormat;
import ca.attractors.util.IParentNode;

public class PrerequisiteExample {
	
	public static void main(String[] args) {
		Graph graph = new Graph("Prerequisite Graph", GraphType.DIGRAPH);
		graph.visitParentNodes(getParentNodes());
		graph.renderUsing(getRenderer());
	}

	private static Dot getRenderer() {
		return new Dot(OutputFormat.PNG);
	}

	private static List<IParentNode> getParentNodes() {
		List<IParentNode> parents = new ArrayList<IParentNode>();
		parents.add(new ParentNode("BlackJackUi", "Guava", "BlackJack", "Commons"));
		parents.add(new ParentNode("BlackJack", "Deck"));
		parents.add(new ParentNode("Deck", "StringUtil", "Cards"));
		return parents;
	}

}
