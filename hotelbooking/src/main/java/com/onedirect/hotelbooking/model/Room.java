package com.onedirect.hotelbooking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

/**
 * Holds the room details.
 * 
 * @author veerabahu.s
 * @version 1.0
 * @since 1.0
 *
 */
@Entity
@Table(name = "room")
@Data
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private long id;

	private String type;

	private String roomName;

	private int price;

	private float rating;
}
