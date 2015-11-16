package org.ucm.cis.leis.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "equipment")
public class Equipment {

	@Id
	@Column(name = "EQUIPMENT_ID")
	private int equipmentId;

	@OneToOne
	@JoinColumn(name = "MF_ID")
	private Manufacturer manufacturer;

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	@OneToOne
	@JoinColumn(name = "TYPE_CODE")
	private EquipmentType equipmentType;

	public EquipmentType getEquipmentType() {
		return equipmentType;
	}

	public void setEquipmentType(EquipmentType equipmentType) {
		this.equipmentType = equipmentType;
	}

	@OneToOne
	@JoinColumn(name = "MD_CODE")
	private Model model;

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	@OneToOne
	@JoinColumn(name = "STATUS_CODE")
	private Status status;
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	@OneToOne
	@JoinColumn(name = "FS_ID")
	private FundingSource fundingSource;

	public FundingSource getFundingSource() {
		return fundingSource;
	}

	public void setFundingSource(FundingSource fundingSource) {
		this.fundingSource = fundingSource;
	}

	@OneToOne
	@JoinColumn(name = "ROOM_ID")
	private Location location;

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@Column(name = "SERIAL_NO")
	private String serialNumber;

	@Column(name = "UCM_INV_NO")
	private String ucmInventoryNo;

	@Column(name = "CIS_INV_NO")
	private String cisInventoryNo;

	@Column(name = "DATE_INSTALLED")
	private Date dateInstalled;

	@Column(name = "DATE_FUNDED")
	private Date dateFunded;

	@Column(name = "DATE_WARRANTY_EXPIRY")
	private Date dateExpired;

	@Column(name = "DATE_REMOVED")
	private Date dateRemoved;

	@Column(name = "DATE_CHECKED_OUT")
	private Date dateCheckedOut;

	@Column(name = "DATE_OF_RETURN")
	private Date dateReturned;

	@Column(name = "CURRENT_OWNER")
	private String currentOwner;

	@Column(name = "PURPOSE")
	private String purpose;

	@Column(name = "ADDN_COMP")
	private String additionalComp;

	@Column(name = "NOTES")
	private String notes;

	public int getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(int equipmentId) {
		this.equipmentId = equipmentId;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getUcmInventoryNo() {
		return ucmInventoryNo;
	}

	public void setUcmInventoryNo(String ucmInventoryNo) {
		this.ucmInventoryNo = ucmInventoryNo;
	}

	public String getCisInventoryNo() {
		return cisInventoryNo;
	}

	public void setCisInventoryNo(String cisInventoryNo) {
		this.cisInventoryNo = cisInventoryNo;
	}

	public Date getDateInstalled() {
		return dateInstalled;
	}

	public void setDateInstalled(Date dateInstalled)  {
		
		//DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		/*DateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
		java.util.Date myDate = formatter.parse(dateInstalled.toString());
		java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());*/
		
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