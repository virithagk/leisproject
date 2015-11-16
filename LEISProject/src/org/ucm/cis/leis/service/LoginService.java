package org.ucm.cis.leis.service;

import java.util.List;

import org.ucm.cis.leis.models.Login;



public interface LoginService {


	public void addLogin(Login login);
	
	public List<Login> getLogins();
	
	public Login getLogin(String userName);
	
	public void deleteLogin(String userName);
}
