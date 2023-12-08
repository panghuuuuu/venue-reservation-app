package app.components;

import java.time.LocalTime;
import java.util.List;

import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import app.entities.EquipmentRequest;
import app.entities.Reservation;
import app.entities.Equipment;
import app.entities.ReservationRequestDTO;
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
	String message = "";
	Reservee reservee;
	Venue venue;
	
	@PostConstruct
	public void init(){
		retrofit = new Retrofit.Builder()
				.baseUrl("https://localhost:9999")
				.addConverterFactory(GsonConverterFactory.create())
				.build();
		
		service = retrofit.create(RequestIF.class);
	}

	public Reservation requestReservation(ReservationRequestDTO resreq) throws Exception {
		
		// 1.0 Get the Reservee instance
		Call<List<Reservee>> findReservee = service.findReservee(resreq.getSchoolID(),
																 resreq.getType(),
																 resreq.getFirstName(), 
															     resreq.getLastName());
		Response<List<Reservee>> findReserveeReply = findReservee.execute();
		
		// 1.1 If the Reservee does not exist, create a new Reservee instance
		if (findReserveeReply.body().isEmpty()) {
			Reservee res = new Reservee();
			res.setSchoolID(resreq.getSchoolID());
			res.setType(resreq.getType());
			res.setFirstName(resreq.getFirstName());
			res.setLastName(resreq.getLastName());
			res.setType(resreq.getType());
			res.setEmail(resreq.getEmail());
			
			Call<Reservee> createReservee = service.createReservee(res);
			Response<Reservee> createReserveeReply = createReservee.execute();
			
			reservee = createReserveeReply.body();
		} else { reservee = findReserveeReply.body().get(0); }
		
		// 2. Get the Venue instance
		Call<Venue> viewVenue = service.viewVenue(resreq.getVenueID());
		Response<Venue> viewVenueReply = viewVenue.execute();
		venue = viewVenueReply.body();

		// 3. Verify that the starting and end time is valid for the Venue
		LocalTime vStart = LocalTime.parse(venue.getTimeStart());
		LocalTime vEnd = LocalTime.parse(venue.getTimeEnd());
		LocalTime rStart = LocalTime.parse(resreq.getTimeStart());
		LocalTime rEnd = LocalTime.parse(resreq.getTimeEnd());
		
		if (rStart.isBefore(vStart) || rEnd.isAfter(vEnd)) {
			return null;
		}
		
		Reservation reservation = new Reservation();
		reservation.setReserveeID(reservee.getReserveeID());
		reservation.setVenueID(venue.getVenueID());
		reservation.setDate(resreq.getDate());
		reservation.setTimeStart(resreq.getTimeStart());
		reservation.setTimeEnd(resreq.getTimeEnd());
		reservation.setPurpose(resreq.getPurpose());
		reservation.setVenueName(venue.getVenueName());
		
		// 5. Create the instance of the reservation
		Call<Reservation> requestReservation = service.createReservation(reservation);
		Response<Reservation> requestReservationReply = requestReservation.execute();	
		
		reservation = requestReservationReply.body();

		return reservation;
	}

	public String requestEquipment(EquipmentRequest equipreq) throws Exception {
		
		// 1. Verify if the Reservation exists
		Call<Reservation> reservationVerification = service.viewReservation(equipreq.getReservationID());
		Response<Reservation> reservationVerificationResponse = reservationVerification.execute();
				
		Reservation reservation = reservationVerificationResponse.body();
				
		if(reservation == null) {
			return message = "The reservationID "+ equipreq.getReservationID() +" does not exist.";
		}
		
		// 2. Create the instance of the equipment request
		Call<Equipment> requestEquipment = service.requestEquipment(equipreq);
		Response<Equipment> requestEquipmentReply = requestEquipment.execute();
		
		Equipment equipment = requestEquipmentReply.body();
		
		System.out.println(equipment);
		
		message = "The equipment has been requested. (equipmentID: "+ equipment.getEquipmentID() +")";
		return message;
	}

	public String setStatus(Long reservationID, String status) throws Exception {
		
		// 1. Verify if the Reservation exists
		Call<Reservation> reservationVerification = service.viewReservation(reservationID);
		Response<Reservation> reservationVerificationResponse = reservationVerification.execute();
		
		Reservation reservation = reservationVerificationResponse.body();
		
		if(reservation == null) {
			message = "The reservationID "+ reservationID +" does not exist.";
			return message;
		}
		
		// 2. Update the status of the Reservation
		Call<ResponseBody> statusUpdate = service.setReservationStatus(reservationID, status);
		Response<ResponseBody> statusUpdateResponse = statusUpdate.execute();
		
		message = statusUpdateResponse.body().string();
		
		return message;
	}
}
