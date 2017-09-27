package com.delta.workshop.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.delta.workshop.mapper.CustomerMapper;
import com.delta.workshop.mapper.WorkshopMapper;
import com.delta.workshop.model.Customer;
import com.delta.workshop.model.Workshop;
import com.delta.workshop.service.WorkshopService;

@Service
public class WorkshopServiceImpl implements WorkshopService {

	@Autowired
	private WorkshopMapper workshopMapper;

	@Autowired
	private CustomerMapper customerMapper;
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void add(Workshop workshop) {
		workshopMapper.add(workshop);
		Customer customer= customerMapper.getCustomerById(workshop.getCustomer());
		if(customer == null){
			workshopMapper.addCustomer(workshop.getCustomer());
		}
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void edit(Workshop workshop) {
		workshop.setEditTime(new Date());
		workshopMapper.edit(workshop);
		Customer customer= customerMapper.getCustomerById(workshop.getCustomer());
		if(customer == null){
			workshopMapper.addCustomer(workshop.getCustomer());
		}
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void delete(Integer id) {
		workshopMapper.delete(id);

	}

	@Override
	public List<Workshop> getAll() {
		return workshopMapper.getAll();
	}

}
