package org.ucm.cis.leis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.ucm.cis.leis.dao.EquipmentDao;
import org.ucm.cis.leis.models.Equipment;



@Service("equipmentService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class EquipmentServiceImpl implements EquipmentService {
	
	@Autowired
	private EquipmentDao equipmentDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addEquipment(Equipment equipment) {
		equipmentDao.addEquipment(equipment);
	}

	@Override
	public List<Equipment> getEquipments() {
		return equipmentDao.getEquipments();
	}

	@Override
	public Equipment getEquipment(int equipmentId) {
		return equipmentDao.getEquipment(equipmentId);
	}

	@Override
	public void deleteEquipment(int equipmentId) {
		equipmentDao.deleteEquipment(equipmentId);
	}

}


