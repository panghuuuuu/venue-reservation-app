package app.rest.controllers;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import app.components.RequestComponent;
import app.entities.EquipmentRequest;
import app.entities.Reservation;
import app.entities.ReservationRequestDTO;

@Path("/request")
public class RequestController {
	
	@Autowired
	RequestComponent rc;
	
	@POST
	@Path("/reservation")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Reservation requestReservation(ReservationRequestDTO resreq) throws Exception {
		return rc.requestReservation(resreq);
	}
	
	@POST
	@Path("/equipment")
	@Consumes(MediaType.APPLICATION_JSON)
	public String requestEquipment(EquipmentRequest equipreq) throws Exception {
		return rc.requestEquipment(equipreq);
	}
	
	@POST
	@Path("/setstatus")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String setStatus(@FormParam("reservationID") Long reservationID,
							@FormParam("status") String status) throws Exception {
		return rc.setStatus(reservationID, status);
	}
}
