package com.onedirect.hotelbooking.exception;

/**
 * @purpose Invalid Date Exception.
 * @author veerabahu.s
 * @version 1.0
 * @since 1.0
 *
 */
public class InvalidDateException extends Exception {

	private static final long serialVersionUID = 4059110895741877128L;

	public InvalidDateException() {
		super("Invalid Date");
	}

	public InvalidDateException(String message) {
		super(message);
	}
}
