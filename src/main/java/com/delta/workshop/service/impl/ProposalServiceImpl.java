package com.delta.workshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.delta.workshop.mapper.ProposalMapper;
import com.delta.workshop.model.Proposal;
import com.delta.workshop.model.ProposalDomain;
import com.delta.workshop.model.ProposalInterestperson;
import com.delta.workshop.model.ProposalQualitativeBenefitAnalysis;
import com.delta.workshop.model.ProposalStep;
import com.delta.workshop.service.ProposalService;

@Service
public class ProposalServiceImpl implements ProposalService {

	@Autowired
	private ProposalMapper proposalMapper;

	@Override
	public List<Proposal> getProposal(Integer workshopId, Integer groupId) {
		return proposalMapper.getProposal(workshopId, groupId);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void addProposal(Proposal proposal) {
		proposalMapper.addProposal(proposal);
	}

	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void setProposal(Proposal proposal) {

		List<ProposalDomain> domains = proposal.getDomains();
		if (domains != null && domains.size() != 0) {
			proposalMapper.deleteProposalDomains(proposal.getProposalId());
			proposalMapper.addProposalDomains(domains, proposal.getProposalId());
		}

		List<ProposalStep> steps = proposal.getSteps();
		if (steps != null && steps.size() != 0) {
			proposalMapper.deleteProposalSteps(proposal.getProposalId());
			proposalMapper.addProposalSteps(steps, proposal.getProposalId());
		}

		List<ProposalQualitativeBenefitAnalysis> qualitativeBenefitAnalysis = proposal.getQualitativeBenefitAnalysis();
		if (qualitativeBenefitAnalysis != null && qualitativeBenefitAnalysis.size() != 0) {
			proposalMapper.deleteQualitativeBenefitAnalysis(proposal.getProposalId());
			proposalMapper.addQualitativeBenefitAnalysis(qualitativeBenefitAnalysis,proposal.getProposalId());
		}

		List<ProposalInterestperson> interestpersons = proposal.getInterestpersons();
		if (interestpersons != null && interestpersons.size() != 0) {
			proposalMapper.deleteProposalInterestpersons(proposal.getProposalId());
			proposalMapper.addProposalInterestpersons(interestpersons, proposal.getProposalId());
		}
		
		proposalMapper.updateProposal(proposal);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void commitProposal(Proposal proposal) {
		proposalMapper.updateProposalDomains(proposal.getDomains());
		proposalMapper.updateProposalSteps(proposal.getSteps());
		proposalMapper.updateQualitativeBenefitAnalysis(proposal.getQualitativeBenefitAnalysis());
		proposalMapper.updateInterestpersons(proposal.getInterestpersons());
		proposalMapper.updateProposal(proposal);

	}

}
