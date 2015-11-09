package org.ucm.cis.leis.service;

import java.util.List;

import org.ucm.cis.leis.models.Manufacturer;

public interface ManufacturerService {
	
	public void addManufacturer(Manufacturer manufacturer);
	
	public List<Manufacturer> getManufacturers();
	
	public Manufacturer getManufacturer(int manufacturerId);
	
	public void deleteManufacturer(int manufacturerId);

}
