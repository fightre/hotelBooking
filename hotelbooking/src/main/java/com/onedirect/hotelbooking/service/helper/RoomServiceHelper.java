package com.onedirect.hotelbooking.service.helper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.onedirect.hotelbooking.model.Room;

/**
 * Contains helper method for room service.
 * @author veerabahu.s
 * @since 1.0
 * @version 1.0
 *
 */
public class RoomServiceHelper {

	Logger logger = LoggerFactory.getLogger(RoomServiceHelper.class);
	
	/**
	 * 
	 * @param roomList
	 * @return
	 */
	public List<Room> calculateRating(List<Room> roomList) {
		logger.debug("Setting the rating of the room : {}" , roomList);
		Map<String,Float> ratingMap = new HashMap<>(); 
		float rating = 0;
		for (Room room :roomList) {
			if(ratingMap.containsKey(room.getType())) {
				rating = (ratingMap.get(room.getType()) + room.getRating() )/ 2;
			}
			ratingMap.put(room.getType(), rating);
		}
		
		for (Room room : roomList) {
			room.setRating(ratingMap.get(room.getType()));
		}
		
		return roomList;
	}
}
