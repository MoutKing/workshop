package com.delta.workshop.service;

import java.util.List;

import com.delta.workshop.model.VoteUser;
import com.delta.workshop.model.Voting;
import com.delta.workshop.model.VotingImproveway;
import com.delta.workshop.model.VotingOpportunity;
import com.delta.workshop.model.VotingPainPoint;

/**
 * @author Qiang.Wei
 * @date 创建时间：2017-6-20 上午10:09:26
 * @Description
 */

public interface VotingService {

	/**
	 * 各个单元查询投票用户的方法
	 * 
	 * @param wid
	 * @param gid
	 * @param uid
	 * @return
	 */
	List<VoteUser> user(Integer wid, Integer gid, Integer uid);

	/**
	 * 各个单元投票
	 * 
	 * @param list
	 * @param uid
	 * @return
	 */
	Integer doVoting(List<Voting> list, Integer uid);

	/**
	 * 痛点投票结果查询
	 * @param wid
	 * @param gid
	 * @return
	 */
	List<VotingPainPoint> listPainpoint(Integer wid, Integer gid);

	/** 提升方式投票结果查询
	 * @param wid
	 * @param gid
	 * @return
	 */
	List<VotingImproveway> listImprove(Integer wid, Integer gid);

	/** 机会点投票结果查询
	 * @param wid
	 * @param gid
	 * @return
	 */
	List<VotingOpportunity> listOpportunity(Integer wid, Integer gid);

}
