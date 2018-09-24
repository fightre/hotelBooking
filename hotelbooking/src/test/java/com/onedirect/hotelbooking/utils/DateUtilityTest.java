package com.onedirect.hotelbooking.utils;

import org.junit.Assert;
import org.junit.Test;


public class DateUtilityTest {

		private String startDateInString ;
		
		private  String endDateInString ; 
		
		private String existingStartDateInString ;
		
		private String existingEndDateInString ;
	 
	@Test
	public void shouldReturnTrueForcheckInRangeTestWhenCompletelyLayoverDates() {
		startDateInString = "2018-09-04";
		endDateInString = "2018-09-07"; 
		existingStartDateInString = "2018-09-05";
		existingEndDateInString = "2018-09-06";
		boolean isDateAvailable = DateUtility.checkInRange(startDateInString, endDateInString, existingStartDateInString, existingEndDateInString);
		Assert.assertTrue(isDateAvailable);
	}
	
	@Test
	public void shouldReturnTrueForCheckInRangeTestForCompletelyLayoverDates() {
		startDateInString = "2018-09-05";
		endDateInString = "2018-09-06"; 
		existingStartDateInString = "2018-09-04";
		existingEndDateInString = "2018-09-07";
		boolean isDateAvailable = DateUtility.checkInRange(startDateInString, endDateInString, existingStartDateInString, existingEndDateInString);
		Assert.assertTrue(isDateAvailable);
	}
	
	
	@Test
	public void shouldReturnTrueForCheckInRangeTestForPartialLayoverDates() {
		startDateInString = "2018-09-04";
		endDateInString = "2018-09-07"; 
		existingStartDateInString = "2018-09-05";
		existingEndDateInString = "2018-09-08";
		boolean isDateAvailable = DateUtility.checkInRange(startDateInString, endDateInString, existingStartDateInString, existingEndDateInString);
		Assert.assertTrue(isDateAvailable);
	}
	
	
	@Test
	public void shouldReturnTrueForCheckInRangeTestForPartialLayoverDatesOtherCase() {
		startDateInString = "2018-09-05";
		endDateInString = "2018-09-08"; 
		existingStartDateInString = "2018-09-04";
		existingEndDateInString = "2018-09-06";
		boolean isDateAvailable = DateUtility.checkInRange(startDateInString, endDateInString, existingStartDateInString, existingEndDateInString);
		Assert.assertTrue(isDateAvailable);
	}
	
	@Test
	public void shouldReturnFalseForCheckInRangeTestForDifferentDates() {
		startDateInString = "2018-09-05";
		endDateInString = "2018-09-08"; 
		existingStartDateInString = "2018-09-03";
		existingEndDateInString = "2018-09-04";
		boolean isDateAvailable = DateUtility.checkInRange(startDateInString, endDateInString, existingStartDateInString, existingEndDateInString);
		Assert.assertFalse(isDateAvailable);
	}
	
}
