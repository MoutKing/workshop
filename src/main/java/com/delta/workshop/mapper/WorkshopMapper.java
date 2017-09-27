package com.delta.workshop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.delta.workshop.model.Workshop;

@Mapper
public interface WorkshopMapper {
    
    int add(Workshop record);

    void edit(Workshop record);

    void delete(Integer id);

	List<Workshop> getAll();

	void addCustomer(String customer);

	Workshop getById(Integer workshopId);  
}