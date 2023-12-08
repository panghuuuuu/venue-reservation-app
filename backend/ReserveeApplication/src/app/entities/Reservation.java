package app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

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
	
	@NotNull(message="Venue Name cannot be null.")
	@Column
	private String venueName;
	
	@NotNull(message="Date cannot be null.")
	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;	
	
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

	public String getVenueName() {
		return venueName;
	}

	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
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
				+ ", venueName=" + venueName + ", date=" + date + ", timeStart=" + timeStart + ", timeEnd=" + timeEnd
				+ ", status=" + status + ", purpose=" + purpose + "]";
	}
}