package com.delta.workshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delta.workshop.mapper.VotingMapper;
import com.delta.workshop.model.VoteUser;
import com.delta.workshop.model.Voting;
import com.delta.workshop.model.VotingImproveway;
import com.delta.workshop.model.VotingOpportunity;
import com.delta.workshop.model.VotingPainPoint;
import com.delta.workshop.service.VotingService;

/**
 * @author Qiang.Wei
 * @date 创建时间：2017-6-20 上午10:10:19
 * @Description
 */
@Service
public class VotingServiceImple implements VotingService {
	@Autowired
	private VotingMapper mapper;

	@Override
	public List<VoteUser> user(Integer wid, Integer gid, Integer uid) {
		if (uid == 1) {
			return mapper.user1(wid, gid);
		} else if (uid == 2) {
			return mapper.user2(wid, gid);
		} else
			return mapper.user3(wid, gid);
	}

	@Override
	public Integer doVoting(List<Voting> list, Integer uid) {
		if (uid == 1) {
			return mapper.doVoting1(list);
		} else if (uid == 2) {
			return mapper.doVoting2(list);
		} else
			return mapper.doVoting3(list);
	}

	@Override
	public List<VotingPainPoint> listPainpoint(Integer wid, Integer gid) {
		return mapper.listPainpoint(wid, gid);
	}

	@Override
	public List<VotingImproveway> listImprove(Integer wid, Integer gid) {
		return mapper.listImprove(wid, gid);
	}

	@Override
	public List<VotingOpportunity> listOpportunity(Integer wid, Integer gid) {
		return mapper.listOpportunity(wid, gid);
	}

}
