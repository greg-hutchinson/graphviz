package ca.attractors.dot;

import java.io.PrintStream;

public abstract class OldDotObject {
	public void toDotStringOn(PrintStream aPrintStream) {
		aPrintStream.append(toDotString());
	}

	public abstract String toDotString();

}
