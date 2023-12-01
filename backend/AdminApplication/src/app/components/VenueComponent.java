package app.components;

import java.util.List;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entities.Venue;
import app.repositories.VenueRepository;

@Component
public class VenueComponent {
	
	@Autowired
	private VenueRepository vRepo;
	
	@PostConstruct
	public void init() {
		if (vRepo.count()==0) { 
			Venue v = createVenue("B 102 Classroom", "Berchmans Hall", "102", "CFMO", "08:00", "17:00");
			vRepo.save(v);
			
			v = createVenue("C 109 Classroom", "Schmitt Hall", "109", "CFMO", "08:00", "17:00");
			vRepo.save(v);
			
			v = createVenue("F 113 Classroom", "Faura Hall", "113", "CFMO", "08:00", "17:00");
			vRepo.save(v);
			
			v = createVenue("K 202 Classroom", "Kostka Hall", "202", "CFMO", "08:00", "17:00");
			vRepo.save(v);
			
			v = createVenue("SOM 106 Classroom", "JGSOM", "106", "CFMO", "08:00", "17:00");
			vRepo.save(v);
			
			v = createVenue("BEL 102 Classroom", "Bellarmine Hall", "102", "CFMO", "08:00", "10:00");
			vRepo.save(v);
			
			v = createVenue("MVP Roofdeck", "MVP", null, "CFMO", "08:00", "17:00");
			vRepo.save(v);
		}
	}
	
	public Venue createVenue(String venueName, 
						     String building, 
						     String roomNo, 
						     String officeAssigned,
						     String timeStart,
						     String timeEnd) {
		Venue venue = new Venue();
		venue.setVenueName(venueName);
		venue.setBuilding(building);
		venue.setRoomNo(roomNo);
		venue.setOfficeAssigned(officeAssigned);
		venue.setTimeStart(timeStart);
		venue.setTimeEnd(timeEnd);
		return vRepo.save(venue);
	}
	
	public Venue viewVenue(Long venueID) {
		Venue venue = vRepo.findByVenueID(venueID);
		return venue;
	}
}
