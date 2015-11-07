package org.ucm.cis.leis.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="funding_source")
public class FundingSource {

	@Id
	@Column(name="FS_AGENCY_NAME")
	private string agencyName;
	
	@Column(name="FS_PROGRAM")
	private String program;
	
	public string getAgencyName() {
		return agencyName;
	}

	public void setAgencyName(string agencyName) {
		this.agencyName = agencyName;
	}

	
	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		this.program = program;
	}

	
}