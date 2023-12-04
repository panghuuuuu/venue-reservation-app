package app.rest.controllers;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import app.components.ReservationComponent;
import app.entities.Reservation;

@Path("/reservation")
public class ReservationController {
	
	@Autowired
	private ReservationComponent rComp;

	@GET
    @Path("/view")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
    public Reservation view(@QueryParam("reservationID") Long reservationID) {
        return rComp.view(reservationID);
    }

	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Reservation create(Reservation res) {
		Reservation reservation = rComp.create(res);
		return reservation;
	}
	
	@POST
	@Path("/cancel")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String cancel(@FormParam("reservationID") Long reservationID, 
						 @FormParam("reserveeID") Long reserveeID) {
		return rComp.cancel(reservationID, reserveeID);
	}
	
	@POST
	@Path("/setstatus")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String setStatus(@FormParam("reservationID") Long reservationID, 
						    @FormParam("status") String status) {
		return rComp.setStatus(reservationID, status);
	}
	
	@POST
	@Path("/conflict")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Reservation> findConflicts (Reservation res) {
		System.out.println(res);
		return rComp.findConflict(res);
	}
	
	@GET
	@Path("/fetch")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Reservation> getAllReservations() {
		return rComp.getRecentReservations();
	}

}
