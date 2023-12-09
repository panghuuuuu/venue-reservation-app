package app.rest.controllers;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import app.components.EquipmentComponent;
import app.entities.EquipmentRequest;

@Path("/equipment")
public class EquipmentController {

	@Autowired
	private EquipmentComponent eComp;
	
	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public EquipmentRequest createEquipment(EquipmentRequest equipreq) {
		return eComp.createEquipment(equipreq);
	}
}
