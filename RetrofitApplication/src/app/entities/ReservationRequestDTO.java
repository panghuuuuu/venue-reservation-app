package app.entities;

import javax.persistence.Entity;

@Entity
public class ReservationRequestDTO {
	
	private Long id;
	private Long reserveeID;
	private Long venueID;
	private String venueName;
	private String building;
	private String roomNo;
	private String date;
	private String time;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
}
