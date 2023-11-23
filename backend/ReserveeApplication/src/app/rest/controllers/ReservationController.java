package app.rest.controllers;

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
import app.entities.ReservationRequest;

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
	public Reservation create(ReservationRequest resreq) {
		return rComp.create(resreq);
	}

	@POST
	@Path("/edit")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String edit(@FormParam("reservationID") Long reservationID, 
					   @FormParam("reserveeID") Long reserveeID, 
					   @FormParam("reservationYear") int reservationYear, 
					   @FormParam("reservationMonth") int reservationMonth,
					   @FormParam("reservationDay") int reservationDay,
					   @FormParam("timeStart") String timeStart,
					   @FormParam("timeEnd") String timeEnd) {
		return rComp.edit(reservationID, 
						  reserveeID, 
						  reservationYear, 
						  reservationMonth, 
						  reservationDay, 
						  timeStart, 
						  timeEnd);
	}
	
	@POST
	@Path("/cancel")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String cancel(@FormParam("reservationID") Long reservationID, 
					@FormParam("reserveeID") Long reserveeID) {
		return rComp.cancel(reservationID, reserveeID);
	}
	
	@POST
	@Path("/setstatus")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String setStatus(@FormParam("reservationID") Long reservationID,
					   	    @FormParam("status") String status) {
		return rComp.setStatus(reservationID, status);
	}

}
