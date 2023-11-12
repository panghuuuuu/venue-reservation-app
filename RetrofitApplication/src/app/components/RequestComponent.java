package app.components;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import app.entities.Reservation;
import app.entities.Reservee;
import app.entities.Venue;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Component
public class RequestComponent {
	
	Retrofit retrofit;
	RequestIF service;
	
	@PostConstruct
	public void init() {
		retrofit = new Retrofit.Builder()
				.baseUrl("https://localhost:9999")
				.addConverterFactory(GsonConverterFactory.create())
				.build();
		
		service = retrofit.create(RequestIF.class);
	}

	public String requestReservation(Long reserveeID, 
								     Long venueID, 
								     String venueName, 
								     String building, 
								     String roomNo,
								     String date, 
								     String time) throws IOException {
		
		Call<Reservee> verifyReservee = service.verifyReservee(reserveeID);
		Response<Reservee> reserveeVerificationReply = verifyReservee.execute();
		
		Reservee reservee = reserveeVerificationReply.body();
		
		if(reservee == null) {
			return "The reserveeID "+ reserveeID +" does not exist. Please create an account first.";
		} 
		
		Call<Venue> verifySchedule = service.verifySchedule(venueID);
		Response<Venue> scheduleVerificationReply = verifySchedule.execute();
		
		List<String> schedule = scheduleVerificationReply.body().getSchedule();
		
		// TODO: go through the schedule list and check if the given time and date exists in the venue
		
		// TODO: go through all approved reservations and check for any time conflicts
		
		Reservation reservation = new Reservation();
		
		// TODO: add method to create the reservation
		
		// TODO: edit the string to follow the project proposal
		return "The reservation is successfully requested.";
	}

	public String requestEquipment(Long reservationID, 
							       Long tables, 
							       Long chairs, 
							       Long extensions, 
							       Long projectors,
							       Long projectorScreens, 
							       Long microphones, 
							       Long speakers) throws IOException {
		
		Call<Reservation> verifyReservation = service.verifyReservation(reservationID);
		Response<Reservation> reservationVerificactionReply = verifyReservation.execute();
		
		Reservation reservation = reservationVerificactionReply.body();
		
		if(reservation == null) {
			return "This reservationID " + reservationID + " does not exist. Please make a reservation first.";
		}
		
		// TODO: add a method to create the equipment request
		
		// TODO: edit the string to follow the project proposal
		return "The equipment is successfully requested.";
	}

	public String setStatus(Long reservationID, String status) throws IOException {
		
		Call<Reservation> verifyReservation = service.verifyReservation(reservationID);
		Response<Reservation> reservationVerificactionReply = verifyReservation.execute();
		
		Reservation reservation = reservationVerificactionReply.body();
		
		if(reservation == null) {
			return "This reservationID " + reservationID + " does not exist. Please make a reservation first.";
		}
		
		Call<ResponseBody> changeStatus = service.changeStatus(reservationID, status);
		Response<ResponseBody> statusChangeReply = changeStatus.execute();
		
		String message = statusChangeReply.body().toString();
		
		return message;
	}

}
