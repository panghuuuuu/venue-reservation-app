package app.rest.controllers;

import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.components.VenueComponent;
import app.entities.Venue;

@RestController
@Path("/venue")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class VenueController {

	@Autowired
	private VenueComponent vComp;
	
	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Venue createVenue(Venue venue) {
		return vComp.createVenue(venue.getVenueName(),
								 venue.getBuilding(),
								 venue.getRoomNo(),
								 venue.getOfficeAssigned(), 
								 venue.getTimeStart(),
								 venue.getTimeEnd(),
								 venue.getType());
	}
	
    @GET
    @Path("/view")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Venue viewVenue(@QueryParam("venueID") Long venueID) {
        return vComp.viewVenue(venueID);
    }
    
    @GET
    @Path("/fetch")
    @GetMapping("/fetch")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Venue> getAllVenues() {
    	return vComp.getAllVenues();
    }
}
