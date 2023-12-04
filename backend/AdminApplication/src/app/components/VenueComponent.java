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
		// Initialize Venue instances in the database
		if (vRepo.count()==0) { 
			// Berchman's Hall
			vRepo.save(createVenue("B 102", "Berchmans Hall", "102", "CFMO", "08:00", "17:00","Classroom"));
			vRepo.save(createVenue("B 103", "Berchmans Hall", "103", "CFMO", "08:00", "17:00","Classroom"));
			vRepo.save(createVenue("B 104", "Berchmans Hall", "104", "CFMO", "08:00", "17:00","Classroom"));
			vRepo.save(createVenue("B 105", "Berchmans Hall", "105", "CFMO", "08:00", "17:00","Classroom"));
			vRepo.save(createVenue("B 106", "Berchmans Hall", "106", "CFMO", "08:00", "17:00","Classroom"));
			vRepo.save(createVenue("B 206", "Berchmans Hall", "206", "CFMO", "08:00", "17:00","Classroom"));
			vRepo.save(createVenue("B 207", "Berchmans Hall", "207", "CFMO", "08:00", "17:00","Classroom"));
			vRepo.save(createVenue("B 208", "Berchmans Hall", "208", "CFMO", "08:00", "17:00","Classroom"));
			vRepo.save(createVenue("B 209", "Berchmans Hall", "209", "CFMO", "08:00", "17:00","Classroom"));
			vRepo.save(createVenue("B 305", "Berchmans Hall", "305", "CFMO", "08:00", "17:00","Classroom"));
			vRepo.save(createVenue("B 306", "Berchmans Hall", "306", "CFMO", "08:00", "17:00","Classroom"));
			vRepo.save(createVenue("B 307", "Berchmans Hall", "307", "CFMO", "08:00", "17:00","Classroom"));
			vRepo.save(createVenue("B 308", "Berchmans Hall", "308", "CFMO", "08:00", "17:00","Classroom"));
			vRepo.save(createVenue("B 309", "Berchmans Hall", "309", "CFMO", "08:00", "17:00","Classroom"));
			
			// Schmitt Hall
			vRepo.save(createVenue("C 109", "Schmitt Hall", "109", "CFMO", "08:00", "17:00","Classroom"));
			vRepo.save(createVenue("C 114", "Schmitt Hall", "114", "CFMO", "08:00", "17:00","Classroom"));
			
			// PLDT-CTC
			vRepo.save(createVenue("CTC 102", "PLDT-CTC", "102", "CFMO", "08:00", "17:00","Classroom"));
			vRepo.save(createVenue("CTC 103", "PLDT-CTC", "103", "CFMO", "08:00", "17:00","Classroom"));
			vRepo.save(createVenue("CTC 104", "PLDT-CTC", "104", "CFMO", "08:00", "17:00","Classroom"));
			vRepo.save(createVenue("CTC 105", "PLDT-CTC", "105", "CFMO", "08:00", "17:00","Classroom"));
			vRepo.save(createVenue("CTC 106", "PLDT-CTC", "106", "CFMO", "08:00", "17:00","Classroom"));
			vRepo.save(createVenue("CTC 118", "PLDT-CTC", "118", "CFMO", "08:00", "17:00","Classroom"));
			vRepo.save(createVenue("CTC 202", "PLDT-CTC", "202", "CFMO", "08:00", "17:00","Classroom"));
			vRepo.save(createVenue("CTC 203", "PLDT-CTC", "203", "CFMO", "08:00", "17:00","Classroom"));
			vRepo.save(createVenue("CTC 204", "PLDT-CTC", "204", "CFMO", "08:00", "17:00","Classroom"));
			vRepo.save(createVenue("CTC 205", "PLDT-CTC", "205", "CFMO", "08:00", "17:00","Classroom"));
			vRepo.save(createVenue("CTC 206", "PLDT-CTC", "206", "CFMO", "08:00", "17:00","Classroom"));
			vRepo.save(createVenue("CTC 216", "PLDT-CTC", "216", "CFMO", "08:00", "17:00","Classroom"));
			vRepo.save(createVenue("CTC 302", "PLDT-CTC", "302", "CFMO", "08:00", "17:00","Classroom"));
			vRepo.save(createVenue("CTC 303", "PLDT-CTC", "303", "CFMO", "08:00", "17:00","Classroom"));
			vRepo.save(createVenue("CTC 304", "PLDT-CTC", "304", "CFMO", "08:00", "17:00","Classroom"));
			vRepo.save(createVenue("CTC 305", "PLDT-CTC", "305", "CFMO", "08:00", "17:00","Classroom"));
			vRepo.save(createVenue("CTC 306", "PLDT-CTC", "306", "CFMO", "08:00", "17:00","Classroom"));
			vRepo.save(createVenue("CTC 307", "PLDT-CTC", "307", "CFMO", "08:00", "17:00","Classroom"));
			vRepo.save(createVenue("CTC 308", "PLDT-CTC", "308", "CFMO", "08:00", "17:00","Classroom"));
			vRepo.save(createVenue("CTC 404", "PLDT-CTC", "404", "CFMO", "08:00", "17:00","Classroom"));
			vRepo.save(createVenue("CTC 405", "PLDT-CTC", "405", "CFMO", "08:00", "17:00","Classroom"));
			vRepo.save(createVenue("CTC 406", "PLDT-CTC", "406", "CFMO", "08:00", "17:00","Classroom"));
			vRepo.save(createVenue("CTC 407", "PLDT-CTC", "407", "CFMO", "08:00", "17:00","Classroom"));
			vRepo.save(createVenue("CTC 408", "PLDT-CTC", "408", "CFMO", "08:00", "17:00","Classroom"));
			
			// Bellarmine Hall
			vRepo.save(createVenue("BEL 102", "Bellarmine Hall", "102", "CFMO", "08:00", "17:00", "Classroom"));
			vRepo.save(createVenue("BEL 103B", "Bellarmine Hall", "103B", "CFMO", "08:00", "17:00", "Classroom"));
			vRepo.save(createVenue("BEL 205", "Bellarmine Hall", "205", "CFMO", "08:00", "17:00", "Classroom"));
			vRepo.save(createVenue("BEL 206", "Bellarmine Hall", "206", "CFMO", "08:00", "17:00", "Classroom"));
			vRepo.save(createVenue("BEL 207", "Bellarmine Hall", "207", "CFMO", "08:00", "17:00", "Classroom"));
			vRepo.save(createVenue("BEL 208", "Bellarmine Hall", "208", "CFMO", "08:00", "17:00", "Classroom"));
			vRepo.save(createVenue("BEL 209", "Bellarmine Hall", "209", "CFMO", "08:00", "17:00", "Classroom"));
			vRepo.save(createVenue("BEL 210", "Bellarmine Hall", "210", "CFMO", "08:00", "17:00", "Classroom"));
			vRepo.save(createVenue("BEL 211", "Bellarmine Hall", "211", "CFMO", "08:00", "17:00", "Classroom"));
			vRepo.save(createVenue("BEL 212", "Bellarmine Hall", "212", "CFMO", "08:00", "17:00", "Classroom"));
			vRepo.save(createVenue("BEL 213", "Bellarmine Hall", "213", "CFMO", "08:00", "17:00", "Classroom"));
			vRepo.save(createVenue("BEL 306", "Bellarmine Hall", "306", "CFMO", "08:00", "17:00", "Classroom"));
			vRepo.save(createVenue("BEL 307", "Bellarmine Hall", "307", "CFMO", "08:00", "17:00", "Classroom"));
			vRepo.save(createVenue("BEL 308", "Bellarmine Hall", "308", "CFMO", "08:00", "17:00", "Classroom"));
			vRepo.save(createVenue("BEL 309", "Bellarmine Hall", "309", "CFMO", "08:00", "17:00", "Classroom"));
			vRepo.save(createVenue("BEL 311", "Bellarmine Hall", "311", "CFMO", "08:00", "17:00", "Classroom"));
			vRepo.save(createVenue("BEL 312", "Bellarmine Hall", "312", "CFMO", "08:00", "17:00", "Classroom"));
			vRepo.save(createVenue("BEL 313", "Bellarmine Hall", "313", "CFMO", "08:00", "17:00", "Classroom"));
			vRepo.save(createVenue("BEL 310", "Bellarmine Hall", "310", "CFMO", "08:00", "17:00", "Classroom"));
			
			// Faura Hall
			vRepo.save(createVenue("F 113", "Faura Hall", "113", "CFMO", "08:00", "17:00","Classroom"));
			vRepo.save(createVenue("F 114", "Faura Hall", "114", "CFMO", "08:00", "17:00","Classroom"));
			vRepo.save(createVenue("F 115", "Faura Hall", "115", "CFMO", "08:00", "17:00","Classroom"));
			vRepo.save(createVenue("F 116", "Faura Hall", "116", "CFMO", "08:00", "17:00","Classroom"));
			vRepo.save(createVenue("F 304", "Faura Hall", "304", "CFMO", "08:00", "17:00","Classroom"));
			
			// SEC
			vRepo.save(createVenue("SEC A 117", "SEC", "117", "CFMO", "08:00", "17:00","Classroom"));
			vRepo.save(createVenue("SEC A 118", "SEC", "118", "CFMO", "08:00", "17:00","Classroom"));
			vRepo.save(createVenue("SEC A 123", "SEC", "123", "CFMO", "08:00", "17:00","Classroom"));
			vRepo.save(createVenue("SEC A 124", "SEC", "124", "CFMO", "08:00", "17:00","Classroom"));
			vRepo.save(createVenue("SEC A 208", "SEC", "208", "CFMO", "08:00", "17:00","Classroom"));
			vRepo.save(createVenue("SEC A 209", "SEC", "209", "CFMO", "08:00", "17:00","Classroom"));
			vRepo.save(createVenue("SEC A 210", "SEC", "210", "CFMO", "08:00", "17:00","Classroom"));
			vRepo.save(createVenue("SEC A 214", "SEC", "214", "CFMO", "08:00", "17:00","Classroom"));
			vRepo.save(createVenue("SEC A 215", "SEC", "215", "CFMO", "08:00", "17:00","Classroom"));
			vRepo.save(createVenue("SEC A 202", "SEC", "202", "CFMO", "08:00", "17:00","Seminar Room"));
			vRepo.save(createVenue("SEC A 203", "SEC", "203", "CFMO", "08:00", "17:00","Seminar Room"));
			vRepo.save(createVenue("SEC A 204", "SEC", "204", "CFMO", "08:00", "17:00","Seminar Room"));
			vRepo.save(createVenue("SEC A 205", "SEC", "205", "CFMO", "08:00", "17:00","Seminar Room"));
			vRepo.save(createVenue("SEC B 201", "SEC", "201", "CFMO", "08:00", "21:30","Lecture Hall"));
			vRepo.save(createVenue("SEC C 201", "SEC", "201", "CFMO", "08:00", "21:30","Lecture Hall"));
			vRepo.save(createVenue("Escaler Hall", "SEC", "201", "CFMO", "08:00", "21:30","Lecture Hall"));
		}
	}
	
	public Venue createVenue(String venueName, 
						     String building, 
						     String roomNo, 
						     String officeAssigned,
						     String timeStart,
						     String timeEnd,
						     String type) {
		Venue venue = new Venue();
		venue.setVenueName(venueName);
		venue.setBuilding(building);
		venue.setRoomNo(roomNo);
		venue.setOfficeAssigned(officeAssigned);
		venue.setTimeStart(timeStart);
		venue.setTimeEnd(timeEnd);
		venue.setType(type);
		return vRepo.save(venue);
	}
	
	public Venue viewVenue(Long venueID) {
		Venue venue = vRepo.findByVenueID(venueID);
		return venue;
	}

	public List<Venue> getAllVenues() {
		return vRepo.findAll();
	}
}
