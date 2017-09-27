package com.delta.workshop.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.delta.workshop.mapper.UploadMapper;
import com.delta.workshop.service.UploadService;

@Service
public class UploadServiceImpl implements UploadService{
	
	@Autowired
	private UploadMapper uploadMapper;

	@Override
	@Transactional(rollbackFor=Exception.class)
	public String upload(String fileDirectory,MultipartFile file, Integer workshopId, String key) throws IllegalStateException, IOException {
		if(file==null){
			throw new IllegalArgumentException();
		}
		uploadMapper.clearpath(workshopId,key);
		String fileName = file.getOriginalFilename();
		String suffixName = fileName.substring(fileName.lastIndexOf("."));
		fileName = UUID.randomUUID() + suffixName;
		String filePath ="/ppt/"+fileName;
		File dest = new File(fileDirectory+filePath);
		if(!dest.getParentFile().exists()){
			dest.getParentFile().mkdirs();
		}
		file.transferTo(dest);
		uploadMapper.add(filePath,workshopId,key);
		return filePath;
	}

	@Override
	public String getFilepath(Integer workshopId, String key) {
		return uploadMapper.getFilepath(workshopId,key);
	}

}
