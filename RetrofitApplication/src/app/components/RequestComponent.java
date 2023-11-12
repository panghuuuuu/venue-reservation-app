package app.components;

import org.springframework.stereotype.Component;

@Component
public class RequestComponent {

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
