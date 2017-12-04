package ca.attractors.example;

import ca.attractors.dot.DefaultNodeAttributes;
import ca.attractors.dot.Edge;
import ca.attractors.dot.Graph;
import ca.attractors.dot.GraphType;
import ca.attractors.dot.Node;
import ca.attractors.dot.attribute.type.DirType;
import ca.attractors.dot.attribute.type.FontType;
import ca.attractors.dot.attribute.type.NodeShapeType;
import ca.attractors.dot.attribute.type.NodeStyleType;
import ca.attractors.dot.color.X11NamedColor;
import ca.attractors.dot.program.Dot;
import ca.attractors.dot.program.IRenderer;
import ca.attractors.dot.program.OutputFormat;
import com.sun.istack.internal.NotNull;

public class FamilyTreeExample {

	public static void main(String[] args) {
		Graph graph = new Graph("FamilyTree", GraphType.DIGRAPH);
		DefaultNodeAttributes defaultNodeAttributes = graph.newDefaultNodeAttributes();
		defaultNodeAttributes.setFontname(FontType.TimesNewRoman);
		defaultNodeAttributes.setFontsize("15");
		Node greg = graph.newNode("Greg");
		greg.setUrl("https://plus.google.com/102689275145660064358/posts");
		Node joan = graph.newNode("Joan");
		Node alex = graph.newNode("Alex");
		Node steph = graph.newNode("Stephanie");
		steph.setFontname(FontType.ComicSans);
		steph.setFontsize("6");

		alex.setFillColor(X11NamedColor.BLUE);
		alex.setStyle(NodeStyleType.Filled);
		alex.setShape(NodeShapeType.BOX);
		graph.newEdge(greg, alex);
		graph.newEdge(greg, steph);

		graph.newEdge(joan, alex);
		graph.newEdge(joan, steph);

		Edge newEdge = graph.newEdge(greg, joan);
		newEdge.setDir(DirType.BOTH);
		newEdge.setLabel("spouse");
		newEdge.setConstraint(false);

		graph.renderUsing(getRenderer(OutputFormat.PDF));
		graph.renderUsing(getRenderer(OutputFormat.PNG));
		graph.renderUsing(getRenderer(OutputFormat.SVG));
	}

	@NotNull
	private static IRenderer getRenderer(OutputFormat aFormat) {
		return new Dot(aFormat);
	}

}
