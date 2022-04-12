package me.sepdron.utils;

/**
 * Unchecked exception thrown when there is a missing variable name.
 */
public class MissingVariableException extends RuntimeException {

	/**
	 * The variable that is missing
	 */
	private String variable;

	/**
	 * Constructs an instance of this class with the missing variable
	 *
	 * @param variable
	 * 		The variable that is missing
	 */
	public MissingVariableException(String variable) {
		this.variable = variable;
	}

	/**
	 * Gets the variable that is missing.
	 * 
	 * @return The missing variable
	 */
	public String getVariable() {
		return variable;
	}

	/**
	 * Returns the detail message string of this Throwable.
	 * 
	 * @return The detail message string of this Throwable instance.
	 */
	@Override
	public String getMessage() {
		return "variable '" + variable + "'";
	}

}
