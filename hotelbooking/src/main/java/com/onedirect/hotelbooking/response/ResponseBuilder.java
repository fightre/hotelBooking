package com.onedirect.hotelbooking.response;

import com.onedirect.hotelbooking.constants.Constants;

/**
 * Used to build the response.
 * 
 * @author veerabahu.s
 * @version 1.0
 * @since 1.0
 * 
 */
public class ResponseBuilder {

	/**
	 * private constructor to prevent the object creation.
	 */
	private ResponseBuilder() {

	}

	/**
	 * @Purpose - Build the success response with the given message.
	 * @param message
	 *            -- Message of the response.
	 * @return Response -- success response with the given message.
	 */
	public static <T> Response<T> buildSucessResponse(T message) {
		Response<T> response = new Response<>();
		response.setMessage(message);
		response.setStatus(Constants.SUCCESS);
		return response;
	}

	/**
	 * @purpose - Build the failure response with the given message.
	 * @param message
	 *            -- Message of the response.
	 * @return Response -- Failure response with the given message.
	 */
	public static <T> Response<T> buildFailureResponse(T message) {
		Response<T> response = new Response<>();
		response.setMessage(message);
		response.setStatus(Constants.FAILURE);
		return response;
	}
}
