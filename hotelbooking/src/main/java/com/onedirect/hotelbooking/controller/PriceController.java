package com.onedirect.hotelbooking.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onedirect.hotelbooking.model.PriceDetail;
import com.onedirect.hotelbooking.response.Response;
import com.onedirect.hotelbooking.response.ResponseBuilder;
import com.onedirect.hotelbooking.service.PriceService;

@RestController
@RequestMapping("hotel/v1")
public class PriceController {

	
	@Autowired
	private PriceService priceService;
	
	@PostMapping("/addPrice")
	public Response addPriceDetails(@Valid @RequestBody PriceDetail priceDetail , Errors errors) {
		
		List<String> errorMessage = new ArrayList<>();
		if (errors.hasErrors()) {
			for (ObjectError objectError : errors.getAllErrors()) {
				errorMessage.add(objectError.getDefaultMessage());
			}
			return ResponseBuilder.buildFailureResponse(errorMessage);
		}
		
		return priceService.addPriceDetails(priceDetail);
	}
}
