package com.delta.workshop.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UploadMapper {

	void add(@Param("filepath")String filepath, @Param("workshopId")Integer workshopId, @Param("key")String key);

	String getFilepath(@Param("workshopId")Integer workshopId, @Param("key")String key);

	void clearpath(@Param("workshopId")Integer workshopId, @Param("key")String key);

}
