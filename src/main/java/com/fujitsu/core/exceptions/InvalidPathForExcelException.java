package com.fujitsu.core.exceptions;

/**
 * Runtime Exception occurs when the path given for excel sheet is incorrect.
 * @version 1.0
 * @since 1.0
 *
 */
@SuppressWarnings("serial")
public class InvalidPathForExcelException extends InvalidPathForFilesException{

	/**
	 * Pass the message that needs to be appended to the stacktrace
	 * @param message Details about the exception or custom message
	 */
	public InvalidPathForExcelException(String message) {
		super(message);
	}
	
	/**
	 * 
	 * @param message Details about the exception or custom message
	 * @param cause Pass the enriched stacktrace or customised stacktrace
	 */
	public InvalidPathForExcelException(String message,Throwable cause) {
		super(message,cause);
	}
}
