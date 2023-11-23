package app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import app.entities.Schedule;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long>  {
	
	@Query("SELECT s FROM Schedule s WHERE s.venueID = :venueID and s.year = :year and s.month = :month and s.day = :day") 
    List<Schedule> findScheduleByVenueYearMonthDay(@Param("venueID") Long venueID, 
    											   @Param("year") int year, 
    											   @Param("month") int month, 
    											   @Param("day") int day);
	
	public List<Schedule> findByVenueID(Long venueID);
}
