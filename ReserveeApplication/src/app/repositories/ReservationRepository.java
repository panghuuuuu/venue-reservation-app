package app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entities.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> 
{
	public Reservation findByreservationID(Long reservationID);
}
