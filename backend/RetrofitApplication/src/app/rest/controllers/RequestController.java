package app.rest.controllers;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import app.components.RequestComponent;
import app.entities.EquipmentRequest;
import app.entities.Reservation;
import app.entities.ReservationRequestDTO;

@Path("/request")
@CrossOrigin(origins = {"http://localhost:3000", "http://172.20.10.5:3000", "http://localhost:9999"})
public class RequestController {
	
	@Autowired
	RequestComponent rc;
	
	@POST
	@Path("/reservation")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response requestReservation(ReservationRequestDTO resreq) throws Exception {
	    try {
	        Reservation reservation = rc.requestReservation(resreq);
	        return Response.ok(reservation)
	            .header("Access-Control-Allow-Origin", "*")
	            .header("Access-Control-Allow-Methods", "GET, POST, OPTIONS")
	            .header("Access-Control-Allow-Headers", "Content-Type")
	            .build();
	    } catch (Exception e) {
	        e.printStackTrace();
	        throw e;
	    }
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
