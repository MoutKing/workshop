package com.delta.workshop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.delta.workshop.model.Proposal;
import com.delta.workshop.model.ProposalDomain;
import com.delta.workshop.model.ProposalInterestperson;
import com.delta.workshop.model.ProposalQualitativeBenefitAnalysis;
import com.delta.workshop.model.ProposalStep;

@Mapper
public interface ProposalMapper {

	List<Proposal> getProposal(@Param("workshopId") Integer workshopId, @Param("groupId") Integer groupId);

	void addProposalDomains(@Param("list") List<ProposalDomain> domains, @Param("proposalId") Integer proposalId);

	void addProposalSteps(@Param("list") List<ProposalStep> steps, @Param("proposalId") Integer proposalId);

	void addQualitativeBenefitAnalysis(
			@Param("list") List<ProposalQualitativeBenefitAnalysis> qualitativeBenefitAnalysis,
			@Param("proposalId") Integer proposalId);

	void addProposalInterestpersons(@Param("list") List<ProposalInterestperson> interestpersons,
			@Param("proposalId") Integer proposalId);

	void updateProposal(Proposal proposal);

	void deleteProposalDomains(Integer proposalId);

	void deleteProposalSteps(Integer proposalId);

	void deleteQualitativeBenefitAnalysis(Integer proposalId);

	void deleteProposalInterestpersons(Integer proposalId);

	void updateProposalSteps(@Param("list") List<ProposalStep> steps);

	void updateQualitativeBenefitAnalysis(
			@Param("list") List<ProposalQualitativeBenefitAnalysis> qualitativeBenefitAnalysis);

	void updateInterestpersons(List<ProposalInterestperson> interestpersons);

	void updateProposalDomains(List<ProposalDomain> domains);

	void addProposal(Proposal proposal);

}
