package org.ucm.cis.leis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.ucm.cis.leis.dao.LoginDao;
import org.ucm.cis.leis.models.Login;


@Service("loginService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class LoginServiceImpl implements LoginService{

	@Autowired
	private LoginDao loginDao;
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addLogin(Login login) {
		loginDao.addLogin(login);
		
	}

	@Override
	public List<Login> getLogins() {
		return loginDao.getLogins();
	}

	@Override
	public Login getLogin(String userName) {
		return loginDao.getLogin(userName);
	}

	@Override
	public void deleteLogin(String userName) {
		loginDao.deleteLogin(userName);
		
	}

}
