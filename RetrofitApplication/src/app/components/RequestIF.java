package app.components;

import app.entities.Reservation;
import app.entities.Reservee;
import app.entities.Venue;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RequestIF {
	
	@POST("http://localhost:9998/reservee/verify")
	Call<Reservee> verifyReservee(@Field("reserveeID") Long reserveeID);
	
	// TODO: finalize ReserveeApplication method for creating a reservation
	//       and add parameters
	// @POST("http://localhost:9998/reservation/create")
	// Call<ResponseBody> createReservation();
	
	// TODO: finalize AdminApplication method for creating an equipment request
	//       and add parameters
	// @POST("http://localhost:9998/equipment/create")
	// Call<ResponseBody> createEquipment();
	
	@POST("http://localhost:9998/reservation/verify")
	Call<Reservation> verifyReservation(@Field("reservationID") Long reservationID);

	@POST("http://localhost:9998/venue/view")
	Call<Venue> verifySchedule(@Field("venueID") Long venueID);
	
	@POST("http://localhost:9998/reservation/setstatus")
	Call<ResponseBody> changeStatus(@Field("reservationID") Long reservationID,
							        @Field("status") String status);
	
	@GET("http://localhost:9997/reservee/approvedreservations")
	Call<ResponseBody> getApprovedReservations();
}
