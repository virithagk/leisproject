package org.ucm.cis.leis.service;

import java.util.List;

import org.ucm.cis.leis.models.Model;;

public interface ModelService {

public void addModel(Model model);
	
	public List<Model> getModels();
	
	public Model getModel(int modelCode);
	
	public void deleteModel(int modelCode);
}
