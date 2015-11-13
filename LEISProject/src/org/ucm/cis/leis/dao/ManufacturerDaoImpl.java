package org.ucm.cis.leis.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.ucm.cis.leis.models.Manufacturer;

@Repository("manufacturerDao")
public class ManufacturerDaoImpl implements ManufacturerDao {

	@Autowired
	private SessionFactory sessionFactory;
	 
	 public void addManufacturer(Manufacturer manufacturer) {
	  sessionFactory.getCurrentSession().saveOrUpdate(manufacturer);  
	 }  
	  
	 
	 @SuppressWarnings("unchecked")
	 public List<Manufacturer> getManufacturers() { 
		 return (List<Manufacturer>) sessionFactory.getCurrentSession().createCriteria(Manufacturer.class).list();  
	 }  
	  
	 
	 public Manufacturer getManufacturer(int manufacturerId) {
	  return (Manufacturer) sessionFactory.getCurrentSession().get(Manufacturer.class, manufacturerId);  
	 }  
	  
	 
	 public void deleteManufacturer(int ManufacturerId) {  
	  sessionFactory.getCurrentSession().createQuery("DELETE FROM Manufacturer WHERE MF_ID = "+ManufacturerId).executeUpdate();  
	 }  

}
