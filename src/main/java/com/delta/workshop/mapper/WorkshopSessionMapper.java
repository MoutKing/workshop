package com.delta.workshop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.delta.workshop.model.WorkshopSession;

@Mapper
public interface WorkshopSessionMapper {

	List<WorkshopSession> getByWorkshop(Integer workshopId);

	void cleanSession(Integer workshopId);

	void cleanTemp(Integer workshopId);

	void addWorkshopSessionTemp(List<WorkshopSession> toWorkshopSessionTemp);

	void addWorkshopSession(List<WorkshopSession> toWorkshopSession);

	void cleanSubSession(Integer workshopId);

	void addWorkshopSubSession(List<WorkshopSession> workshopSessions);

}
