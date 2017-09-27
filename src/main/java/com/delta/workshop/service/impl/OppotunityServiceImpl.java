package com.delta.workshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.delta.workshop.mapper.OpportunityTemplateMapper;
import com.delta.workshop.mapper.OppotunityMapper;
import com.delta.workshop.model.Opportunity;
import com.delta.workshop.model.OpportunityTemplate;
import com.delta.workshop.service.OpportunityService;

/**
 * @author Qiang.Wei
 * @date 创建时间：2017-6-30 上午10:08:13
 * @Description
 */
@Service
public class OppotunityServiceImpl implements OpportunityService {
	@Autowired
	private OppotunityMapper mapper;

	@Autowired
	private OpportunityTemplateMapper opportunityTemplateMapper;

	@Override
	public Integer update(Opportunity opprotunity) {
		return mapper.update(opprotunity);
	}

	@Override
	public Integer delete(Integer id) {
		return mapper.delete(id);
	}

	@Override
	public List<Opportunity> list(Integer pid, Integer wid, Integer cid, Integer gid, String customer) {
		if (null != gid && gid == 0) {
			return mapper.list1(pid, wid, cid, gid, customer);
		}
		return mapper.list(pid, wid, cid, gid, customer);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Integer add(boolean isTemplate, List<Opportunity> opprotunity) {
		
		if (isTemplate) {
			for (Opportunity o :opprotunity) {
				OpportunityTemplate ot = new OpportunityTemplate();
				ot.setName(o.getName());
				ot.setCustomer(o.getCustomer());
				ot.setContent(o.getContent());
				ot.setOpportunityClassId(o.getClassId());
				ot.setPainpointId(o.getPainpointId());
				opportunityTemplateMapper.add(ot);
			}
			
		}
		return mapper.add(opprotunity);
	}

}
