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

	public Reservee create(Reservee re) {
		re = reserveeRepo.save(re);
		return re;
	}
	
	public Reservee viewReservee(Long reserveeID) {
		return reserveeRepo.findByreserveeID(reserveeID);
	}
	
	public List<Reservee> findReservee(Long schoolID, String type, String firstName, String lastName) {
		return reserveeRepo.findBySchoolIDTypeFirstNameLastName(schoolID, type, firstName, lastName);
	}


}
