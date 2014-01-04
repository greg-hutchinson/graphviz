package ca.attractors.dot.program;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import ca.attractors.dot.Graph;
import ca.attractors.dot.GraphType;
import ca.attractors.dot.Node;

public class Dot {

	private static final String TEMPFILE = "c:\\temp\\tempgraph.txt";
	private static final String EXE = "C:\\Program Files (x86)\\Graphviz2.30\\bin\\dot.exe";
	private OutputFormat format = OutputFormat.PNG;
	
	public Dot(OutputFormat anOutputFormat) {
		format = anOutputFormat;
	}

	public static void main(String[] args) {
		Graph graph = new Graph("abc", GraphType.DIGRAPH);
		Node father = graph.newNode("Father");
		Node daughter = graph.newNode("Daughter");
		graph.newEdge(father.getName(), daughter.getName());
		new Dot(OutputFormat.PDF).writeToFile(graph);
		new Dot(OutputFormat.PNG).writeToFile(graph);
		new Dot(OutputFormat.SVG).writeToFile(graph);
	}
	
	public OutputFormat getFormat() {
		return format;
	}

	public void setFormat(OutputFormat aFormat) {
		format = aFormat;
	}


	public void writeToFile(Graph aGraph) {
		File file = new File(TEMPFILE);
		FileOutputStream fop = null;
		try {

			file = new File(TEMPFILE);
			fop = new FileOutputStream(file);
			if (!file.exists()) {
				file.createNewFile();
			}

			// get the content in bytes
			byte[] contentInBytes = aGraph.toDotString().getBytes();

			fop.write(contentInBytes);
			fop.flush();
			fop.close();
			Runtime.getRuntime().exec(getCommand());
			System.out.println("Done");

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fop != null) {
					fop.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	private String getCommand() {
		String executionString = EXE + " -T" + format.getFormat() + " " + TEMPFILE  + " -O";
		return executionString;
	}

}
