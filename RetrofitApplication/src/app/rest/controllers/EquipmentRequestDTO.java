package app.rest.controllers;

import javax.persistence.Entity;

@Entity
public class EquipmentRequestDTO {
	
	private Long reservationID;
	private Long tables;
	private Long chairs;
	private Long extensions;
	private Long projectors;
	private Long projectorScreens;
	private Long microphones;
	private Long speakers;
	
	public Long getReservationID() {
		return reservationID;
	}
	public void setReservationID(Long reservationID) {
		this.reservationID = reservationID;
	}
	public Long getTables() {
		return tables;
	}
	public void setTables(Long tables) {
		this.tables = tables;
	}
	public Long getChairs() {
		return chairs;
	}
	public void setChairs(Long chairs) {
		this.chairs = chairs;
	}
	public Long getExtensions() {
		return extensions;
	}
	public void setExtensions(Long extensions) {
		this.extensions = extensions;
	}
	public Long getProjectors() {
		return projectors;
	}
	public void setProjectors(Long projectors) {
		this.projectors = projectors;
	}
	public Long getProjectorScreens() {
		return projectorScreens;
	}
	public void setProjectorScreens(Long projectorScreens) {
		this.projectorScreens = projectorScreens;
	}
	public Long getMicrophones() {
		return microphones;
	}
	public void setMicrophones(Long microphones) {
		this.microphones = microphones;
	}
	public Long getSpeakers() {
		return speakers;
	}
	public void setSpeakers(Long speakers) {
		this.speakers = speakers;
	}
	
	
}
