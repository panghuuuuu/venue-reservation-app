package app.rest.controllers;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import app.components.RequestComponent;
import app.entities.EquipmentRequest;
import app.entities.ReservationRequest;

@Path("/request")
public class RequestController {
	
	@Autowired
	RequestComponent rc;
	
	@POST
	@Path("/reservation")
	@Consumes(MediaType.APPLICATION_JSON)
	public String requestReservation(ReservationRequest resreq) throws Exception {
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
	public String setStatus(@FormParam("reservationID") Long reservationID,
							@FormParam("status") String status) throws Exception {
		return rc.setStatus(reservationID, status);
	}
}
