package org.ucm.cis.leis.dao;

import java.util.List;

import org.ucm.cis.leis.models.FundingSource;

public interface FundingSourceDao {

	public void addFundingSource(FundingSource fundingSource);

	public List<FundingSource> getFundingSources();

	public FundingSource getFundingSource(int fundingSourceId);

	public void deleteFundingSource(int fundingSourceId);

}
