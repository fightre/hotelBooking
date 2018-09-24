package com.onedirect.hotelbooking.service;

import com.onedirect.hotelbooking.response.Response;

/**
 * Hold the service to get the room details and calculate the room price.
 * 
 * @author veerabahu.s
 * @version 1.0
 * @since 1.0
 * 
 */

public interface RoomService {

	/**
	 * Get all the rooms
	 * 
	 * @return Response -- Success -- Details of all the rooms. -- Failure If there
	 *         is any errors while getting the room details.
	 */
	public Response getRooms();

	/**
	 * Calculate the price dynamically for the given room type and for the given
	 * duration.
	 * 
	 * @param type
	 *            -- Type of the room to calculate the price.
	 * @param fromDate
	 *            -- Start date of the duration.
	 * @param toDate
	 *            -- End date of the duration.
	 * @return Response -- Success -- Price detail that was calculated. -- Failure
	 *         -- If there are any errors while calculating the price.
	 */
	public Response calculatetPriceByType(String type, String fromDate, String toDate);
}
