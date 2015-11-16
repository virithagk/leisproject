package org.ucm.cis.leis.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.ucm.cis.leis.models.Login;

@Repository("loginDao")
public class LoginDaoImpl implements LoginDao{


	@Autowired
	private SessionFactory sessionFactory;
	 
	@Override
	public void addLogin(Login login) {
		
		sessionFactory.getCurrentSession().saveOrUpdate(login);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Login> getLogins() {
		 return (List<Login>) sessionFactory.getCurrentSession().createCriteria(Login.class).list();
	}

	@Override
	public Login getLogin(String userName) {
		  return (Login) sessionFactory.getCurrentSession().get(Login.class, userName);
	}

	@Override
	public void deleteLogin(String userName) {
	
		 sessionFactory.getCurrentSession().createQuery("DELETE FROM Login WHERE USERNAME = '"+userName+"'").executeUpdate();
	}

	/*@Override
	public boolean validateLogin(String userName, String password) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Login WHERE USERNAME = '"+userName+"'").;
		return false;
	}
*/
}
