package org.ucm.cis.leis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.ucm.cis.leis.dao.PlatformTypeDao;

import org.ucm.cis.leis.models.PlatformType;

@Service("platformTypeService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)

public class PlatformTypeServiceImpl implements PlatformTypeService{

	
	@Autowired
	private PlatformTypeDao platformTypeDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void addPlatformType(PlatformType platformType) {
		platformTypeDao.addPlatformType(platformType);
		
	}

	@Override
	public List<PlatformType> getPlatformTypes() {
		return platformTypeDao.getPlatformTypes();
	}

	@Override
	public PlatformType getPlatformType(String platformCode) {
		return platformTypeDao.getPlatformType(platformCode);
	}

	@Override
	public void deletePlatformType(String platformCode) {
		platformTypeDao.deletePlatformType(platformCode);
	}

	

	
}
