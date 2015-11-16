package org.ucm.cis.leis.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.ucm.cis.leis.models.Equipment;

@Repository("equipmentDao")
public class EquipmentDoaImpl implements EquipmentDao {


	@Autowired
	private SessionFactory sessionFactory;
	 
	@Override
	public void addEquipment(Equipment equipment) {
		sessionFactory.getCurrentSession().saveOrUpdate(equipment);  
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Equipment> getEquipments() {
		return (List<Equipment>) sessionFactory.getCurrentSession().createCriteria(Equipment.class).list();
	}

	@Override
	public Equipment getEquipment(int equipmentId) {
		return (Equipment) sessionFactory.getCurrentSession().get(Equipment.class, equipmentId);
	}

	@Override
	public void deleteEquipment(int equipmentId) {
		 sessionFactory.getCurrentSession().createQuery("DELETE FROM Equipment WHERE EQUIPMENT_ID = "+equipmentId).executeUpdate();
	}

}
