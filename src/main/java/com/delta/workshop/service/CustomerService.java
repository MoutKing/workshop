package com.delta.workshop.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.delta.workshop.model.Customer;

public interface CustomerService {

	List<Customer> getAll();

	String uploadLogo(MultipartFile file,String fileDirectory, Integer workshopId) throws IOException;

	String getFilepath(Integer workshopId);

}
