package org.ucm.cis.leis.dao;

import java.util.List;

import org.ucm.cis.leis.models.EquipmentType;

public interface EquipmentTypeDao {

	public void addEquipmentType(EquipmentType equipmentType);

	public List<EquipmentType> getEquipmentTypes();

	public void deleteEquipmentType(String equipmentTypeId);

	public EquipmentType getEquipmentType(String equipmentTypeId);

}
