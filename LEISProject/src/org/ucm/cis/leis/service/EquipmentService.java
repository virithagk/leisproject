package org.ucm.cis.leis.service;


import java.util.List;

import org.ucm.cis.leis.models.Equipment;

public interface EquipmentService {
	
	public void addEquipment(Equipment equipment);
	
	public List<Equipment> getEquipments();
	
	public Equipment getEquipment(int equipmentId);
	
	public void deleteEquipment(int equipmentId);

}