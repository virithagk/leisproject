package org.ucm.cis.leis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.ucm.cis.leis.dao.EquipmentTypeDao;
import org.ucm.cis.leis.models.EquipmentType;

@Service("equipmentTypeService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class EquipmentTypeServiceImpl implements EquipmentTypeService{

	@Autowired
	private EquipmentTypeDao equipmentTypeDao;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addEquipmentType(EquipmentType equipmentType) {
		equipmentTypeDao.addEquipmentType(equipmentType);
	}

	@Override
	public List<EquipmentType> getEquipmentTypes() {
		return equipmentTypeDao.getEquipmentTypes();
	}

	@Override
	public EquipmentType getEquipmentType(String equipmentTypeId) {
		return equipmentTypeDao.getEquipmentType(equipmentTypeId);
	}

	@Override
	public void deleteEquipmentType(String equipmentTypeId) {
		
		equipmentTypeDao.deleteEquipmentType(equipmentTypeId);
	}

}
