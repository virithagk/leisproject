package org.ucm.cis.leis.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "platform_type")
public class PlatformType {

	@Id
	@Column(name = "PLATFORM_CODE")
	private int platformCode;

	@Column(name = "PLATFORM_NAME")
	private String platformName;

	public int getPlatformCode() {
		return platformCode;
	}

	public void setPlatformCode(int platformCode) {
		this.platformCode = platformCode;
	}

	public String getPlatformName() {
		return platformName;
	}

	public void setPlatformName(String platformName) {
		this.platformName = platformName;
	}

}