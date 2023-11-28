package app.components;

import app.entities.Equipment;
import app.entities.EquipmentRequest;
import app.entities.Reservation;
import app.entities.ReservationRequest;
import app.entities.Reservee;
import app.entities.Venue;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RequestIF {
	
	@Headers("Origin: http://localhost:3000") 
	@GET("http://localhost:9997/reservee/view")
	Call<Reservee> verifyReservee(@Query("reserveeID") Long reserveeID);
	
	@Headers("Origin: http://localhost:3000") 
	@GET("http://localhost:9998/venue/view")
	Call<Venue> verifyVenue(@Query("venueID") Long venueID);
	
	@Headers("Origin: http://localhost:3000") 
	@POST("http://localhost:9997/reservation/create")
	Call<Reservation> requestReservation(@Body ReservationRequest resreq);
	
	@Headers("Origin: http://localhost:3000") 
	@POST("http://localhost:9998/equipment/create")
	Call<Equipment> requestEquipment(@Body EquipmentRequest equipreq);
	
	@Headers("Origin: http://localhost:3000") 
	@GET("http://localhost:9997/reservation/view")
	Call<Reservation> verifyReservation(@Query("reservationID") Long reservationID);
	
	@Headers("Origin: http://localhost:3000") 
	@POST("http://localhost:9997/reservation/setstatus")
	@FormUrlEncoded
	Call<ResponseBody> setReservationStatus(@Field("reservationID") Long reservationID,
											@Field("status") String status);
}