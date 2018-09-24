package com.onedirect.hotelbooking.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onedirect.hotelbooking.model.PriceDetail;
import com.onedirect.hotelbooking.model.Room;
import com.onedirect.hotelbooking.repository.PriceDetailRepository;
import com.onedirect.hotelbooking.repository.RoomRepository;
import com.onedirect.hotelbooking.response.Response;
import com.onedirect.hotelbooking.response.ResponseBuilder;
import com.onedirect.hotelbooking.service.RoomService;
import com.onedirect.hotelbooking.service.helper.PriceCalculator;
import com.onedirect.hotelbooking.service.helper.RoomValidator;
import com.onedirect.hotelbooking.utils.DateUtility;

/**
 * @purpose To get rooms and calculate the price of the room.
 * 
 * @author veerabahu.s
 * @version 1.0
 * @since 1.0
 * 
 */

@Service
public class RoomServiceImpl implements RoomService {

	Logger logger = LoggerFactory.getLogger(RoomServiceImpl.class);

	@Autowired
	private RoomRepository roomRepository;

	@Autowired
	private PriceDetailRepository priceDetailRepository;

	/**
	 * This method implementation used to retrieve all room details including
	 * pricing,type and rating
	 * 
	 */
	@Override
	public Response getRooms() {
		Response response;
		try {
			logger.debug("Getting the room details");
			List<Room> roomList = roomRepository.findAll();
			response = ResponseBuilder.buildSucessResponse(roomList);
			logger.debug("Successfully got the rooms : {}", roomList);
		} catch (Exception e) {
			logger.error("Error: ", e);
			response = ResponseBuilder.buildFailureResponse(e.getMessage());
		}
		return response;
	}

	/**
	 * This method implementation used to retrieve the price based on from date and
	 * to date
	 * 
	 */
	@Override
	public Response calculatetPriceByType(String type, String fromDateInString, String toDateInString) {
		Response response;
		try {
			logger.debug("Getting the room price for type : {} and duration from : {}  till : {}", type,
					fromDateInString, toDateInString);
			List<Room> roomList = roomRepository.findByType(type);

			getRoomValidator().validate(type, roomList);
			DateUtility.validateDate(fromDateInString, toDateInString);
			Room room = roomList.get(0);
			PriceDetail priceDetail = getPriceCalculator().calculate(room, fromDateInString, toDateInString,
					priceDetailRepository);
			response = ResponseBuilder.buildSucessResponse(priceDetail);
			logger.debug("Response : {} ", response);

		} catch (Exception e) {
			logger.error("Error: ", e);
			response = ResponseBuilder.buildFailureResponse(e.getMessage());
		}

		return response;
	}

	/**
	 * 
	 * @return
	 */
	public RoomValidator getRoomValidator() {
		return new RoomValidator();
	}

	/**
	 * 
	 * @return
	 */
	public PriceCalculator getPriceCalculator() {
		return new PriceCalculator();
	}
}
