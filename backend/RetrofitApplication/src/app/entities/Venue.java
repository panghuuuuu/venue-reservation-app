package app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Venue {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Long venueID;
	
	@Column
	@NotNull(message="Venue Name name must be valid.")
	private String venueName;
	
	@Column
	@NotNull(message="Building must be valid.")
	private String building;
	
	@Column
	private String roomNo;
	
	@Column
	@NotNull(message="Office must be valid.")
	private String officeAssigned;

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

	@Override
	public String toString() {
		return "Venue [venueID=" + venueID + ", venueName=" + venueName + ", building=" + building + ", roomNo="
				+ roomNo + ", officeAssigned=" + officeAssigned + "]";
	}
}
