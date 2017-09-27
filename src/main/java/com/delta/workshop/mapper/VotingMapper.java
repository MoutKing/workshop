package com.delta.workshop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.delta.workshop.model.VoteUser;
import com.delta.workshop.model.Voting;
import com.delta.workshop.model.VotingImproveway;
import com.delta.workshop.model.VotingOpportunity;
import com.delta.workshop.model.VotingPainPoint;

/**
 * @author Qiang.Wei
 * @date 创建时间：2017-6-20 上午10:15:55
 * @Description
 */
@Mapper
public interface VotingMapper {

	List<VoteUser> user1(@Param("workShopId")Integer wid, @Param("groupId")Integer gid);

	List<VoteUser> user2(@Param("workShopId")Integer wid, @Param("groupId")Integer gid);

	List<VoteUser> user3(@Param("workShopId")Integer wid, @Param("groupId")Integer gid);

	Integer doVoting1(List<Voting> list);

	Integer doVoting2(List<Voting> list);

	Integer doVoting3(List<Voting> list);

	List<VotingPainPoint> listPainpoint(@Param("workShopId")Integer wid, @Param("groupId")Integer gid);

	List<VotingImproveway> listImprove(@Param("workShopId")Integer wid, @Param("groupId")Integer gid);

	List<VotingOpportunity> listOpportunity(@Param("workShopId")Integer wid, @Param("groupId")Integer gid);

}
