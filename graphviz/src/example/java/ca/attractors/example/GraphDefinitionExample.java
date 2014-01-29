package ca.attractors.example;

import ca.attractors.dot.DefaultEdgeAttributes;
import ca.attractors.dot.Edge;
import ca.attractors.dot.Graph;
import ca.attractors.dot.GraphType;
import ca.attractors.dot.Node;
import ca.attractors.dot.Subgraph;
import ca.attractors.dot.attribute.type.DirType;
import ca.attractors.dot.program.Dot;
import ca.attractors.dot.program.IRenderer;
import ca.attractors.dot.program.OutputFormat;

public class GraphDefinitionExample {

	public static void main(String[] args) {
		Graph graph = new Graph("GraphDefinition", GraphType.DIGRAPH);
		graph.setLabel("Directed Graph\n(Drawn with Graphviz)");
		DefaultEdgeAttributes defaultEdgeAttributes = graph.newDefaultEdgeAttributes();
		defaultEdgeAttributes.setDir(DirType.BOTH);
		Node regina = graph.newNode("Regina");
		Node lasVegas = graph.newNode("lasvegas");
		lasVegas.setLabel("Las Vegas");
		Node luxor = graph.newNode("Luxor");

		Edge reginaLasVegas = graph.newEdge(regina, lasVegas);
		reginaLasVegas.setLabel("1795km");
		Edge reginaLuxor = graph.newEdge(regina, luxor);
		reginaLuxor.setLabel("10575km");

		Edge lasVegasLuxor = graph.newEdge(lasVegas, luxor);
		lasVegasLuxor.setLabel("12350km");

		Subgraph subgraph = graph.newSubgraph("cluster_sub");
		Node zurich = subgraph.newNode("Zurich");
		Node basel = subgraph.newNode("Basel");
		Edge reginaZurich = graph.newEdge(regina, zurich);
		reginaZurich.setLabel("7396km");
		Edge zurichBasel = subgraph.newEdge(zurich, basel);
		zurichBasel.setLabel("75km");
		subgraph.setLabel("Subgraph");

		graph.renderUsing(getRenderer(OutputFormat.SVG));
	}

	private static IRenderer getRenderer(OutputFormat aFormat) {
		return new Dot(aFormat);
	}

}
