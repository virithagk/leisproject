package org.ucm.cis.leis.dao;

import java.util.List;

import org.ucm.cis.leis.models.Model;

public interface ModelDao {

	void addModel(Model model);

	List<Model> getModels();

	Model getModel(String modelCode);

	void deleteModel(String modelCode);

	

}
