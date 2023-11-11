package app.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entites.Equipment;
import app.repositories.EquipmentRepository;

@Component
public class EquipmentComponent {
	
	@Autowired
	private EquipmentRepository eRepo;
	
	public Equipment createEquipment(Equipment equipment)
	 {
			
			Equipment e = new Equipment();
			e.setTables(equipment.getTables());
			e.setChairs(equipment.getChairs());
			e.setExtensions(equipment.getExtensions());
			e.setProjectors(equipment.getProjectors());
			e.setProjectorScreens(equipment.getProjectorScreens());
			e.setMicrophones(equipment.getMicrophones());
			e.setSpeakers(equipment.getSpeakers());
					
			return eRepo.save(e);
		}
}
