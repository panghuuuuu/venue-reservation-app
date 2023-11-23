package app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Reservation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)  
	@Column
	private Long reservationID;

	@NotNull(message="VenueID cannot be null.")
	@Column
	private Long venueID;
	
	@NotNull(message="ReserveeID cannot be null.")
	@Column
	private Long reserveeID;
	
	@NotNull(message="Year cannot be null.")
	@Column
	private int reservationYear;
	
	@NotNull(message="Month cannot be null.")
	@Column
	private int reservationMonth;
	
	@NotNull(message="Day cannot be null.")
	@Column
	private int reservationDay;
	
	@NotNull(message="Starting time cannot be null.")
    @Column
    private String timeStart;
	
	@NotNull(message="Ending time cannot be null.")
	@Column
	private String timeEnd;
    
	@NotNull(message="Status cannot be null.")
    @Column
    private String status;

	public Long getReservationID() {
		return reservationID;
	}

	public void setReservationID(Long reservationID) {
		this.reservationID = reservationID;
	}

	public Long getVenueID() {
		return venueID;
	}

	public void setVenueID(Long venueID) {
		this.venueID = venueID;
	}

	public Long getReserveeID() {
		return reserveeID;
	}

	public void setReserveeID(Long reserveeID) {
		this.reserveeID = reserveeID;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Reservation [reservationID=" + reservationID + ", venueID=" + venueID + ", reserveeID=" + reserveeID
				+ ", reservationYear=" + reservationYear + ", reservationMonth=" + reservationMonth
				+ ", reservationDay=" + reservationDay + ", timeStart=" + timeStart + ", timeEnd=" + timeEnd
				+ ", status=" + status + "]";
	}
}