package app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Office {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)  // autoincrement
	@Column
	private Long officeID;
	
	@Column
	@NotNull(message="Office Name name must be valid.")
	private String officeName;

	public Long getOfficeID() {
		return officeID;
	}

	public void setOfficeID(Long officeID) {
		this.officeID = officeID;
	}

	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	@Override
	public String toString() {
		return "Office [officeID=" + officeID + ", officeName=" + officeName + "]";
	}
	
	
	
}
