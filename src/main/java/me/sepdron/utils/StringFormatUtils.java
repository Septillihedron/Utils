package me.sepdron.utils;

import java.util.Arrays;
import java.util.Map;

/**
 * Formats Strings with other language format style
 */
public class StringFormatUtils {

	private StringFormatUtils() {}

	/**
	 * Formats like python fstrings with the variables provided in the map.
	 * Currently only works for the simple {@code f"{variable}"}.
	 * 
	 * @param format
	 * 		The format that will be used
	 * @param variables
	 * 		The variables that can be used
	 * 
	 * @return A formatted string
	 * 
	 * @throws MissingVariableException
	 * 		If the format string contains a variable that is not provided in the given map
	 */
	public static String formatPython(String format, Map<String, Object> variables) 
			throws MissingVariableException {
		String[] tokenized = format.split("(?=\\{)|(?<=\\})");

		return
			Arrays.stream(tokenized).map(s -> {
				if (!s.matches("\\{.*\\}")) return s;
				s = s.substring(1, s.length()-1);
				if (!variables.containsKey(s)) throw new MissingVariableException(s);
				return variables.get(s).toString();
			}).reduce("", (acc, cur) -> acc + cur);
	}

}
