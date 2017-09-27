package com.delta.workshop.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delta.workshop.mapper.WorkshopSessionMapper;
import com.delta.workshop.model.WorkshopSession;
import com.delta.workshop.service.WorkshopSessionService;

@Service
public class WorkshopSessionServiceImpl implements WorkshopSessionService {

	@Autowired
	private WorkshopSessionMapper workshopSessionMapper;

	@Override
	public List<WorkshopSession> getByWorkshop(Integer workshopId) {
		List<WorkshopSession> workshopSessions = workshopSessionMapper.getByWorkshop(workshopId);
		return workshopSessions;
	}

	@Override
	public void edit(Integer workshopId, List<WorkshopSession> workshopSessions) {
		workshopSessionMapper.cleanSession(workshopId);
		workshopSessionMapper.cleanTemp(workshopId);
		List<WorkshopSession> toWorkshopSessionTemp = new ArrayList<WorkshopSession>();
		List<WorkshopSession> toWorkshopSession = new ArrayList<WorkshopSession>();
		for (WorkshopSession workshopSession : workshopSessions) {
			workshopSession.setWorkshopId(workshopId);
			if(workshopSession.getSessionId() == null){
				toWorkshopSessionTemp.add(workshopSession);
			}else{
				toWorkshopSession.add(workshopSession);
			}
		}
		workshopSessionMapper.addWorkshopSessionTemp(toWorkshopSessionTemp);
		workshopSessionMapper.addWorkshopSession(toWorkshopSession);
	}

	@Override
	public void editSub(Integer workshopId, List<WorkshopSession> workshopSessions) {
		workshopSessionMapper.cleanSubSession(workshopId);
		workshopSessionMapper.addWorkshopSubSession(workshopSessions);
	}
}
