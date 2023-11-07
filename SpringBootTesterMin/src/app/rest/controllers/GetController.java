package app.rest.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


// test using browser address http://127.0.0.1:9999/testcontroller/hello or /bye

@Component
@Path("/testcontroller")
public class GetController {
	
	
	Logger logger = LoggerFactory.getLogger(GetController.class);
	
	@GET
	@Path("/hello")
	public String hello()
	{
		logger.info("I have reached the controller!");
		return "GET hello!";
	}

	@GET
	@Path("/bye")
	public String bye()
	{
		logger.info("I have reached the controller!");
		return "GET bye!";
	}

}
