package app.components;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entites.Venue;
import app.repositories.VenueRepository;

@Component
public class VenueComponent {
	
	@Autowired
	private VenueRepository vRepo;
	
	public Venue createVenue(Venue venue) {
	    return vRepo.save(venue);
	}
	
	@Transactional
	public Venue viewVenue(Long venueID) {
		Venue venue = vRepo.findByVenueID(venueID);
	    venue.getSchedule().size();
		return venue;
	}
}
