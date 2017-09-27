package com.delta.workshop.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.delta.workshop.model.BluePrintProposal;
import com.delta.workshop.model.VoteUser;
import com.delta.workshop.model.VotingBlueprint;

/**
 * @author Qiang.Wei
 * @Description
 * @date 创建时间：2017-9-4 上午9:56:40
 */
@Mapper
public interface BluePrintProposalMapper {

	List<BluePrintProposal> list(Integer workshopId);

	int edit(List<BluePrintProposal> list);

	List<VoteUser> users(@Param("groupId")Integer groupId);
//	List<VoteUser> users(Integer groupId);

	Integer doVote(List<VotingBlueprint> list);

	List<BluePrintProposal> listVote(@Param("wid") Integer wid, @Param("gid") Integer gid);

	int sequence(List<Map<String, Integer>> list);

	/**
	 * 查询当前项目的排序是否已经存在
	 * 
	 * @param wid
	 * @return
	 */
	Integer getOrder(Integer wid);

	/**
	 * 将已有的排序序列查询
	 * 
	 * @param wid
	 * @param gid
	 * @return
	 */
	List<BluePrintProposal> listOrder(@Param("wid") Integer wid, @Param("gid") Integer gid);

	/**
	 * 获取项目的常见机会点和用户机会点
	 * 
	 * @param workshopId
	 * @return
	 */
	List<String> getOpportunity(Integer workshopId);

	/**将单元三的机会点转换保存到第五单元的提案领域设置
	 * @param list
	 * @return
	 */
	int insertBlueprintProposal(List<BluePrintProposal> list);

	void clearOrder(Integer workshopId);

}
