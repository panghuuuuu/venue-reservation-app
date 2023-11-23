package app.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entities.Equipment;
import app.entities.EquipmentRequest;
import app.repositories.EquipmentRepository;

@Component
public class EquipmentComponent {
	
	@Autowired
	private EquipmentRepository eRepo;
	
	public Equipment createEquipment(EquipmentRequest equipreq)
	 {
			Equipment e = new Equipment();
			e.setTables(equipreq.getTables());
			e.setChairs(equipreq.getChairs());
			e.setExtensions(equipreq.getExtensions());
			e.setProjectors(equipreq.getProjectors());
			e.setProjectorScreens(equipreq.getProjectorScreens());
			e.setMicrophones(equipreq.getMicrophones());
			e.setSpeakers(equipreq.getSpeakers());
			e = eRepo.save(e);
					
			return e;
		}
}
