package app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

@Entity
public class Reservee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)  // autoincrement
	@Column
	private Long reserveeID;
	
	@Column 
	private Long schoolID;
	
	@Column
	@Pattern(regexp="^(cat|dog)$")
	private String type;
	
	@Column 
	private String firstName;
	
	@Column
	private String lastName;

	public Long getReserveeID() {
		return reserveeID;
	}

	public void setReserveeID(Long reserveeID) {
		this.reserveeID = reserveeID;
	}

	public Long getSchoolId() {
		return schoolID;
	}

	public void setSchoolId(Long schoolID) {
		this.schoolID = schoolID;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Reservee [reserveeID=" + reserveeID + ", schoolID=" + schoolID + ", type=" + type + ", firstName="
				+ firstName + ", lastName=" + lastName + "]";
	}
}
