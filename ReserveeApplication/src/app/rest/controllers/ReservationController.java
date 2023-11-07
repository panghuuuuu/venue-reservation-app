package app.rest.controllers;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import app.components.ReservationComponent;
import app.entities.Reservation;

@Path("/reservation")
public class ReservationController 
{
	@Autowired
	private ReservationComponent rComp;
	
	@POST
	@Path("/view")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public String view(@FormParam("id") Long id)
	{
		return rComp.view(id);
	}
	
	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String create(Reservation re)
	{
		return rComp.create(re);
	}

}
