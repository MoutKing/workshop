package com.delta.workshop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.delta.workshop.model.Target;

@Mapper
public interface TargetMapper {

	List<Target> getAll();

}
