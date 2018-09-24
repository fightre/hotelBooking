package com.onedirect.hotelbooking.exception;

/**
 * @purpose Invalid Room type Exception.
 * @author veerabahu.s
 * @version 1.0
 * @since 1.0
 *
 */
public class InvalidRoomTypeException extends Exception {

	private static final long serialVersionUID = 4079096994929673279L;

	public InvalidRoomTypeException() {
		super("Invalid Room Type");
	}
}
