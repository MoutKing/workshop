package com.delta.workshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.delta.workshop.mapper.BlueprintMapper;
import com.delta.workshop.model.BlueprintDomain;
import com.delta.workshop.model.BlueprintItem;
import com.delta.workshop.model.BlueprintPhase;
import com.delta.workshop.service.BlueprintService;

@Service
public class BlueprintServiceImpl implements BlueprintService {

	@Autowired
	private BlueprintMapper blueprintMapper;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public List<BlueprintDomain> getBlueprintDomains(Integer workshopId) {
		blueprintMapper.addBlueprintDomainsFromProposal(workshopId);
		return blueprintMapper.getBlueprintDomains(workshopId);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void addBlueprintDomain(BlueprintDomain blueprintDomain) {
		blueprintMapper.addBlueprintDomain(blueprintDomain);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void editBlueprintDomain(BlueprintDomain blueprintDomain) {
		blueprintMapper.editBlueprintDomain(blueprintDomain);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void deleteBlueprintDomain(Integer domainId) {
		blueprintMapper.deleteBlueprintDomain(domainId);

	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public List<BlueprintPhase> getBlueprintPhase(Integer workshopId) {
		BlueprintPhase blueprintPhase = new BlueprintPhase();
		blueprintPhase.setWorkshopId(workshopId);
		return blueprintMapper.getBlueprintPhase(blueprintPhase);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void setBlueprintPhase(BlueprintPhase blueprintPhase) {
		Integer phaseId = blueprintPhase.getPhaseId();
		if (phaseId != null) {
			List<BlueprintPhase> blueprintPhases = blueprintMapper.getBlueprintPhase(blueprintPhase);
			if (blueprintPhases != null && blueprintPhases.size() != 0) {
				blueprintMapper.editBlueprintPhase(blueprintPhase);
			} else {
				blueprintMapper.addBlueprintPhase(blueprintPhase);
			}
		}

	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void setBlueprintItem(List<BlueprintItem> blueprintItems, Integer workshopId, Integer groupId) {
//		blueprintMapper.deleteBlueprintItemByWorkshopId(workshopId, groupId);
		for (BlueprintItem blueprintItemParam : blueprintItems) {
			BlueprintItem blueprintItem = blueprintMapper.getBlueprintItem(blueprintItemParam.getItemId(),workshopId,groupId);
			if(blueprintItem == null){
				blueprintMapper.addBlueprintItem(blueprintItemParam);
			}else{
				blueprintMapper.editBlueprintItem(blueprintItemParam);
			}
		}
		
		

	}

	@Override
	public List<BlueprintItem> getBlueprintItems(Integer workshopId, Integer groupId) {

		return blueprintMapper.getBlueprintItems(workshopId, groupId);
	}
}
