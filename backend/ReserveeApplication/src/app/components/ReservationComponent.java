package app.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entities.Reservation;
import app.entities.ReservationRequest;
import app.repositories.ReservationRepository;

@Component
public class ReservationComponent {

	@Autowired
	private ReservationRepository reservationRepo;

	public Reservation view(Long id) {
		return reservationRepo.findByreservationID(id);
	}

	public Reservation create(ReservationRequest resreq) {
		
		Reservation reservation = new Reservation();
		reservation.setReserveeID(resreq.getReserveeID());
		reservation.setVenueID(resreq.getVenueID());
		reservation.setReservationYear(resreq.getReservationYear());
		reservation.setReservationMonth(resreq.getReservationMonth());
		reservation.setReservationDay(resreq.getReservationDay());
		reservation.setTimeStart(resreq.getTimeStart());
		reservation.setTimeEnd(resreq.getTimeEnd());
		reservation.setStatus("Pending");
		
		return reservationRepo.save(reservation);
	}

	public String edit(Long reservationID,
					   Long reserveeID, 
					   int reservationYear, 
					   int reservationMonth, 
					   int reservationDay, 
					   String timeStart,
					   String timeEnd) {
		Reservation reservation = reservationRepo.findByreservationID(reservationID);
		
		if(reservation == null) {
			return "The reservation (reservationID: "+ reservationID +") does not exist, Please make a reservation first.";
		}
		else if (reservation.getReserveeID() != reserveeID) {
			return "Please use the correct reserveeID associated with the request.";
		}
		
		reservation.setReservationYear(reservationYear);
		reservation.setReservationMonth(reservationMonth);
		reservation.setReservationDay(reservationDay);
		reservation.setTimeStart(timeStart);
		reservation.setTimeEnd(timeEnd);
		reservation.setStatus("Pending");
		reservation = reservationRepo.save(reservation);
		
		return reservation.toString();
	}
	
	
	public String cancel(Long reservationID, Long reserveeID) {
		Reservation cancelledReservation = reservationRepo.findByreservationID(reservationID);
		if (cancelledReservation.getReserveeID() == reserveeID) {
			cancelledReservation.setStatus("Cancelled");
			reservationRepo.save(cancelledReservation);
		}
		return "The reservation (reservationID: "+ reservationID +") has been cancelled.";
	}

	public String setStatus(Long reservationID, String status) {
		
		Reservation reservation = reservationRepo.findByreservationID(reservationID);
		reservation.setStatus(status);
		reservation = reservationRepo.save(reservation);
		
		return "The reservation " + reservationID + " is currently " + status +".";
	}
}
