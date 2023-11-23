package app.components;

import java.io.IOException;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import app.entities.EquipmentRequest;
import app.entities.Reservation;
import app.entities.Equipment;
import app.entities.ReservationRequest;
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
	public void init(){
		retrofit = new Retrofit.Builder()
				.baseUrl("https://localhost:9999")
				.addConverterFactory(GsonConverterFactory.create())
				.build();
		
		service = retrofit.create(RequestIF.class);
	}

	public String requestReservation(ReservationRequest resreq) throws Exception {
		
		String message;
		Long reserveeID = resreq.getReserveeID();
		Long venueID = resreq.getVenueID();
		
		Call<Reservee> reserveeVerification = service.verifyReservee(reserveeID);
		Response<Reservee> reserveeVerificationResponse = reserveeVerification.execute();
		
		Reservee reservee = reserveeVerificationResponse.body();
		
		if (reservee == null) {
			message = "The reserveeID " + reserveeID + " does not exist. Please create an account first.";
			return message;
		} else if (!(reservee.getSchoolID().equals(resreq.getSchoolID()))) {
			message = "Please make sure you are using the correct reserveeID.";
			return message;
		}
		
		Call<Venue> venueVerification = service.verifyVenue(venueID);
		Response<Venue> venueVerificationResponse = venueVerification.execute();
		
		Venue venue = venueVerificationResponse.body();
		
		if(venue == null) {
			message = "The venue " + venueID + " does not exist.";
			return message;
		}
		
		Call<Reservation> reservationRequest = service.requestReservation(resreq);
		Response<Reservation> reservationRequestResponse = reservationRequest.execute();
		
		Reservation reservation = reservationRequestResponse.body();
		Long reservationID = reservation.getReservationID();
		
		message = "The reservation is successfully requested. ReservationID: " + reservationID + ".";
		return message;
	}

	public String requestEquipment(EquipmentRequest equipreq) throws Exception {
		
		System.out.println(equipreq);
		String message;
		Long reservationID = equipreq.getReservationID();
		
		Call<Reservation> reservationVerification = service.verifyReservation(reservationID);
		Response<Reservation> reservationVerificationResponse = reservationVerification.execute();
		
		Reservation reservation = reservationVerificationResponse.body();
		
		if(reservation == null) {
			message = "This reservationID "+ reservationID +" does not exist. Please create a reservation first.";
			return message;
		}
		
		Call<Equipment> equipmentRequest = service.requestEquipment(equipreq);
		Response<Equipment> equipmentRequestResponse = equipmentRequest.execute();
		System.out.println(equipmentRequestResponse);
		
		Equipment equipment = equipmentRequestResponse.body();
		Long equipmentID = equipment.getEquipmentID();
		
		message = "The equipment is successfully requested. EquipmentRequestID: "+ equipmentID +".";
		return message;
	}

	public String setStatus(Long reservationID, String status) throws Exception {
		
		String message;
		
		Call<Reservation> reservationVerification = service.verifyReservation(reservationID);
		Response<Reservation> reservationVerificationResponse = reservationVerification.execute();
		
		Reservation reservation = reservationVerificationResponse.body();
		
		if(reservation == null) {
			message = "This reservationID "+ reservationID +" does not exist.";
			return message;
		}
		
		Call<ResponseBody> statusUpdate = service.setReservationStatus(reservationID, status);
		Response<ResponseBody> statusUpdateResponse = statusUpdate.execute();
		
		message = statusUpdateResponse.body().string();
		
		return message;
	}
}
