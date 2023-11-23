package app.components;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entities.Schedule;
import app.entities.Venue;
import app.repositories.ScheduleRepository;
import app.repositories.VenueRepository;

@Component
public class ScheduleComponent {

	@Autowired
	private VenueRepository vRepo;
	
	@Autowired
	private ScheduleRepository sRepo;
	
	public String addSchedule(Schedule s) {

		Long venueID = s.getVenueID();
		Venue venue = vRepo.findByVenueID(venueID);
		
		if(venue == null) {
			return "No such venue (venueID: "+ venueID +") exists.";
		}
		
		Schedule schedule = new Schedule();
		schedule.setVenueID(venueID);
		schedule.setYear(s.getYear());
		schedule.setMonth(s.getMonth());
		schedule.setDay(s.getDay());
		schedule.setTimeStart(s.getTimeStart());
		schedule.setTimeEnd(s.getTimeEnd());
		
		schedule = sRepo.save(schedule);
		return schedule.toString();
	}

	public List<Schedule> getScheduleByDate(Long venueID, int year, int month, int day) {
		List<Schedule> scheduleByDate = sRepo.findScheduleByVenueYearMonthDay(venueID, year, month, day);
		return scheduleByDate;
	}
}
