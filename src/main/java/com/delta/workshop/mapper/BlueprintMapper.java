package com.delta.workshop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.delta.workshop.model.BlueprintDomain;
import com.delta.workshop.model.BlueprintItem;
import com.delta.workshop.model.BlueprintPhase;

@Mapper
public interface BlueprintMapper {
	
	void addBlueprintDomainsFromProposal(Integer workshopId);

	List<BlueprintDomain> getBlueprintDomains(Integer workshopId);

	void addBlueprintDomain(BlueprintDomain blueprintDomain);

	void editBlueprintDomain(BlueprintDomain blueprintDomain);

	void deleteBlueprintDomain(Integer domainId);

	void addBlueprintPhase(BlueprintPhase blueprintPhase);

	void editBlueprintPhase(BlueprintPhase blueprintPhase);

	List<BlueprintPhase> getBlueprintPhase(BlueprintPhase blueprintPhase);

	void addBlueprintItem(List<BlueprintItem> blueprintItems);

	void deleteBlueprintItemByWorkshopId(@Param("workshopId")Integer workshopId,@Param("groupId") Integer groupId);

	List<BlueprintItem> getBlueprintItems(@Param("workshopId")Integer workshopId,@Param("groupId") Integer groupId);

	BlueprintItem getBlueprintItem(@Param("itemId")Integer itemId, @Param("workshopId")Integer workshopId, @Param("groupId")Integer groupId);

	void addBlueprintItem(BlueprintItem blueprintItemParam);

	void editBlueprintItem(BlueprintItem blueprintItemParam);

}
