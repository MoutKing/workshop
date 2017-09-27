package com.delta.workshop.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.delta.workshop.mapper.BluePrintProposalMapper;
import com.delta.workshop.model.BluePrintProposal;
import com.delta.workshop.model.VoteUser;
import com.delta.workshop.model.VotingBlueprint;
import com.delta.workshop.service.BluePrintProposalService;

/**
 * @author Qiang.Wei
 * @date 创建时间：2017-9-4 上午9:50:47
 * @Description
 */
@Service
public class BluePrintProposalServiceImpl implements BluePrintProposalService {

	@Autowired
	BluePrintProposalMapper mapper;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public List<BluePrintProposal> list(Integer workshopId) {
		// 首先判断是否写入数据库
		List<BluePrintProposal> list = mapper.list(workshopId);
		if (list.size() > 1) {
			return list;
		} else {
			List<String> names = mapper.getOpportunity(workshopId);
			for (String name : names) {
				if (name.replace(" ", "").length() > 0) {
					BluePrintProposal bpp = new BluePrintProposal();
					bpp.setProposalName(name);
					bpp.setWorkshopId(workshopId);
					list.add(bpp);
				}
			}
			if (list.size() > 0) {
				int count = mapper.insertBlueprintProposal(list);
				if (count == list.size()) {
					list.clear();
					list = mapper.list(workshopId);
				}
			}
			return list;
		}

	}

	@Override
	public int edit(List<BluePrintProposal> list) {
		int count = mapper.edit(list);
		return count;
	}

	@Override
	public List<VoteUser> listUsers(Integer groupId) {
		return mapper.users(groupId);

	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Integer doVote(List<VotingBlueprint> list, Integer workshopId) {
		mapper.clearOrder(workshopId);
		return mapper.doVote(list);
	}

	@Override
	public List<BluePrintProposal> listVote(Integer wid, Integer gid) {
		List<BluePrintProposal> list = new ArrayList<BluePrintProposal>();
		// 判断是否已有排序
		Integer count = mapper.getOrder(wid);

		// 有的话就冲排序表中查询
		// 没有的话就按照默认规则计算排序
		if (count > 0) {
			list = mapper.listOrder(wid, gid);
		} else {
			list = mapper.listVote(wid, gid);
		}
		return list;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean sequence(List<Integer> list) {
		int count = 0;
		boolean success = false;
		List<Map<String, Integer>> sequence = new ArrayList<Map<String, Integer>>();
		for (int i = 0; i < list.size(); i++) {
			Map<String, Integer> map = new HashMap<String, Integer>();
			map.put("id", list.get(i));
			map.put("sequence", i + 1);
			sequence.add(map);
		}

		count = mapper.sequence(sequence);
		if (count > 0) {
			success = true;
		}
		return success;
	}

}
