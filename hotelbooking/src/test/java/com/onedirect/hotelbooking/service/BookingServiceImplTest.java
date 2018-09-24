package com.onedirect.hotelbooking.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.onedirect.hotelbooking.constants.Constants;
import com.onedirect.hotelbooking.model.BookingDetail;
import com.onedirect.hotelbooking.model.Room;
import com.onedirect.hotelbooking.model.User;
import com.onedirect.hotelbooking.repository.BookingDetailRepository;
import com.onedirect.hotelbooking.repository.RoomRepository;
import com.onedirect.hotelbooking.repository.UserRepository;
import com.onedirect.hotelbooking.request.BookingRequest;
import com.onedirect.hotelbooking.response.Response;
import com.onedirect.hotelbooking.service.impl.BookingServiceImpl;

/**
 * 
 * @author veerabahu.s
 *
 */
@RunWith(SpringRunner.class)
public class BookingServiceImplTest {

	@TestConfiguration
	static class BookingServiceImplTestConfiguration {

		@Bean
		public BookingService bookingService() {
			return new BookingServiceImpl();
		}
	}

	@MockBean
	private UserRepository userRepository;

	@MockBean
	private BookingDetailRepository bookingDetailRepository;

	@MockBean
	private RoomRepository roomRepository;

	@MockBean
	private Response response;

	@MockBean
	private User user;

	@MockBean
	private Room room;

	@MockBean
	private BookingDetail bookingDetail;

	@MockBean
	private BookingRequest bookingRequest;

	@Autowired
	private BookingService bookingService;

	private List<Room> roomList = new ArrayList<>();

	@Before
	public void setUp() {
		Mockito.when(userRepository.findByUserName(Mockito.anyString())).thenReturn(user);
	}

	@Test
	public void shouldReturnAvailableResponseForCheckAvailability() {
		roomList.add(room);
		Mockito.when(roomRepository.findByType(Mockito.anyString())).thenReturn(roomList);
		String expectedStatus = Constants.SUCCESS;
		Response response = bookingService.checkAvailability("Single", "2018-09-06", "2018-09-07");
		String actualStatus = response.getStatus();
		Assert.assertEquals("response status must be equal", expectedStatus, actualStatus);
	}

	@Test
	public void shouldReturnFailureResponseForCheckAvailability() {
		String expectedStatus = Constants.FAILURE;
		String expectedMessage = "Invalid Room Type";
		Mockito.when(roomRepository.findByType(Mockito.anyString())).thenReturn(new ArrayList<>());
		Response response = bookingService.checkAvailability("Single", "2018-09-10", "2018-09-11");
		String actualStatus = response.getStatus();
		Assert.assertEquals("Status must be equal", expectedStatus, actualStatus);
		String actualMessage = (String) response.getMessage();
		Assert.assertEquals("response Message must be equal", expectedMessage, actualMessage);
	}

	@Test
	public void shouldReturnInvalidRoomTypeResponseForBookRoom() {
		String expectedStatus = Constants.FAILURE;
		String expectedMessage = "Invalid Room Type";
		Mockito.when(roomRepository.findByType(Mockito.anyString())).thenReturn(new ArrayList<>());
		Response response = bookingService.bookRoom(bookingRequest);
		String actualStatus = response.getStatus();
		String actualMessage = (String) response.getMessage();
		Assert.assertEquals("Response status must be equal", expectedStatus, actualStatus);
		Assert.assertEquals("Response message must be equal", expectedMessage, actualMessage);
	}

	@Test
	public void shouldReturnSuccessResponseForBookRoom() {
		String expectedStatus = Constants.SUCCESS;
		String roomType = "Single";
		roomList.add(room);
		Mockito.when(bookingRequest.getRoomType()).thenReturn(roomType);
		Mockito.when(bookingRequest.getUserName()).thenReturn("UserName");
		Mockito.when(bookingRequest.getFromDate()).thenReturn("2018-09-10");
		Mockito.when(bookingRequest.getToDate()).thenReturn("2018-09-11");
		Mockito.when(roomRepository.findByType(roomType)).thenReturn(roomList);
		Mockito.when(bookingDetailRepository.findByRoomIdAndDateRange(Mockito.any(), Mockito.any(), Mockito.any()))
				.thenReturn(getRoomBookingList());
		Mockito.when(bookingDetailRepository.save(Mockito.any())).thenReturn(bookingDetail);
		Response response = bookingService.bookRoom(bookingRequest);
		String actualStatus = response.getStatus();
		Assert.assertEquals("Response status must be equal", expectedStatus, actualStatus);
	}

	private List<BookingDetail> getRoomBookingList() {
		List<BookingDetail> bookingList = new ArrayList<>();
		// bookingList.add(bookingDetail);
		return bookingList;
	}

}
