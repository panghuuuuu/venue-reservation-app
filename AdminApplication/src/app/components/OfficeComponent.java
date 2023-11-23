package app.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entities.Office;
import app.repositories.OfficeRepository;

@Component
public class OfficeComponent {

	@Autowired
	private OfficeRepository oRepo;
	
	public Office createOffice(Office office) {
		Office o = new Office();
		o.setOfficeName(office.getOfficeName());
		
		return oRepo.save(o);
	}
}
