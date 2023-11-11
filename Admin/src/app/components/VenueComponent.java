package app.components;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entites.Venue;
import app.repositories.VenueRepository;

@Component
public class VenueComponent {
	
	@Autowired
	private VenueRepository vRepo;
	
	public Venue createVenue(Venue venue) {
		
		Venue v = new Venue();
		v.setVenueName(venue.getVenueName());
		v.setBuilding(venue.getBuilding());
		v.setRoomNo(venue.getRoomNo());
		v.setOfficeAssigned(venue.getOfficeAssigned());
		v.setSchedule(venue.getSchedule());
				
		return vRepo.save(v);
	}

}
