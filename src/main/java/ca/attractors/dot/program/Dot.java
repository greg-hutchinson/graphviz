package ca.attractors.dot.program;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import ca.attractors.dot.Graph;

public class Dot implements IRenderer {

	private static final String TEMPDIR = "c:\\temp\\";
	private static final String EXE = "dot.exe";
	private OutputFormat format = OutputFormat.PNG;
	private String baseName;
	private String exe;
	
	public Dot(OutputFormat anOutputFormat) {
		this(anOutputFormat, EXE);
	}

	public Dot(OutputFormat anOutputFormat, String anExecutable) {
		format = anOutputFormat;
		exe = anExecutable;
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
		baseName = baseName.replaceAll(" ", "");
		File file = new File(getTempFilename());
		FileOutputStream fop = new FileOutputStream(file);
		if (!file.exists())
			file.createNewFile();
		fop.write(aGraph.toDotString().getBytes());
		fop.flush();
		fop.close();
		try {
			String command = getCommand();
			System.out.println("About to execute -> " + command);
			Process p = Runtime.getRuntime().exec(command);
			p.waitFor();
		}
		catch (IOException e) {
			System.out.println("Could not execute Dot. Check that it is on your path. Tried -> " + exe);
			throw e;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("File written to " + TEMPDIR);
		return fop;
	}

	private String getCommand() {
		StringBuilder builder = new StringBuilder();
		builder.append(getExe());
		builder.append(" ");
		builder.append(format.asParameter());
		builder.append(" ");
		builder.append(getTempFilename());
		builder.append(" ");
		builder.append(getOutputFilename());
		return builder.toString();
	}

	private String getExe() {
		return exe;
	}

	private String getOutputFilename() {
		return "-O";
	}

	private String getTempFilename() {
		return TEMPDIR + baseName;
	}

}
