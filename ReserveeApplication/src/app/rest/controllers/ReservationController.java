package app.rest.controllers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
	public Reservation view(@FormParam("id") Long id) {
		return rComp.view(id);
	}

	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String create(Reservation re) {
		return rComp.create(re);
	}

	@POST
	@Path("/edit")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String edit(@FormParam("reservationID") Long reservationID, @FormParam("venueID") Long venueID,
			@FormParam("reserveeID") Long reserveeID, @FormParam("date") String date, @FormParam("time") String time) {
		LocalDate localDate = LocalDate.parse(date);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
		LocalTime localTime = LocalTime.parse(time, formatter);
		return rComp.edit(reservationID, venueID, reserveeID, localDate, localTime);
	}
	
	@POST
	@Path("/cancel")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String cancel(@FormParam("reservationID") Long reservationID, @FormParam("reserveeID") Long reserveeID) {
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
