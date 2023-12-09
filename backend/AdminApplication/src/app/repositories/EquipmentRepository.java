package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entities.EquipmentRequest;

@Repository
public interface EquipmentRepository extends JpaRepository<EquipmentRequest, Long>  {

}
