package org.ucm.cis.leis.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "model")
public class Model {

	@Id
	@Column(name = "MD_CODE")
	private int modelCode;

	@Column(name = "MD_NAME")
	private String modelName;

	public int getModelCode() {
		return modelCode;
	}

	public void setModelCode(int modelCode) {
		this.modelCode = modelCode;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

}