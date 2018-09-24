package com.onedirect.hotelbooking.service.helper;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.onedirect.hotelbooking.exception.InvalidRoomTypeException;
import com.onedirect.hotelbooking.model.Room;
import com.onedirect.hotelbooking.utils.CommonUtils;

/**
 * Validates the room
 * 
 * @author veerabahu.s
 * @version 1.0
 * @since 1.0
 *
 */ 
@Service
public class RoomValidator {

	Logger logger = LoggerFactory.getLogger(RoomServiceHelper.class);

	/**
	 * 
	 * @param room
	 * @param type
	 * @throws InvalidRoomTypeException
	 */
	public void validate(Room room, String type) throws InvalidRoomTypeException {
		if (CommonUtils.isEmptyOrNullObject(room)) {
			logger.debug("Room null for {} ", type);
			throw new InvalidRoomTypeException();
		}
	}

	/**
	 * 
	 * @param type
	 * @param roomList
	 * @throws InvalidRoomTypeException
	 */
	public void validate(String type, List<Room> roomList) throws InvalidRoomTypeException {
		if (CommonUtils.isEmptyOrNullCollection(roomList)) {
			logger.debug("Room list null for {} ", type);
			throw new InvalidRoomTypeException();
		}
	}
	
	/**
	 * 
	 * @param room
	 * @param type
	 * @throws InvalidRoomTypeException
	 */
	public void validate(Room room, long id) throws InvalidRoomTypeException {
		if (CommonUtils.isEmptyOrNullObject(room)) {
			logger.debug("Room null for id : {} ", id);
			throw new InvalidRoomTypeException();
		}
	}
}
