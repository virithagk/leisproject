package org.ucm.cis.leis.service;

import java.util.List;

import org.ucm.cis.leis.models.Status;



public interface StatusService {

	public void addStatus(Status status);
	
	public List<Status> getStatuses();
	
	public Status getStatus(int statusCode);
	
	public void deleteStatus(int statusCode);

}
