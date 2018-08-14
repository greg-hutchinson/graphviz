package ca.attractors.dot;

import ca.attractors.dot.attribute.type.NodeStyleType;
import ca.attractors.dot.attribute.type.RankDirType;
import ca.attractors.dot.attribute.type.RatioType;
import ca.attractors.dot.color.X11NamedColor;

public class Example1 {
    public static void main(String [] args ) {
        Graph graph = new Graph("name", GraphType.DIGRAPH);
        graph.setCenter(true);
        graph.setRankDir(RankDirType.BT);
        graph.setConcentrate(true);
        graph.setRatio(RatioType.Compress);
        graph.setQuantum(0.5);

        Node newNode = graph.newNode("a");
        newNode.setFillColor(X11NamedColor.LIGHTBLUE);
        newNode.setStyle(NodeStyleType.Filled);
        Edge edge = graph.newEdge(newNode.getName(), "b");

        String actualString = graph.toDotString();
        System.out.println("\n\n\n" + actualString + "\n\n");
    }
}
