package app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Venue {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Long venueID;
	
	@Column
	@NotNull(message="Venue Name name must be valid.")
	private String venueName;
	
	@NotNull(message="Building must be valid.")
	private String building;
	
	@Column
	private String roomNo;
	
	@Column
	@NotNull(message="Office must be valid.")
	private String officeAssigned;
	
	@Column
	@NotNull(message="timeStart must be valid.")
	@Pattern(regexp = "^[0-9]{2}:[0-9]{2}$")
	private String timeStart = "08:00";
	
	@NotNull(message="timeEnd must be valid.")
	@Pattern(regexp = "^[0-9]{2}:[0-9]{2}$")
	private String timeEnd = "17:00";

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

	public String getOfficeAssigned() {
		return officeAssigned;
	}

	public void setOfficeAssigned(String officeAssigned) {
		this.officeAssigned = officeAssigned;
	}

	public String getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(String timeStart) {
		this.timeStart = timeStart;
	}

	public String getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(String timeEnd) {
		this.timeEnd = timeEnd;
	}

	@Override
	public String toString() {
		return "Venue [venueID=" + venueID + ", venueName=" + venueName + ", building=" + building + ", roomNo="
				+ roomNo + ", officeAssigned=" + officeAssigned + ", timeStart=" + timeStart + ", timeEnd=" + timeEnd
				+ "]";
	}
}