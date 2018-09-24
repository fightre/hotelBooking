package com.onedirect.hotelbooking.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Holds the response information.
 * @author veerabahu.s
 * @version 1.0
 * @since 1.0
 * 
 */

@Data
public class Response<T> {

	@ApiModelProperty(notes ="Response status " , required = true)
	private String status;
	
	@ApiModelProperty(notes = "Response message " , required = true)
	private T message;
}
