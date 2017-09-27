package com.delta.workshop.service;

import java.util.List;

import com.delta.workshop.model.Proposal;

public interface ProposalService {

	List<Proposal> getProposal(Integer workshopId, Integer groupId);

	void setProposal(Proposal proposal);

	void commitProposal(Proposal proposal);

	void addProposal(Proposal proposal);

}
