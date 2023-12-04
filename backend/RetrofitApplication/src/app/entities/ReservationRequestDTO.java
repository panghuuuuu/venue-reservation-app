package app.entities;

public class ReservationRequestDTO {
	
	private Long venueID;
	private Long schoolID;
	private String type;
	private String firstName;
	private String lastName;
	private String date;
	private String timeStart;
	private String timeEnd;
	private String purpose;
	private String email;
	public Long getVenueID() {
		return venueID;
	}
	public void setVenueID(Long venueID) {
		this.venueID = venueID;
	}
	public Long getSchoolID() {
		return schoolID;
	}
	public void setSchoolID(Long schoolID) {
		this.schoolID = schoolID;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
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
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "ReservationRequestDTO [venueID=" + venueID + ", schoolID=" + schoolID + ", type=" + type
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", date=" + date + ", timeStart=" + timeStart
				+ ", timeEnd=" + timeEnd + ", purpose=" + purpose + ", email=" + email + "]";
	}
}