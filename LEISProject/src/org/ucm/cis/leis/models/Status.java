package org.ucm.cis.leis.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="status")
public class Status {

	@Id
	@Column(name="STATUS_CODE")
	private int statusCode;
	
	@Column(name="STATUS_NAME")
	private String statusName;

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	
	

	
}