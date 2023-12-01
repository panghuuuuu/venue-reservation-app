package app.entities;

public class ReservationRequestDTO {
	
	private Long venueID;
	private Long schoolID;
	private String type;
	private String firstName;
	private String lastName;
	private int year;
	private int month;
	private int day;
	private String timeStart;
	private String timeEnd;
	private String purpose;
	
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
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
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
	@Override
	public String toString() {
		return "ReservationRequestDTO [venueID=" + venueID + ", schoolID=" + schoolID + ", type=" + type
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", year=" + year + ", month=" + month
				+ ", day=" + day + ", timeStart=" + timeStart + ", timeEnd=" + timeEnd + ", purpose=" + purpose + "]";
	}
}