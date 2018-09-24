package com.onedirect.hotelbooking.exception;

/**
 * @purpose Room was alreadt booked Exception.
 * @author veerabahu.s
 * @version 1.0
 * @since 1.0
 *
 */
public class NoAvailableRoomException extends Exception {

	private static final long serialVersionUID = -971705421507493007L;

	public NoAvailableRoomException() {
		super("Room was not available to book");
	}

}
