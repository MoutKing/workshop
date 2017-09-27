package com.delta.workshop.service;

import java.util.List;

import com.delta.workshop.model.Improveway;

public interface ImprovewayService {


	List<Improveway> getbyGroup(Integer workshopId, Integer groupId);

	int add(Improveway improveway);

	void edit(Improveway improveway);

	void delete(Integer id);

	List<Improveway> getImprovewaytDisplayInfo(Integer workshopId);

	void addRelation(List<Improveway> improveways);
}
