package app.rest.controllers;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;

@Entity
public class ReservationRequestDTO {
	
	private Long reserveeID;
	private Long venueID;
	private String venueName;
	private String building;
	private String roomNo;
	private LocalDate date;
	private LocalTime time;
	
	public Long getReserveeID() {
		return reserveeID;
	}
	public void setReserveeID(Long reserveeID) {
		this.reserveeID = reserveeID;
	}
	public Long getVenueID() {
		return venueID;
	}
	public void setVenueID(Long venueID) {
		this.venueID = venueID;
	}
	public String getVenueName() {
		return venueName;
	}
	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}
	public String getBuilding() {
		return building;
	}
	public void setBuilding(String building) {
		this.building = building;
	}
	public String getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	
	
}
