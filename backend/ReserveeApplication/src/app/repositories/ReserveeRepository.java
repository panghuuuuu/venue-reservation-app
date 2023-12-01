package app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import app.entities.Reservee;

@Repository
public interface ReserveeRepository extends JpaRepository<Reservee, Long> {
	public Reservee findByreserveeID(Long reserveeID);
	
	@Query("SELECT r FROM Reservee r WHERE r.schoolID = :schoolID AND r.type = :type AND "
			+ "r.firstName = :firstName AND r.lastName = :lastName")
	public List<Reservee> findBySchoolIDTypeFirstNameLastName (@Param("schoolID") Long schoolID,
															   @Param("type") String type,
														       @Param("firstName") String firstName,
														       @Param("lastName") String lastName);
}
