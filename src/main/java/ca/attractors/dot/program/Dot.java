package ca.attractors.dot.program;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import ca.attractors.dot.Graph;
import ca.attractors.dot.GraphType;
import ca.attractors.dot.Node;
import ca.attractors.dot.attribute.type.NodeStyleType;
import ca.attractors.dot.color.X11NamedColor;

public class Dot implements IRenderer {

	private static final String TEMPDIR = "c:\\temp\\";
	private static final String EXE = "C:\\Program Files (x86)\\Graphviz2.34\\bin\\dot.exe";
	private OutputFormat format = OutputFormat.PNG;
	private String baseName;
	
	public Dot(OutputFormat anOutputFormat) {
		format = anOutputFormat;
	}

	public static void main(String[] args) {
		Graph graph = new Graph("abc", GraphType.DIGRAPH);
		Node father = graph.newNode("Father");
		Node daughter = graph.newNode("Daughter");
		daughter.setFillColor(X11NamedColor.BLUE);
		daughter.setStyle(NodeStyleType.Filled);
		graph.newEdge(father.getName(), daughter.getName());

		graph.renderUsing(getRenderer(OutputFormat.PDF));
		graph.renderUsing(getRenderer(OutputFormat.PNG));
		graph.renderUsing(getRenderer(OutputFormat.SVG));
	}

	private static IRenderer getRenderer(OutputFormat aFormat) {
		return new Dot(aFormat);
	}
	
	public OutputFormat getFormat() {
		return format;
	}

	public void setFormat(OutputFormat aFormat) {
		format = aFormat;
	}


	public void render(Graph aGraph) {
		FileOutputStream fop = null;
		try {
			fop = renderGraphToTempFile(aGraph);
			Runtime.getRuntime().exec(getCommand());
			System.out.println("File written to " + TEMPDIR);
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

	private FileOutputStream renderGraphToTempFile(Graph aGraph) throws FileNotFoundException, IOException {
		baseName = aGraph.getName();
		if (baseName == null || baseName.equals(""))
			baseName = "Unnamed";
		File file = new File(getTempFilename());
		FileOutputStream fop = new FileOutputStream(file);
		if (!file.exists())
			file.createNewFile();
		fop.write(aGraph.toDotString().getBytes());
		fop.flush();
		fop.close();
		return fop;
	}

	private String getCommand() {
		StringBuilder builder = new StringBuilder();
		builder.append(EXE);
		builder.append(" ");
		builder.append(format.asParameter());
		builder.append(" ");
		builder.append(getTempFilename());
		builder.append(" ");
		builder.append(getOutputFilename());
		return builder.toString();
	}

	private String getOutputFilename() {
		return "-O";
	}

	private String getTempFilename() {
		return TEMPDIR + baseName;
	}

}
