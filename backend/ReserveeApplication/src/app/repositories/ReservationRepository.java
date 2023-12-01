package app.repositories;

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
	
	@Query("SELECT r FROM Reservation r WHERE r.venueID = :venueID "
			+ "AND r.year = :year AND r.month = :month AND r.day = :day")
	public List<Reservation> findByVenueIDYearMonthDay(@Param("venueID") Long venueID,
													   @Param("year") int year,
													   @Param("month") int month,
													   @Param("day") int day);

}
