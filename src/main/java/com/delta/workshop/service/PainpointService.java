package com.delta.workshop.service;

import java.util.List;

import com.delta.workshop.model.Painpoint;

public interface PainpointService {

	int add(Painpoint painpoint);

	void edit(Painpoint painpoint);

	void delete(Integer id);

	List<Painpoint> getAll(Integer workshopId, Integer groupId);

	List<Painpoint> getPainpointDisplayInfo(Integer workshopId);

	void deleteDisplay(Integer id);

	void editDisplay(Painpoint painpoint);

	int addDisplay(Painpoint painpoint);

	void addRelation(List<Painpoint> painpoints);

	

}
