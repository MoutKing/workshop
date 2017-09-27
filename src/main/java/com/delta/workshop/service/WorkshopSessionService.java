package com.delta.workshop.service;

import java.util.List;

import com.delta.workshop.model.WorkshopSession;

public interface WorkshopSessionService {

	List<WorkshopSession> getByWorkshop(Integer workshopId);

	void edit(Integer workshopId, List<WorkshopSession> workshopSessions);

	void editSub(Integer workshopId, List<WorkshopSession> workshopSessions);

}
