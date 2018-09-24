package com.onedirect.hotelbooking.utils;

import java.util.Collection;

import com.onedirect.hotelbooking.constants.Constants;

/**
 * Contains commonly used methods.
 * @author veerabahu.s
 * @since 1.0
 * @version 1.0
 */
public class CommonUtils {

	private CommonUtils() {
		
	}
	
	public static boolean isEmptyOrNullObject(Object value) {
		return null == value || Constants.EMPTY.equals(value);
	}
	
	
	/**
	 * Check object is empty or null.
	 *
	 * @param value
	 *            string value
	 * @return boolean
	 */
	public static boolean isEmptyOrNullCollection(Collection<?> collection) {
		return null == collection || collection.isEmpty();
	}
}
