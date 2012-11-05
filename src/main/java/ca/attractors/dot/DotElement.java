package ca.attractors.dot;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public abstract class DotElement {

	public String toDotString() {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		PrintStream stream = new PrintStream(out);
		toDotStringOn(stream);
		return out.toString();
	}

	public void toDotStringOn(PrintStream aPrintStream) {
		aPrintStream.append(getDefinitionBegin());
		aPrintStream.append(getDefinitionBody());
		aPrintStream.append(getDefinitionEnd());
	}

	protected abstract CharSequence getDefinitionBody();

	protected abstract CharSequence getDefinition();

	protected CharSequence getDefinitionBegin() {
		return getDefinition();
	}

	protected CharSequence getDefinitionEnd() {
		return "\n";
	}

}
