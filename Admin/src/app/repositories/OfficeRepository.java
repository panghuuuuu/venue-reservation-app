package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entites.Office;

@Repository
public interface OfficeRepository extends JpaRepository<Office, Long> {

}
