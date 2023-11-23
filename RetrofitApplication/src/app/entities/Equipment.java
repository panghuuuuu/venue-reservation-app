package app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;

@Entity
public class Equipment {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)  // autoincrement
	@Column
	private Long equipmentID;
	
	@Column
	@Max(100)
	private int tables;
	
	@Column
	@Max(100)
	private int chairs;
	
	@Column
	@Max(5)
	private int extensions;
	
	@Column
	@Max(2)
	private int projectors;
	
	@Column
	@Max(2)
	private int projectorScreens;
	
	@Column
	@Max(10)
	private int microphones;
	
	@Column
	@Max(5)
	private int speakers;

	public Long getEquipmentID() {
		return equipmentID;
	}
	public void setEquipmentID(Long equipmentID) {
		this.equipmentID = equipmentID;
	}
	public int getTables() {
		return tables;
	}
	public void setTables(int tables) {
		this.tables = tables;
	}
	public int getChairs() {
		return chairs;
	}
	public void setChairs(int chairs) {
		this.chairs = chairs;
	}

	public int getExtensions() {
		return extensions;
	}
	public void setExtensions(int extensions) {
		this.extensions = extensions;
	}
	public int getProjectors() {
		return projectors;
	}
	public void setProjectors(int projectors) {
		this.projectors = projectors;
	}
	public int getProjectorScreens() {
		return projectorScreens;
	}
	public void setProjectorScreens(int projectorScreens) {
		this.projectorScreens = projectorScreens;
	}

	public int getMicrophones() {
		return microphones;
	}

	public void setMicrophones(int microphones) {
		this.microphones = microphones;
	}
	public int getSpeakers() {
		return speakers;
	}
	public void setSpeakers(int speakers) {
		this.speakers = speakers;
	}

	@Override
	public String toString() {
		return "Equipment [equipmentID=" + equipmentID + ", tables=" + tables + ", chairs=" + chairs + ", extensions="
				+ extensions + ", projectors=" + projectors + ", projectorScreens=" + projectorScreens
				+ ", microphones=" + microphones + ", speakers=" + speakers + "]";
	}
}
