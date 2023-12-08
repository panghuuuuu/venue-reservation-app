package app.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import app.entities.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
	public Reservation findByreservationID(Long reservationID);
	public Reservation findByStatus(String status);
	
	@Query(value = "SELECT * FROM reservation r ORDER BY r.reservationID DESC LIMIT 25;", 
		   nativeQuery = true)
	public List<Reservation> getRecentReservation();
	
	@Query("SELECT r FROM Reservation r WHERE r.venueID = :venueID AND r.date = :date")
	public List<Reservation> findByVenueIDDAte(@Param("venueID") Long venueID, 
											   @Param("date") LocalDate date);
}
