package com.onedirect.hotelbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onedirect.hotelbooking.model.User;

/**
 * Contains the query that can be applied on User.
 * 
 * @author veerabahu.s
 * @version 1.0
 * @since 1.0
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {

	/**
	 * @purpose Fetch the user with the given user name.
	 * @param userName
	 *            -- User name of the user to search.
	 * @return User -- User with the given user name.
	 */
	public User findByUserName(String userName);
}
