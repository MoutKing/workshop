package com.delta.workshop.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.delta.workshop.mapper.CustomerMapper;
import com.delta.workshop.mapper.WorkshopMapper;
import com.delta.workshop.model.Customer;
import com.delta.workshop.model.Workshop;
import com.delta.workshop.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerMapper customerMapper;

	@Autowired
	private WorkshopMapper workshopMapper;
	
	@Override
	public List<Customer> getAll() {
		return customerMapper.getAll();
	}

	@Override
	public String uploadLogo(MultipartFile file,String fileDirectory, Integer workshopId) throws IOException {
			if(file == null || workshopId == null){
				throw new IllegalArgumentException();
			}
			String fileName = file.getOriginalFilename();
			String suffixName = fileName.substring(fileName.lastIndexOf("."));
			fileName = UUID.randomUUID() + suffixName;
			String filePath ="/logo/"+fileName;
			File dest = new File(fileDirectory+filePath);
			if(!dest.getParentFile().exists()){
				dest.getParentFile().mkdirs();
			}
			file.transferTo(dest);
			Workshop workshop = workshopMapper.getById(workshopId);
			customerMapper.setLogo(filePath,workshop.getCustomer());
			return filePath;
	}

	@Override
	public String getFilepath(Integer workshopId) {
		
		return customerMapper.getFilepath(workshopId);
	}

}
