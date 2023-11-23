package app.entities;

public class ReservationRequest {
	
	private Long reserveeID;
	private Long venueID;
	private Long schoolID;
	private String firstName;
	private String lastName;
	private int reservationYear;
	private int reservationMonth;
	private int reservationDay;
	private String timeStart;
	private String timeEnd;
	
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
	public Long getSchoolID() {
		return schoolID;
	}
	public void setSchoolID(Long schoolID) {
		this.schoolID = schoolID;
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
	public int getReservationYear() {
		return reservationYear;
	}
	public void setReservationYear(int reservationYear) {
		this.reservationYear = reservationYear;
	}
	public int getReservationMonth() {
		return reservationMonth;
	}
	public void setReservationMonth(int reservationMonth) {
		this.reservationMonth = reservationMonth;
	}
	public int getReservationDay() {
		return reservationDay;
	}
	public void setReservationDay(int reservationDay) {
		this.reservationDay = reservationDay;
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
		return "ReservationRequest [reserveeID=" + reserveeID + ", venueID=" + venueID + ", schoolID=" + schoolID
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", reservationYear=" + reservationYear
				+ ", reservationMonth=" + reservationMonth + ", reservationDay=" + reservationDay + ", timeStart="
				+ timeStart + ", timeEnd=" + timeEnd + "]";
	}
	
}
