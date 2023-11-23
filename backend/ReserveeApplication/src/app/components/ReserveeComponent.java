package app.components;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entities.Reservee;
import app.repositories.ReserveeRepository;

@Component
public class ReserveeComponent {

	@Autowired
	private ReserveeRepository reserveeRepo;

	public String create(Reservee re) {
		re = reserveeRepo.save(re);
		return re.toString();
	}

	public Reservee verifyReservee(Long reserveeID) {
		Reservee reservee = reserveeRepo.findByreserveeID(reserveeID);
		return reservee;
	}
}
