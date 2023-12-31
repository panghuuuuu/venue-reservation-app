package app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Reservee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long reserveeID;

	@NotNull(message="SchoolID cannot be null.")
	@Column
	private Long schoolID;

	@Column
	@NotNull(message="Type cannot be null.")
	@Pattern(regexp = "^(student|faculty)$")
	private String type;

	@NotNull(message="First Name cannot be null.")
	@Column
	private String firstName;

	@NotNull(message="Last Name cannot be null.")
	@Column
	private String lastName;
	
	@NotNull(message="OBF email cannot be null.")
	@Column
	private String email;

	public Long getReserveeID() {
		return reserveeID;
	}

	public void setReserveeID(Long reserveeID) {
		this.reserveeID = reserveeID;
	}

	public Long getSchoolID() {
		return schoolID;
	}

	public void setSchoolID(Long schoolID) {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Reservee [reserveeID=" + reserveeID + ", schoolID=" + schoolID + ", type=" + type + ", firstName="
				+ firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
}
