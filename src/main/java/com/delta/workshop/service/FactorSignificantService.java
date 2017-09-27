package com.delta.workshop.service;

import java.util.List;
import java.util.Map;

import com.delta.workshop.model.FactorConditions;

/**
 * @author Qiang.Wei
 * @date 创建时间：2017-7-10 上午9:00:38
 * @Description
 */
public interface FactorSignificantService {

	/**
	 * 查询因子显著性的筛选条件
	 * @param conditions 
	 * 
	 * @return
	 */
	Map<String, Object> conditions(FactorConditions conditions);

	/**根据条件分析
	 * @param conditons 
	 * @return
	 */
	List<Map<String, Object>> analyze(FactorConditions conditons) throws Exception;

	/**查询因子关系数据
	 * @param id
	 * @return
	 */
	Map<String, Object> multi(Integer id);

}
