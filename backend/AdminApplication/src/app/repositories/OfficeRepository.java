package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entities.Office;

@Repository
public interface OfficeRepository extends JpaRepository<Office, Long> {

}
