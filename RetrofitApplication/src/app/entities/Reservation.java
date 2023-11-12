package app.entities;

import java.time.LocalDate;
import java.time.LocalTime;
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
	
	@NotNull(message="Date cannot be null.")
	@Column
	private LocalDate date;
	
	@NotNull(message="Time cannot be null.")
    @Column
    private LocalTime time;
    
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Reservation [reservationID=" + reservationID + ", venueID=" + venueID + ", reserveeID=" + reserveeID
				+ ", date=" + date + ", time=" + time + ", status=" + status + "]";
	}

}
