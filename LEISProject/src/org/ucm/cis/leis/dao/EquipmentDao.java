package org.ucm.cis.leis.dao;

import java.util.List;

import org.ucm.cis.leis.models.Equipment;


public interface EquipmentDao {

		public void addEquipment(Equipment equipment);

		public List<Equipment> getEquipments();

		public Equipment getEquipment(int equipmentId);

		public void deleteEquipment(int equipmentId);
		
		
		
}
