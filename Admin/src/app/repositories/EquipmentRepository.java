package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entites.Equipment;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Long>  {

}
