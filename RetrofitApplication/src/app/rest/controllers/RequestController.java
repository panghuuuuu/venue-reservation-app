package app.rest.controllers;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import app.components.RequestComponent;

@Path("/request")
public class RequestController {
	
	@Autowired
	RequestComponent rc;
	
	@POST
	@Path("/reservation")
	@Consumes(MediaType.APPLICATION_JSON)
	public String requestReservation(ReservationRequestDTO resreq) throws IOException {
		return rc.requestReservation(resreq.getReserveeID(),
									 resreq.getVenueID(),
									 resreq.getVenueName(),
									 resreq.getBuilding(),
									 resreq.getRoomNo(),
									 resreq.getDate(),
									 resreq.getTime());
	}
	
	@POST
	@Path("/equipment")
	@Consumes(MediaType.APPLICATION_JSON)
	public String requestEquipment(EquipmentRequestDTO equipreq) {
		return rc.requestEquipment(equipreq.getReservationID(),
								   equipreq.getTables(),
								   equipreq.getChairs(),
								   equipreq.getExtensions(),
								   equipreq.getProjectors(),
								   equipreq.getProjectorScreens(),
								   equipreq.getMicrophones(),
								   equipreq.getSpeakers());
	}
	
	@POST
	@Path("/setstatus")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String setStatus(@FormParam("reservationID") Long reservationID,
							@FormParam("status") String status) {
		return rc.setStatus(reservationID, status);
	}
}
