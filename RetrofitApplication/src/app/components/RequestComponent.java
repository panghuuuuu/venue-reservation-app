package app.components;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Component
public class RequestComponent {
	
	Retrofit retrofit;
	
	@PostConstruct
	public void init() {
		retrofit = new Retrofit.Builder()
				.baseUrl("https://localhost:9999")
				.addConverterFactory(GsonConverterFactory.create())
				.build();
	}

	public String requestReservation(Long reserveeID, 
								     Long venueID, 
								     String venueName, 
								     String building, 
								     String roomNo,
								     String date, 
								     String time) {
		// TODO method to request a reservation
		return null;
	}

	public String requestEquipment(Long reservationID, 
							       Long tables, 
							       Long chairs, 
							       Long extensions, 
							       Long projectors,
							       Long projectorScreens, 
							       Long microphones, 
							       Long speakers) {
		// TODO method to request equipment
		return null;
	}

	public String setStatus(Long reservationID, String status) {
		// TODO method to set the status for a reservation
		return null;
	}

}
