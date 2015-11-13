package org.ucm.cis.leis.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.ucm.cis.leis.models.Location;

@Repository("locationDao")
public class LocationDaoImpl implements LocationDao{


	@Autowired
	private SessionFactory sessionFactory;
	 
	@Override
	public void addLocation(Location location) {
		
		sessionFactory.getCurrentSession().saveOrUpdate(location);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Location> getLocations() {
		 return (List<Location>) sessionFactory.getCurrentSession().createCriteria(Location.class).list();
	}

	@Override
	public Location getLocation(int roomId) {
		  return (Location) sessionFactory.getCurrentSession().get(Location.class, roomId);
	}

	@Override
	public void deleteLocation(int roomId) {
	
		 sessionFactory.getCurrentSession().createQuery("DELETE FROM Location WHERE Room_Id = "+roomId).executeUpdate();
	}

}
