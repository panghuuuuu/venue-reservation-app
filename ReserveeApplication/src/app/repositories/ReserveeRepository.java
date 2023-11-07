package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entities.Reservee;

@Repository
public interface ReserveeRepository extends JpaRepository<Reservee, Long> 
{

}
