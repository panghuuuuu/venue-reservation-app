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
import javax.ws.rs.core.Response.ResponseBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.components.ReserveeComponent;
import app.entities.Reservee;


@Path("/reservee")
@CrossOrigin(origins = {"http://localhost:3000", "http://172.20.10.5:3000", "http://localhost:9997"})
public class ReserveeController {

    @Autowired
    private ReserveeComponent rComp;

    @Transactional
    @PostMapping(path = "createaccount")
    public String createAccount(Reservee reservee) {
        return rComp.create(reservee);
    }
  
    @GET
	@Path("/view")
	@Produces(MediaType.APPLICATION_JSON)    
    @CrossOrigin(origins = {"http://localhost:3000", "http://172.20.10.5:3000", "http://localhost:9997"})
    public Response verifyReservee(@QueryParam("reserveeID") Long reserveeID) {
        try {
            return Response.ok(rComp.verifyReservee(reserveeID)).header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS")
                    .header("Access-Control-Allow-Headers", "Content-Type")
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
            throw e; 
        }
    }
}
