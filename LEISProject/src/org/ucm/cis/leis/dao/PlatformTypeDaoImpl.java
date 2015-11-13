package org.ucm.cis.leis.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.ucm.cis.leis.models.PlatformType;

@Repository("platformTypeDao")
public class PlatformTypeDaoImpl implements PlatformTypeDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addPlatformType(PlatformType platformType) {
		sessionFactory.getCurrentSession().saveOrUpdate(platformType);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PlatformType> getPlatformTypes() {
		return (List<PlatformType>) sessionFactory.getCurrentSession()
				.createCriteria(PlatformType.class).list();
	}

	@Override
	public PlatformType getPlatformType(int platformCode) {
		return (PlatformType) sessionFactory.getCurrentSession().get(
				PlatformType.class, platformCode);
	}

	@Override
	public void deletePlatformType(int platformCode) {
		sessionFactory
				.getCurrentSession()
				.createQuery(
						"DELETE FROM PlatformType WHERE PLATFORM_CODE = "
								+ platformCode).executeUpdate();

	}

}
