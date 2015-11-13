package org.ucm.cis.leis.service;

import java.util.List;

import org.ucm.cis.leis.models.PlatformType;

public interface PlatformTypeService {

	public void addPlatformType(PlatformType platformType);
	
	public List<PlatformType> getPlatformTypes();
	
	public PlatformType getPlatformType(int platformCode);
	
	public void deletePlatformType(int platformCode);

}
