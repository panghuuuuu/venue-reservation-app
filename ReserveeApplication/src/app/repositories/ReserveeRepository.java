package app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entities.Reservation;
import app.entities.Reservee;

@Repository
public interface ReserveeRepository extends JpaRepository<Reservee, Long> {
	public Reservee findByreserveeID(Long reserveeID);
}
