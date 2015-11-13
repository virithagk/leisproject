package org.ucm.cis.leis.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.ucm.cis.leis.models.FundingSource;

@Repository("fundingSourceDao")
public class FundingSourceDaoImpl implements FundingSourceDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addFundingSource(FundingSource fundingSource) {
		sessionFactory.getCurrentSession().saveOrUpdate(fundingSource);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FundingSource> getFundingSources() {
		 return (List<FundingSource>) sessionFactory.getCurrentSession().createCriteria(FundingSource.class).list();
	}

	@Override
	public FundingSource getFundingSource(int fundingSourceId) {
		 return (FundingSource) sessionFactory.getCurrentSession().get(FundingSource.class, fundingSourceId);
	}

	@Override
	public void deleteFundingSource(int fundingSourceId) {
		 sessionFactory.getCurrentSession().createQuery("DELETE FROM FundingSource WHERE FS_ID = "+fundingSourceId).executeUpdate();
		
	}

}
