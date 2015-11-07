package org.ucm.cis.leis.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="equipment")
public class Equipment {

	@Id
	@Column(name="EQUIPMENT_ID")
	private int equipmentId;
	
	@Column(name="MF_ID")
	private int manufacturerId;
	
	@Column(name="TYPE_CODE")
	private int typeCode;
	
	@Column(name="MD_CODE")
	private int modelCode;
	
	@Column(name="SERIAL_NO")
	private int serialNumber;
	
	@Column(name="UCM_INV_NO")
	private int ucmInventoryNo;
	
	@Column(name="CIS_INV_NO")
	private int cisInventoryNo;
	
	@Column(name="FS_ID")
	private int fundingId;
	
	@Column(name="STATUS_CODE")
	private int statusCode;
	
	@Column(name="ROOM_ID")
	private int roomId;
	
	@Column(name="DATE_INSTALLED")
	private Date dateInstalled;
	
	@Column(name="DATE_FUNDED")
	private Date dateFunded;
	
	@Column(name="DATE_WARRANTY_EXPIRY")
	private Date dateExpired;
	
	@Column(name="DATE_REMOVED")
	private Date dateRemoved;
	
	@Column(name="DATE_CHECKED_OUT")
	private Date dateCheckedOut;
	
	@Column(name="DATE_OF_RETURN")
	private Date dateReturned;
	
	@Column(name="CURRENT_OWNER")
	private String currentOwner;
	
	@Column(name="PURPOSE")
	private String purpose;
	
	@Column(name="ADDN_COMP")
	private String additionalComp;
	
	@Column(name="NOTES")
	private String notes;

	public int getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(int equipmentId) {
		this.equipmentId = equipmentId;
	}

	public int getManufacturerId() {
		return manufacturerId;
	}

	public void setManufacturerId(int manufacturerId) {
		this.manufacturerId = manufacturerId;
	}

	public int getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(int typeCode) {
		this.typeCode = typeCode;
	}

	public int getModelCode() {
		return modelCode;
	}

	public void setModelCode(int modelCode) {
		this.modelCode = modelCode;
	}

	public int getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}

	public int getUcmInventoryNo() {
		return ucmInventoryNo;
	}

	public void setUcmInventoryNo(int ucmInventoryNo) {
		this.ucmInventoryNo = ucmInventoryNo;
	}

	public int getCisInventoryNo() {
		return cisInventoryNo;
	}

	public void setCisInventoryNo(int cisInventoryNo) {
		this.cisInventoryNo = cisInventoryNo;
	}

	public int getFundingId() {
		return fundingId;
	}

	public void setFundingId(int fundingId) {
		this.fundingId = fundingId;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public Date getDateInstalled() {
		return dateInstalled;
	}

	public void setDateInstalled(Date dateInstalled) {
		this.dateInstalled = dateInstalled;
	}

	public Date getDateFunded() {
		return dateFunded;
	}

	public void setDateFunded(Date dateFunded) {
		this.dateFunded = dateFunded;
	}

	public Date getDateExpired() {
		return dateExpired;
	}

	public void setDateExpired(Date dateExpired) {
		this.dateExpired = dateExpired;
	}

	public Date getDateRemoved() {
		return dateRemoved;
	}

	public void setDateRemoved(Date dateRemoved) {
		this.dateRemoved = dateRemoved;
	}

	public Date getDateCheckedOut() {
		return dateCheckedOut;
	}

	public void setDateCheckedOut(Date dateCheckedOut) {
		this.dateCheckedOut = dateCheckedOut;
	}

	public Date getDateReturned() {
		return dateReturned;
	}

	public void setDateReturned(Date dateReturned) {
		this.dateReturned = dateReturned;
	}

	public String getCurrentOwner() {
		return currentOwner;
	}

	public void setCurrentOwner(String currentOwner) {
		this.currentOwner = currentOwner;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getAdditionalComp() {
		return additionalComp;
	}

	public void setAdditionalComp(String additionalComp) {
		this.additionalComp = additionalComp;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	

	
	
}