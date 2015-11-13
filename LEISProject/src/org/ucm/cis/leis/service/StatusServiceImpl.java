package org.ucm.cis.leis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.ucm.cis.leis.dao.StatusDao;
import org.ucm.cis.leis.models.Status;

@Service("statusService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class StatusServiceImpl implements StatusService{

	@Autowired
	private StatusDao statusDao;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addStatus(Status status) {
		
		statusDao.addStatus(status);
	}

	@Override
	public List<Status> getStatuses() {
		return statusDao.getStatuses();
	}

	@Override
	public Status getStatus(String statusCode) {
		return statusDao.getStatus(statusCode);
	}

	@Override
	public void deleteStatus(String statusCode) {
		statusDao.deleteStatus(statusCode);
	}

}
