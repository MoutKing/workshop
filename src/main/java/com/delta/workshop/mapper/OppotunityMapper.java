package com.delta.workshop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.delta.workshop.model.Opportunity;

/**
 * @author Qiang.Wei
 * @date 创建时间：2017-6-30 上午10:09:59
 * @Description
 */
@Mapper
public interface OppotunityMapper {

	Integer add(List<Opportunity> opprotunity);

	Integer update(Opportunity opprotunity);

	Integer delete(Integer id);

	List<Opportunity> list(@Param("painpointId") Integer pid, @Param("workshopId") Integer wid,
			@Param("classId") Integer cid, @Param("groupId") Integer gid, @Param("customer") String customer);

	List<Opportunity> list1(@Param("painpointId") Integer pid, @Param("workshopId") Integer wid,
			@Param("classId") Integer cid, @Param("groupId") Integer gid, @Param("customer") String customer);

}
