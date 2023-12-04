package app.components;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entities.Reservation;
import app.repositories.ReservationRepository;

@Component
public class ReservationComponent {

	@Autowired
	private ReservationRepository reservationRepo;

	public Reservation view(Long id) {
		return reservationRepo.findByreservationID(id);
	}

	public Reservation create(Reservation res) {
		res.setStatus("Pending");
		return reservationRepo.save(res);
	}
	
	public List<Reservation> findConflict(Reservation res) {
		LocalTime timeStart = LocalTime.parse(res.getTimeStart());
		LocalTime timeEnd = LocalTime.parse(res.getTimeEnd());
		
		// 1. Get Approved Reservations on the same Year, Month, Day, and Venue
		List<Reservation> conflict = new ArrayList<>();
		List<Reservation> possibleConflicts = reservationRepo.findByVenueIDDAte(res.getVenueID(), 
																				res.getDate());
		
		// 2. Check for time overlap
		for(Reservation r : possibleConflicts) {
			LocalTime rStart = LocalTime.parse(r.getTimeStart());
			LocalTime rEnd = LocalTime.parse(r.getTimeEnd());
			
			if(timeStart.isBefore(rEnd) && timeEnd.isAfter(rStart) ) {
				conflict.add(r);
			}
		}
		return conflict;
	}
	
	public String cancel(Long reservationID, Long reserveeID) {
		Reservation cancelledReservation = reservationRepo.findByreservationID(reservationID);
		if (cancelledReservation.getReserveeID() != reserveeID) {
			return "The reservation (reservationID: "+ reservationID +") is not associated with this reserveeID.";
		}
		cancelledReservation.setStatus("Cancelled");
		reservationRepo.save(cancelledReservation);
		return "The reservation (reservationID: "+ reservationID +") has been cancelled.";
	}

	public String setStatus(Long reservationID, String status) {
		Reservation reservation = reservationRepo.findByreservationID(reservationID);
		reservation.setStatus(status);
		reservation = reservationRepo.save(reservation);
		
		return "The reservation " + reservationID + " is currently " + status +".";
	}

	public List<Reservation> getRecentReservations() {
		return reservationRepo.getRecentReservation();
	}
}
