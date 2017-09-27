package com.delta.workshop.service;

import java.util.List;

import com.delta.workshop.model.Opportunity;

/**
 * @author Qiang.Wei
 * @date 创建时间：2017-6-30 上午9:27:39
 * @Description
 */
public interface OpportunityService {

    /**
     * 添加项目内的机会点
     * @param isTemplate 
     * @param opprotunity
     * @return
     */
    Integer add(boolean isTemplate, List<Opportunity> opprotunity);

    /**
     * 更新项目内的机会点
     * @param opprotunity
     * @return
     */
    Integer update(Opportunity opprotunity);

    /**
     * 根据机会点id删除机会点
     * @param id
     * @return
     */
    Integer delete(Integer id);

    
    /**
     * 查询项目中的机会点
     * @param pid
     * @param wid
     * @param cid
     * @param gid 
     * @param customer 
     * @return
     */
    List<Opportunity> list(Integer pid, Integer wid, Integer cid, Integer gid, String customer);

}
