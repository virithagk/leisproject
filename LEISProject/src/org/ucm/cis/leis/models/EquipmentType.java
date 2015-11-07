package org.ucm.cis.leis.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="equipment_type")
public class EquipmentType {

	@Id
	@Column(name="TYPE_CODE")
	private int typeCode;
	
	@Column(name="TYPE_NAME")
	private String typeName;
	
	public int getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(int typeCode) {
		this.typeCode = typeCode;
	}

	
	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	
}