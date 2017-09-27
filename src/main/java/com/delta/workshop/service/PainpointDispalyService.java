package com.delta.workshop.service;

import java.util.List;

import com.delta.workshop.model.PainpointTemplate;

public interface PainpointDispalyService {

	List<PainpointTemplate> getPainpointDispalyByCondition(Integer workshopId);

}
