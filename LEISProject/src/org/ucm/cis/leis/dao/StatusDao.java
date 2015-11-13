package org.ucm.cis.leis.dao;

import java.util.List;

import org.ucm.cis.leis.models.Status;

public interface StatusDao {

	public void addStatus(Status status);

	public List<Status> getStatuses();

	public Status getStatus(int statusCode);

	public void deleteStatus(int statusCode);
}
