package org.ucm.cis.leis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.ucm.cis.leis.dao.FundingSourceDao;
import org.ucm.cis.leis.models.FundingSource;

@Service("fundingSourceService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class FundingSourceServiceImpl implements FundingSourceService{


	@Autowired
	private FundingSourceDao fundingSourceDao;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addFundingSource(FundingSource fundingSource) {
		
		fundingSourceDao.addFundingSource(fundingSource);
	}

	@Override
	public List<FundingSource> getFundingSources() {
		return fundingSourceDao.getFundingSources();
	}

	@Override
	public FundingSource getFundingSource(int fundingSourceId) {
		return fundingSourceDao.getFundingSource(fundingSourceId);
	}

	@Override
	public void deleteFundingSource(int fundingSourceId) {
		
		fundingSourceDao.deleteFundingSource(fundingSourceId);
	}

	
	
}
