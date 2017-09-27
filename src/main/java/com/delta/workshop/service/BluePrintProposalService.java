package com.delta.workshop.service;

import java.util.List;

import com.delta.workshop.model.BluePrintProposal;
import com.delta.workshop.model.VoteUser;
import com.delta.workshop.model.VotingBlueprint;

/**
 * @author Qiang.Wei
 * @date 创建时间：2017-9-4 上午9:49:49
 * @Description
 */
public interface BluePrintProposalService {

	List<BluePrintProposal> list(Integer workshopId);

	int edit(java.util.List<BluePrintProposal> list);

	java.util.List<VoteUser> listUsers(Integer groupId);

	Integer doVote(java.util.List<VotingBlueprint> list, Integer workshopId);

	java.util.List<BluePrintProposal> listVote(Integer wid,Integer gid);

	boolean sequence(java.util.List<Integer> list);
	
}
