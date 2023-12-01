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

	public String requestReservation(ReservationRequestDTO resreq) throws Exception {
		
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
			
			Call<Reservee> createReservee = service.createReservee(res);
			Response<Reservee> createReserveeReply = createReservee.execute();
			
			reservee = createReserveeReply.body();
		} else { reservee = findReserveeReply.body().get(0); }
		
		// 2. Get the Venue instance
		Call<Venue> viewVenue = service.viewVenue(resreq.getVenueID());
		Response<Venue> viewVenueReply = viewVenue.execute();
		venue = viewVenueReply.body();
		
		if (venue == null) {
			return message = "This venue does not exist.";
		} 
		
		// 3. Verify that the starting and end time is valid for the Venue
		
		LocalTime vStart = LocalTime.parse(venue.getTimeStart());
		LocalTime vEnd = LocalTime.parse(venue.getTimeEnd());
		LocalTime rStart = LocalTime.parse(resreq.getTimeStart());
		LocalTime rEnd = LocalTime.parse(resreq.getTimeEnd());
		
		if (rStart.isBefore(vStart) || rEnd.isAfter(vEnd)) {
			return message = "This schedule is not valid for this venue.";
		}
		
		// 4. Check for any conflicts in schedule
		Reservation reservation = new Reservation();
		reservation.setReserveeID(reservee.getReserveeID());
		reservation.setVenueID(venue.getVenueID());
		reservation.setYear(resreq.getYear());
		reservation.setMonth(resreq.getMonth());
		reservation.setDay(resreq.getDay());
		reservation.setTimeStart(resreq.getTimeStart());
		reservation.setTimeEnd(resreq.getTimeEnd());
		reservation.setPurpose(resreq.getPurpose());
		System.out.println(reservation);
		
		Call<List<Reservation>> findReservationConflict = service.findReservationConflict(reservation);
		Response<List<Reservation>> findReservationConflictReply = findReservationConflict.execute();
		
		List<Reservation> conflictingReservations = findReservationConflictReply.body();
		if(!conflictingReservations.isEmpty()) {
			return message = "There are "+ conflictingReservations.size()+ " conflicting reservation/s "
					+ "with this schedule.";
		}
		
		// 5. Create the instance of the reservation
		Call<Reservation> requestReservation = service.createReservation(reservation);
		Response<Reservation> requestReservationReply = requestReservation.execute();	
		
		reservation = requestReservationReply.body();
		
		message = "The reservation has been successfully requested. (reservationID: "+ reservation.getReservationID() +")";
		return message;
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
