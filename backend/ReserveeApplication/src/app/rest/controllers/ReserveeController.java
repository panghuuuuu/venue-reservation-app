package app.rest.controllers;

import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import app.components.ReserveeComponent;
import app.entities.Reservee;

@Path("/reservee")
public class ReserveeController {
	@Autowired
	private ReserveeComponent rComp;

	@POST
	@Path("/createaccount")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String createAccount(Reservee re) {
		return rComp.create(re);
	}
	
	@GET
	@Path("/view")
	@Produces(MediaType.APPLICATION_JSON)
	public Reservee verifyReservee(@QueryParam("reserveeID") Long reserveeID) {
		return rComp.verifyReservee(reserveeID);
	}

}
