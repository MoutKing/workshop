package com.delta.workshop.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delta.workshop.mapper.FactorSignificantMapper;
import com.delta.workshop.model.AnalysisScore;
import com.delta.workshop.model.FactorConditions;
import com.delta.workshop.service.FactorSignificantService;
import com.mysql.jdbc.StringUtils;

/**
 * @author Qiang.Wei
 * @date 创建时间：2017-7-10 上午9:02:06
 * @Description
 */
@Service
public class FactorSignificantServiceImpl implements FactorSignificantService {

	@Autowired
	private FactorSignificantMapper mapper;

	@Override
	public Map<String, Object> conditions(FactorConditions conditions) {
		Map<String, Object> map = new HashMap<String, Object>();

		if (null == conditions.getCasesId()) {
			map.put("cases", mapper.getCases());
		} else if (null != conditions.getCasesId()) {
			if (StringUtils.isNullOrEmpty(conditions.getMeasureStation())) {
				map.put("measureStation", mapper.getMeasureStation(conditions.getCasesId()));
				map.put("analysis", mapper.getAnalysis(conditions.getCasesId()));
				map.put("analysisLevel", mapper.getAnalysisLevel(conditions.getCasesId()));
			} else if (!StringUtils.isNullOrEmpty(conditions.getMeasureStation())) {
				if (StringUtils.isNullOrEmpty(conditions.getMajorStation())) {
					map.put("feature", mapper.getFeature(conditions.getCasesId(), conditions.getMeasureStation()));
					map.put("majorStation",
							mapper.getMajorStation(conditions.getCasesId(), conditions.getMeasureStation()));
				} else if (!StringUtils.isNullOrEmpty(conditions.getMajorStation())) {
					if (StringUtils.isNullOrEmpty(conditions.getMachine())) {
						map.put("machine",
								mapper.getMachine(conditions.getCasesId(), conditions.getMeasureStation(),
										conditions.getMajorStation()));
					} else if (!StringUtils.isNullOrEmpty(conditions.getMachine())) {
						map.put("machineParameter", mapper.getMachineParameter(conditions.getCasesId(),
								conditions.getMeasureStation(), conditions.getMajorStation(), conditions.getMachine()));
					}
				}

			}
		}

		return map;
	}

	@Override
	public List<Map<String, Object>> analyze(FactorConditions conditons) throws Exception {
		List<Map<String, Object>>  map = new ArrayList<Map<String, Object>>();
		List<AnalysisScore> list = mapper.getSeclectId(conditons);
		
		for (AnalysisScore a :list) {
			Map<String, Object> map1 = new HashMap<String, Object>();
			map1.put("machine", a.getMachine());
			map1.put("score", a.getScore());
			map1.put("factorData", mapper.getFactorData(a.getId()));
			map1.put("relation", mapper.getMultiData(a.getId()));
			map.add(map1);
		}
		
		return map;
	}

	@Override
	public Map<String, Object> multi(Integer id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("factorData", mapper.getMultiRelationData(id));
		return map;
	}

}
