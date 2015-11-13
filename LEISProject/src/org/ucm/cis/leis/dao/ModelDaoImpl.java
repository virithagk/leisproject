package org.ucm.cis.leis.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.ucm.cis.leis.models.Model;

@Repository("modelDao")
public class ModelDaoImpl implements ModelDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addModel(Model model) {
		sessionFactory.getCurrentSession().saveOrUpdate(model);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Model> getModels() {
		return (List<Model>) sessionFactory.getCurrentSession()
				.createCriteria(Model.class).list();
	}

	@Override
	public Model getModel(String modelCode) {
		return (Model) sessionFactory.getCurrentSession().get(Model.class,
				modelCode);
	}

	@Override
	public void deleteModel(String modelCode) {

		sessionFactory
				.getCurrentSession()
				.createQuery("DELETE FROM Model WHERE MD_CODE = '" + modelCode+"'")
				.executeUpdate();
	}

}
