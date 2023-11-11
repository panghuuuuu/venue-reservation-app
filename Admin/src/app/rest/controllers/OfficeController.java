package app.rest.controllers;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import app.components.OfficeComponent;
import app.entites.Office;

@Path("/office")
public class OfficeController {

	@Autowired
	private OfficeComponent oComp;
	
	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Office createOffice(Office office) {
		
		return oComp.createOffice(office);
	}
}
