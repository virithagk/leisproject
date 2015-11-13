package org.ucm.cis.leis.dao;

import java.util.List;

import org.ucm.cis.leis.models.Location;

public interface LocationDao {

	public void addLocation(Location location);

	public List<Location> getLocations();

	public Location getLocation(int roomId);

	public void deleteLocation(int roomId);

}
