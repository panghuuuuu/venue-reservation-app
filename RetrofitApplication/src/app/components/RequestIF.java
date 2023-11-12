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
	// @POST("https://localhost:9998/reservation/create")
	// Call<ResponseBody> createReservation();
	
	@POST("http://localhost:9998/reservation/verify")
	Call<Reservation> verifyReservationID(@Field("reservationID") Long reservationID);

	@POST("https://localhost:9998/venue/view")
	Call<Venue> verifySchedule(@Field("venueID") Long venueID);
	
	@GET("http://localhost:9997/reservee/approvedreservations")
	Call<ResponseBody> getApprovedReservations();
}
