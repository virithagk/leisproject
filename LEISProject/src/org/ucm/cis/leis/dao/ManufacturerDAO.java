package org.ucm.cis.leis.dao;

import java.util.List;

import org.ucm.cis.leis.models.Manufacturer;

public interface ManufacturerDao {
	
	public void addManufacturer(Manufacturer manufacturer);
	
	public List<Manufacturer> getManufacturers();
	
	public Manufacturer getManufacturer(int manufacturerId);
	
	public void deleteManufacturer(int manufacturerId);
}
