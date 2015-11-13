package org.ucm.cis.leis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.ucm.cis.leis.dao.LocationDao;
import org.ucm.cis.leis.models.Location;


@Service("locationService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class LocationServiceImpl implements LocationService{

	@Autowired
	private LocationDao locationDao;
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addLocation(Location location) {
		locationDao.addLocation(location);
		
	}

	@Override
	public List<Location> getLocations() {
		return locationDao.getLocations();
	}

	@Override
	public Location getLocation(int roomId) {
		return locationDao.getLocation(roomId);
	}

	@Override
	public void deleteLocation(int roomId) {
		locationDao.deleteLocation(roomId);
		
	}

}
