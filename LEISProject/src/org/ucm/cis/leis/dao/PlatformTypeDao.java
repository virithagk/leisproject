package org.ucm.cis.leis.dao;

import java.util.List;

import org.ucm.cis.leis.models.PlatformType;

public interface PlatformTypeDao {

	public void addPlatformType(PlatformType platformType);

	public List<PlatformType> getPlatformTypes();

	public PlatformType getPlatformType(int platformCode);

	public void deletePlatformType(int platformCode);

}
