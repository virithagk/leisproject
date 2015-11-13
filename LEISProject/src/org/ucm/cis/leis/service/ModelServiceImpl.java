package org.ucm.cis.leis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.ucm.cis.leis.dao.ModelDao;
import org.ucm.cis.leis.models.Model;

@Service("modelService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ModelServiceImpl implements ModelService{

	@Autowired
	private ModelDao modelDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void addModel(Model model) {
		modelDao.addModel(model);
		
	}

	@Override
	public List<Model> getModels() {
		return modelDao.getModels();
	}

	@Override
	public Model getModel(String modelCode) {
		return modelDao.getModel(modelCode);
	}

	@Override
	public void deleteModel(String modelCode) {
		
		modelDao.deleteModel(modelCode);
	}

}
