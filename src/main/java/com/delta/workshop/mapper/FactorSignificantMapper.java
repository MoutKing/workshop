package com.delta.workshop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.delta.workshop.model.AnalysisScore;
import com.delta.workshop.model.FactorConditions;
import com.delta.workshop.model.FactorData;
import com.delta.workshop.model.FactorRelation;

/**
 * @author Qiang.Wei
 * @date 创建时间：2017-7-10 下午2:20:12
 * @Description
 */
@Mapper
public interface FactorSignificantMapper {

	/**
	 * 返回分析方法
	 * @param casesId 
	 * 
	 * @return
	 */
	List<String> getAnalysis(Integer casesId);

	/**
	 * 返回测量站点
	 * 
	 * @param casesId
	 * @return
	 */
	List<String> getMeasureStation(Integer casesId);

	/**
	 * 返回开切特性值
	 * 
	 * @param casesId
	 * @param measureStation
	 * @return
	 */
	List<String> getFeature(@Param("casesId") Integer casesId, @Param("measureStation") String measureStation);

	/**
	 * 返回主制成站点
	 * 
	 * @param casesId
	 * @param measureStation
	 * @return
	 */
	List<String> getMajorStation(@Param("casesId") Integer casesId, @Param("measureStation") String measureStation);

	/**
	 * 返回机台
	 * 
	 * @param casesId
	 * @param measureStation
	 * @param majorStation
	 * @return
	 */
	List<String> getMachine(@Param("casesId") Integer casesId, @Param("measureStation") String measureStation,
			@Param("majorStation") String majorStation);

	/**
	 * 返回分析阶层
	 * @param casesId 
	 * 
	 * @return
	 */
	List<String> getAnalysisLevel(Integer casesId);

	/**
	 * 返回机台参数
	 * 
	 * @param casesId
	 * @param measureStation
	 * @param majorStation
	 * @param machine
	 * @return
	 */
	List<String> getMachineParameter(@Param("casesId") Integer casesId, @Param("measureStation") String measureStation,
			@Param("majorStation") String majorStation, @Param("machine") String machine);

	/**
	 * 获取案例
	 * 
	 * @return
	 */
	List<String> getCases();

	/**
	 * 根据条件查询唯一的数据表示
	 * 
	 * @param conditons
	 * @return
	 */
	List<AnalysisScore> getSeclectId(FactorConditions conditons);

	/**
	 * 根据唯一标识查询数据
	 * @param id
	 * @return
	 */
	List<FactorData> getFactorData(Integer id);

	/**
	 * 查询多变量分析时的数据
	 * @param id
	 * @return
	 */
	List<FactorRelation> getMultiData(Integer id);

	List<FactorData> getMultiRelationData(Integer id);

}
