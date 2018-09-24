package com.onedirect.hotelbooking.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.onedirect.hotelbooking.utils.JsonDateSerializer;

import lombok.Data;

/**
 * @purpose Holds the booking details information.
 * @author veerabahu.s
 * @version 1.0
 * @since 1.0
 *
 */

@Entity
@Table(name = "bookingdetails")
@Data

public class BookingDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "booking_id")
	private long bookingId;

	@Column(name = "user_id")
	private long userId;

	@Column(name = "room_id")
	private long roomId;

	@Column(name = "from_date")
	@JsonSerialize(using= JsonDateSerializer.class)
	private Date fromDate;

	@Column(name = "to_date")
	@JsonSerialize(using= JsonDateSerializer.class)
	private Date toDate;

	@Column(name = "user_name")
	private String userName;
}
