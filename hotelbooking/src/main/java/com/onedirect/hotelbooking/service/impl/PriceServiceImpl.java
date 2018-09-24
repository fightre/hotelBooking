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
import com.onedirect.hotelbooking.service.PriceService;
import com.onedirect.hotelbooking.service.helper.RoomValidator;
import com.onedirect.hotelbooking.utils.DateUtility;

/**
 * 
 * @author veerabahu.s
 *
 */
@Service
public class PriceServiceImpl implements PriceService {

	Logger logger = LoggerFactory.getLogger(PriceServiceImpl.class);

	@Autowired
	private PriceDetailRepository priceDetailRepository;

	@Autowired
	private RoomRepository roomRepository;

	@Override
	public Response<?> addPriceDetails(PriceDetail priceDetail) {
		Response<?> response;
		try {
			DateUtility.validateDate(priceDetail.getFromDate(), priceDetail.getToDate());

			List<Room> roomList = roomRepository.findByType(priceDetail.getRoomType());
			getRoomValidator().validate(priceDetail.getRoomType(), roomList);

			Room room = roomRepository.findById(priceDetail.getRoomId());
			getRoomValidator().validate(room, priceDetail.getRoomId());

			PriceDetail priceDetails = priceDetailRepository.save(priceDetail);

			response = ResponseBuilder.buildSucessResponse(priceDetails);
		} catch (Exception exception) {
			logger.error("Error :", exception);
			response = ResponseBuilder.buildFailureResponse(exception.getMessage());
		}
		return response;

	}

	public RoomValidator getRoomValidator() {
		return new RoomValidator();
	}

}
