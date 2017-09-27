package com.delta.workshop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.delta.workshop.model.Industry;

@Mapper
public interface IndustryMapper {

	List<Industry> getAll();

}
