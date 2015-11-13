package org.ucm.cis.leis.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "funding_source")
public class FundingSource {

	@Id
	@GeneratedValue
	@Column(name = "FS_ID")
	private int fundingSourceId;
	
	@Column(name = "FS_AGENCY_NAME")
	private String agencyName;

	@Column(name = "FS_PROGRAM")
	private String program;

	public String getAgencyName() {
		return agencyName;
	}

	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}

	public int getFundingSourceId() {
		return fundingSourceId;
	}

	public void setFundingSourceId(int fundingSourceId) {
		this.fundingSourceId = fundingSourceId;
	}

	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		this.program = program;
	}

}