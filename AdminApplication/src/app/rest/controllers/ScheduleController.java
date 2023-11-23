package app.rest.controllers;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import app.components.ScheduleComponent;
import app.entities.Schedule;

@Path("/schedule")
public class ScheduleController {
	
	@Autowired
	ScheduleComponent sComp;
	
	@POST
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String addSchedule(Schedule schedule) {
		return sComp.addSchedule(schedule);
    }
	
	@GET
	@Path("/view")
	@Produces(MediaType.APPLICATION_JSON)
    public List<Schedule> getScheduleByDate(@QueryParam("venueID") Long venueID, 
    										@QueryParam("year") int year, 
    										@QueryParam("month") int month, 
    										@QueryParam("day") int day) {
		return sComp.getScheduleByDate(venueID, year, month, day);
	}
}
