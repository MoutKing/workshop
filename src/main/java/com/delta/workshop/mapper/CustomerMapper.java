package com.delta.workshop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.delta.workshop.model.Customer;

@Mapper
public interface CustomerMapper {

	List<Customer> getAll();

	void setLogo(@Param("logo")String filePath, @Param("customer")String customer);

	Customer getCustomerById(String customer);

	String getFilepath(Integer workshopId);

}
