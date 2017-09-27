package com.delta.workshop.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface UploadService {

	String upload(String fileDirectory, MultipartFile file, Integer workshopId, String key) throws IllegalStateException, IOException;

	String getFilepath(Integer workshopId, String key);

}
