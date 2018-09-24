package com.onedirect.hotelbooking.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.onedirect.hotelbooking.model.PriceDetail;

/**
 * Contain queries that can be applied on Price Details.
 * 
 * @author veerabahu.s
 * @version 1.0
 * @since 1.0
 *
 */

public interface PriceDetailRepository extends JpaRepository<PriceDetail, Long> {

	/**
	 * @purpose This method is used to fetch the record that satisfy the given
	 *          criteria. Fetch the records that matches the given roomId and given
	 *          date range.
	 * @param roomId
	 *            -- Id of the room to fetch.
	 * @param fromDate
	 *            -- start date of the range.
	 * @param toDate
	 *            -- End date of the range.
	 * @return PriceDetail -- Price detail that satisfy the given criteria.
	 */

	@Query("select pr from PriceDetail pr where pr.roomId =?1 and( (pr.fromDate >= ?2 and pr.fromDate <= ?3) or (pr.toDate >= ?2 and pr.toDate <=?3)) or ((?2 between pr.fromDate and pr.toDate) and (?3 between pr.fromDate and pr.toDate))")
	public PriceDetail findByRoomIdAndDateRange(Long roomId, Date fromDate, Date toDate);

}
