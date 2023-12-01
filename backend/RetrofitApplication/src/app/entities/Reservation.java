package app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Reservation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)  
	@Column
	private Long reservationID;
	
	@NotNull(message="ReserveeID cannot be null.")
	@Column
	private Long reserveeID;

	@NotNull(message="VenueID cannot be null.")
	@Column
	private Long venueID;
	
	@NotNull(message="Year cannot be null.")
	@Column
	private int year;
	
	@NotNull(message="Month cannot be null.")
	@Column
	@Min(1)
	@Max(12)
	private int month;
	
	@NotNull(message="Day cannot be null.")
	@Column
	@Min(1)
	@Max(31)
	private int day;
	
	@NotNull(message="timeStart must be valid.")
	@Column
	@Pattern(regexp = "^[0-9]{2}:[0-9]{2}$")
	private String timeStart = "08:00";
	
	@NotNull(message="timeEnd must be valid.")
	@Column
	@Pattern(regexp = "^[0-9]{2}:[0-9]{2}$")
	private String timeEnd = "17:00";
    
    @Column
    private String status;
    
    @NotNull(message="Purpose must be valid.")
    @Column
    @Size(min=1, max=50)
    private String purpose;

	public Long getReservationID() {
		return reservationID;
	}

	public void setReservationID(Long reservationID) {
		this.reservationID = reservationID;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	@Override
	public String toString() {
		return "Reservation [reservationID=" + reservationID + ", reserveeID=" + reserveeID + ", venueID=" + venueID
				+ ", year=" + year + ", month=" + month + ", day=" + day + ", timeStart=" + timeStart + ", timeEnd="
				+ timeEnd + ", status=" + status + ", purpose=" + purpose + "]";
	}
}