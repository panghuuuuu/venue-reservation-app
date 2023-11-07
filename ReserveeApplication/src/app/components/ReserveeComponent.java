package app.components;

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
		String message = "Account has been successfully created.";
		return message;
	}
}
