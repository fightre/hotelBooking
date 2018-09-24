package com.onedirect.hotelbooking.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Holds the booking request information.
 * 
 * @author veerabahu.s
 * @version 1.0
 * @since 1.0
 *
 */

@Component
@Data

public class BookingRequest {

	@NotNull(message = "User name cannot be null")
	@NotEmpty(message = "User name cannot be empty")
	@ApiModelProperty(notes = "Name of the user", required = true)
	private String userName;

	@NotNull(message = "Room type cannot be null")
	@NotEmpty(message = "Room type cannot be empty")
	@ApiModelProperty(notes = "Type of the room", required = true)
	private String roomType;

	@NotNull(message = "From date cannot be null")
	@NotEmpty(message = "From date cannot be empty")
	@ApiModelProperty(notes = "Start date of the duration", required = true)
	private String fromDate;

	@NotNull(message = "To date cannot be null")
	@NotEmpty(message = "To date cannot be empty")
	@ApiModelProperty(notes = "End date of the duration", required = true)
	private String toDate;
}
