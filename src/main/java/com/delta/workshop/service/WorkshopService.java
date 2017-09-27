package com.delta.workshop.service;

import java.util.List;

import com.delta.workshop.model.Workshop;

public interface WorkshopService {

	void add(Workshop workshop);

	void edit(Workshop workshop);

	void delete(Integer id);

	List<Workshop> getAll();

}
