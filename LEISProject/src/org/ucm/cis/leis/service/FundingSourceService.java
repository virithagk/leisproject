package org.ucm.cis.leis.service;

import java.util.List;

import org.ucm.cis.leis.models.FundingSource;

public interface FundingSourceService {

public void addFundingSource(FundingSource fundingSource);
	
	public List<FundingSource> getFundingSources();
	
	public FundingSource getFundingSource(int fundingSourceId);
	
	public void deleteFundingSource(int fundingSourceId);
	
	
}
