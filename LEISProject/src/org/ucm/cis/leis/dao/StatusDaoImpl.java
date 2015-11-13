package org.ucm.cis.leis.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.ucm.cis.leis.models.Status;

@Repository("statusDao")
public class StatusDaoImpl implements StatusDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addStatus(Status status) {
		sessionFactory.getCurrentSession().saveOrUpdate(status);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Status> getStatuses() {
		return (List<Status>) sessionFactory.getCurrentSession()
				.createCriteria(Status.class).list();
	}

	@Override
	public Status getStatus(int statusCode) {

		return (Status) sessionFactory.getCurrentSession().get(Status.class,
				statusCode);
	}

	@Override
	public void deleteStatus(int statusCode) {
		sessionFactory
				.getCurrentSession()
				.createQuery(
						"DELETE FROM Status WHERE statusCode = " + statusCode)
				.executeUpdate();

	}

}
