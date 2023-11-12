package app.components;

import app.entities.Reservation;
import app.entities.Reservee;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RequestIF {
	
	@POST("http://localhost:9998/reservee/verify")
	Call<Reservee> requestMessage(@Field("reserveeID") Long reserveeID);
	
	@POST("http://localhost:9998/reservation/verify")
	Call<Reservation> verifyReservationID(@Field("reservationID") Long reservationID);

	@POST("https://localhost:9998/admin/verifyschedule")
	Call<ResponseBody> verifySchedule(@Field("venue") String venue,
									  @Field("date") String date,
									  @Field("time") String time);
	
	@GET("http://localhost:9997/reservee/approvedreservations")
	Call<ResponseBody> getApprovedReservations();
}
