package com.delta.workshop.service;

import java.util.List;

import com.delta.workshop.model.BlueprintDomain;
import com.delta.workshop.model.BlueprintItem;
import com.delta.workshop.model.BlueprintPhase;

public interface BlueprintService {

	List<BlueprintDomain> getBlueprintDomains(Integer workshopId);

	void addBlueprintDomain(BlueprintDomain blueprintDomain);

	void editBlueprintDomain(BlueprintDomain blueprintDomain);

	void deleteBlueprintDomain(Integer domainId);

	void setBlueprintPhase(BlueprintPhase blueprintPhase);

	List<BlueprintPhase> getBlueprintPhase(Integer workshopId);

	void setBlueprintItem(List<BlueprintItem> blueprintItems, Integer workshopId, Integer groupId);

	List<BlueprintItem> getBlueprintItems(Integer workshopId, Integer groupId);

}
