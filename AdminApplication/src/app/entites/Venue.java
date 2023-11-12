package app.entites;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Venue {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)  // autoincrement
	@Column
	private Long venueID;
	
	@Column
	@NotNull(message="Venue Name name must be valid.")
	private String venueName;
	
	@Column
	@NotNull(message="Building must be valid.")
	private String building;
	
	@Column
	private int roomNo;
	
	@Column
	@NotNull(message="Office must be valid.")
	private String officeAssigned;

	@Column
	@ElementCollection(targetClass=String.class)
	@NotNull(message="Schedule must be valid.")
	private List<String> schedule;

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

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	public String getOfficeAssigned() {
		return officeAssigned;
	}

	public void setOfficeAssigned(String officeAssigned) {
		this.officeAssigned = officeAssigned;
	}

	public List<String> getSchedule() {
		return schedule;
	}

	public void setSchedule(List<String> schedule) {
		this.schedule = schedule;
	}

	@Override
	public String toString() {
		return "Venue [venueID=" + venueID + ", venueName=" + venueName + ", building=" + building + ", roomNo="
				+ roomNo + ", officeAssigned=" + officeAssigned + ", schedule=" + schedule + "]";
	}
	
	
}
