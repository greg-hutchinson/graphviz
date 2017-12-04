package ca.attractors.dot.html;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import ca.attractors.dot.attribute.type.IDotAttributeValue;

abstract class HtmlBase implements IDotAttributeValue {

	public final String toDotString() {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		PrintStream stream = new PrintStream(out);
		toDotStringOn(stream);
		return out.toString();
	}

	/* This method is sometimes overridden */
	public void toDotStringOn(PrintStream aPrintStream) {
		basicToDotStringOn(aPrintStream);
	}

	abstract void basicToDotStringOn(PrintStream aPrintStream);

	public String getValue() {
		return toString();
	}

	void appendIfNotNull(String name, Object anAttributeValue, PrintStream aPrintStream) {
		if (anAttributeValue == null)
			return;
		aPrintStream.append(name);
		aPrintStream.append("=\"");
		aPrintStream.append(getAttributeValue(anAttributeValue));
		aPrintStream.append("\" ");
	}

	private String getAttributeValue(Object anAttributeValue) {
		if (anAttributeValue instanceof IDotAttributeValue)
			return (((IDotAttributeValue) anAttributeValue).getValue());
		return anAttributeValue.toString();
	}

}
