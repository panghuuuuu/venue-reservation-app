package app.entities;

import javax.persistence.Entity;

public class EquipmentRequest {
	
	private Long reservationID;
	private int tables;
	private int chairs;
	private int extensions;
	private int projectors;
	private int projectorScreens;
	private int microphones;
	private int speakers;
	
	public Long getReservationID() {
		return reservationID;
	}
	public void setReservationID(Long reservationID) {
		this.reservationID = reservationID;
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
		return "EquipmentRequest [reservationID=" + reservationID + ", tables=" + tables + ", chairs=" + chairs
				+ ", extensions=" + extensions + ", projectors=" + projectors + ", projectorScreens=" + projectorScreens
				+ ", microphones=" + microphones + ", speakers=" + speakers + "]";
	}
}