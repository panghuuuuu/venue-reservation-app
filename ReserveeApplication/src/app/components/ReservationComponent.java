package app.components;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entities.Reservation;
import app.repositories.ReservationRepository;

@Component
public class ReservationComponent {

	@Autowired
	private ReservationRepository reservationRepo;

	public String view(Long id) {
		return reservationRepo.findByreservationID(id).toString();
	}

	public String create(Reservation re) {
		re.setStatus("Pending");
		re = reservationRepo.save(re);
		String message = "Reservation created. Here is your reservation ID for reference: " + re.getReservationID();
		return message;
	}

	public String edit(Long reservationID, Long venueID, Long reserveeID, LocalDate date, LocalTime time) {
		Reservation editReservation = reservationRepo.findByreservationID(reservationID);
		if (editReservation.getReserveeID() == reserveeID) {
			editReservation.setVenueID(venueID);
			editReservation.setDate(date);
			editReservation.setTime(time);
			editReservation.setStatus("Pending");

			reservationRepo.save(editReservation);
		}
		return editReservation.toString();
	}
	
	
	public String cancel(Long reservationID, Long reserveeID) {
		Reservation cancelReservation = reservationRepo.findByreservationID(reservationID);
		if (cancelReservation.getReserveeID() == reserveeID) {
			cancelReservation.setStatus("Cancelled");
			reservationRepo.save(cancelReservation);
		}
		return "Canceled Reservation";
	}
}
