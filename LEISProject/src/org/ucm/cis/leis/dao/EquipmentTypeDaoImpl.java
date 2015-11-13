package org.ucm.cis.leis.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.ucm.cis.leis.models.EquipmentType;

@Repository("equipmentTypeDao")
public class EquipmentTypeDaoImpl implements EquipmentTypeDao{


	@Autowired
	private SessionFactory sessionFactory;
	 
	@Override
	public void addEquipmentType(EquipmentType equipmentType) {
		 sessionFactory.getCurrentSession().saveOrUpdate(equipmentType);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EquipmentType> getEquipmentTypes() {
		 return (List<EquipmentType>) sessionFactory.getCurrentSession().createCriteria(EquipmentType.class).list();
	}

	@Override
	public void deleteEquipmentType(String equipmentTypeId) {
		
		 sessionFactory.getCurrentSession().createQuery("DELETE FROM EquipmentType WHERE TYPE_CODE = '"+equipmentTypeId+"'").executeUpdate();
	}

	@Override
	public EquipmentType getEquipmentType(String equipmentTypeId) {
		return (EquipmentType) sessionFactory.getCurrentSession().get(EquipmentType.class, equipmentTypeId);
	}

}
