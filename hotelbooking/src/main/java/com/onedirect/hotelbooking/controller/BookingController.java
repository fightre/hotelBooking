package com.onedirect.hotelbooking.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.onedirect.hotelbooking.request.BookingRequest;
import com.onedirect.hotelbooking.response.Response;
import com.onedirect.hotelbooking.response.ResponseBuilder;
import com.onedirect.hotelbooking.service.BookingService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @purpose Contains the rest services to book the room.
 * 
 * @author veerabahu.s
 * @version 1.0
 * @since 1.0
 *
 */
@RestController
@RequestMapping("/hotel/v1")
@Api(value = "Book the hotel room", description = "Used to manage the booking process")
public class BookingController {

	@Autowired
	private BookingService bookingService;

	/**
	 * Book the room for the given booking request.
	 * 
	 * @param roomBooking
	 * @return Response
	 */
	@ApiOperation(value = "Used to book the room", response = Response.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "1. Room was booked successfully"
			+ "\n\n2. Invalid Room type" + "\n\n3. Invalid Date" + "\n\n4. Room was not available to book") })
	@PostMapping("/book")
	public Response bookRoom(@Valid @RequestBody BookingRequest bookingRequest, Errors errors) {

		List<String> errorMessage = new ArrayList<>();
		if (errors.hasErrors()) {
			for (ObjectError objectError : errors.getAllErrors()) {
				errorMessage.add(objectError.getDefaultMessage());
			}
			return ResponseBuilder.buildFailureResponse(errorMessage);
		}
		return bookingService.bookRoom(bookingRequest);
	}

	/**
	 * Check Whether any room with given type was available for the given dates.
	 * 
	 * @param type
	 *            -- Type of room to check the availability.
	 * @param fromDate
	 *            -- Date from which the availability should be checked.
	 * @param toDate
	 *            -- Date till which the availability should be checked.
	 * @return Response
	 */
	@ApiOperation(value = "Used to check the availability of the room", response = Response.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "1. Room was available for the given duration"
			+ "\n\n2. Invalid Room type" + "\n\n3. Invalid Date" + "\n\n4. Room was not available for the given duration") })
	@GetMapping("/checkAvailability/{type}")
	public Response getRoomAvailability(@PathVariable("type") String type,
			@RequestParam(value = "fromDate", required = true) String fromDate,
			@RequestParam(value = "toDate", required = true) String toDate) {
		return bookingService.checkAvailability(type, fromDate, toDate);
	}
}
