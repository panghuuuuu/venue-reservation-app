package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entites.Venue;

@Repository
public interface VenueRepository extends JpaRepository<Venue, Long> {

}
