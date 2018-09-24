package com.onedirect.hotelbooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onedirect.hotelbooking.model.Room;

/**
 * Contains the query that can be applied on room.
 * 
 * @author veerabahu.s
 * @version 1.0
 * @since 1.0
 * 
 */
public interface RoomRepository extends JpaRepository<Room, Long> {

	/**
	 * @purpose Fetch the rooms for the given type.
	 * @param type
	 *            -- Type of the room to fetch.
	 * @return List<Room> -- List of room that has the given type.
	 */
	public List<Room> findByType(String type);
	
	/**
	 * @purpose Get the room by its id.
	 * @param id
	 * @return
	 */
	public Room findById(long id);

}
