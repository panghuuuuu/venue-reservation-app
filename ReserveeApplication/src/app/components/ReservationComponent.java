package app.components;


import java.time.LocalTime;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entities.Reservation;
import app.repositories.ReservationRepository;

@Component
public class ReservationComponent {
	
	@Autowired
	private ReservationRepository reservationRepo;

	public String view(Long id)
	{
		return reservationRepo.findByreservationID(id).toString();
	}

	public String create(Reservation re)
	{
		re = reservationRepo.save(re);
		String message = "Reservation created. Here is your reservation ID for reference: " + re.getReservationID();
		return message;
	}
}
