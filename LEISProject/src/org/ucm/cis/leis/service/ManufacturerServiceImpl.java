package org.ucm.cis.leis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.ucm.cis.leis.dao.ManufacturerDao;
import org.ucm.cis.leis.models.Manufacturer;


@Service("manufacturerService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ManufacturerServiceImpl implements ManufacturerService {
	
	@Autowired
	private ManufacturerDao manufacturerDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
		public void addManufacturer(Manufacturer manufacturer) {
		manufacturerDao.addManufacturer(manufacturer);
	}

	@Override
	public List<Manufacturer> getManufacturers() {
		return manufacturerDao.getManufacturers();
	}

	@Override
	public Manufacturer getManufacturer(int manufacturerId) {
		return manufacturerDao.getManufacturer(manufacturerId);
	}

	@Override
	public void deleteManufacturer(int manufacturerId) {
		manufacturerDao.deleteManufacturer(manufacturerId);
	}

}
