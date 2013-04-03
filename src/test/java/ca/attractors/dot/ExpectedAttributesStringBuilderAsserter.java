package ca.attractors.dot;

/**
 * Usually this is a bad idea. (Writing code in a test case)
 * However, with this said, I am trying out since I am comparing a lot of strings
 * and the test cases were becoming unreadable because of all of the escaped quotes within the String and the "[" and "]\n" 
 * surrounding every attribute String.
 * So this class trys to tidy that up by taking the following String
 *     key=value1, key = value2
 * and turning it into the following
 *      [key="value1", key="value2"]\n
 * since this is how all attribute key values should look in the end.
 * Note: there is one space before the [ as well
 */

public class ExpectedAttributesStringBuilderAsserter {
	private String input;

	public ExpectedAttributesStringBuilderAsserter(String aInput) {
		input = aInput;
	}

	public String toQuotedAttributeString() {
		if (input.length() == 0)
			return input;
		StringBuilder builder = new StringBuilder(" [");
		String[] strings = input.split(",");
		String comma = "";
		for (String string : strings) {
			builder.append(comma);
			comma = ", ";
			String[] split = string.split("=");
			builder.append(split[0].trim());
			builder.append('=');
			builder.append('"');
			builder.append(split[1].trim());
			builder.append('"');
		}
		return builder.toString() + "]\n";
	}


}
