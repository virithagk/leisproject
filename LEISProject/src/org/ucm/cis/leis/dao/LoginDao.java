package org.ucm.cis.leis.dao;

import java.util.List;

import org.ucm.cis.leis.models.Login;

public interface LoginDao {

	public void addLogin(Login login);

	public List<Login> getLogins();

	public Login getLogin(String userName);

	public void deleteLogin(String userName);

	//public boolean validateLogin(String userName, String password); 
}
