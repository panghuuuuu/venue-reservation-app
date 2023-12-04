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
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import app.components.ReserveeComponent;
import app.entities.Reservee;
import javax.ws.rs.OPTIONS;

@Path("/reservee")
@CrossOrigin(origins = {"http://localhost:3000", "http://172.20.10.5:3000", "http://localhost:9997"})
public class ReserveeController {

    @Autowired
    private ReserveeComponent rComp;

    @OPTIONS
    @Path("/createaccount")
    public Response optionsForCreateAccount() {
        return Response.ok()
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "POST, OPTIONS")
                .header("Access-Control-Allow-Headers", "Content-Type, Authorization")
                .build();
    }
    
    @POST
    @Path("/createaccount")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @CrossOrigin(origins = {"http://localhost:3000", "http://172.20.10.5:3000", "http://localhost:9997"})
    public Response createAccount(Reservee reservee) {
        try {
        	return Response.ok(rComp.create(reservee))
        			   .header("Access-Control-Allow-Origin", "*")
        			   .header("Access-Control-Allow-Methods", "POST, OPTIONS")
        			   .header("Access-Control-Allow-Headers", "Content-Type, Authorization")
        			   .build();
        } catch(Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @GET
	@Path("/view")
	@Produces(MediaType.APPLICATION_JSON)    
    @CrossOrigin(origins = {"http://localhost:3000", "http://172.20.10.5:3000", "http://localhost:9997"})
    public Response viewReservee(@QueryParam("reserveeID") Long reserveeID) {
        try {
            return Response.ok(rComp.viewReservee(reserveeID))
            		.header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Methods", "GET, OPTIONS")
                    .header("Access-Control-Allow-Headers", "Content-Type")
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
            throw e; 
        }
    }
    
    @GET
    @Path("/find")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Reservee> findReservee(@QueryParam("schoolID") Long schoolID,
    								   @QueryParam("type") String type,
    								   @QueryParam("firstName") String firstName,
    								   @QueryParam("lastName") String lastName) {
    	return rComp.findReservee(schoolID, type, firstName, lastName);
    }
}
