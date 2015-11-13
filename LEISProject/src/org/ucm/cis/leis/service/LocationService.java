package org.ucm.cis.leis.service;

import java.util.List;

import org.ucm.cis.leis.models.Location;



public interface LocationService {


	public void addLocation(Location location);
	
	public List<Location> getLocations();
	
	public Location getLocation(int roomId);
	
	public void deleteLocation(int roomId);
}
