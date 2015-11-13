package org.ucm.cis.leis.service;

import java.util.List;

import org.ucm.cis.leis.models.EquipmentType;

public interface EquipmentTypeService {

public void addEquipmentType(EquipmentType equipmentType);
	
	public List<EquipmentType> getEquipmentTypes();
	
	public EquipmentType getEquipmentType(String equipmentTypeId);
	
	public void deleteEquipmentType(String equipmentTypeId);

}
