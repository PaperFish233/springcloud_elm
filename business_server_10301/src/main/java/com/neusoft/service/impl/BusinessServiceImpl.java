package com.neusoft.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.mapper.BusinessMapper;
import com.neusoft.po.Business;
import com.neusoft.service.BusinessService;

@Service
public class BusinessServiceImpl implements BusinessService{
	
	@Autowired
	private BusinessMapper businessMapper;
	
	@Override
	public List<Business> listBusinessByOrderTypeId(Integer orderTypeId) {
		return businessMapper.listBusinessByOrderTypeId(orderTypeId);
	}

	@Override
	public Business getBusinessById(Integer businessId) {
		return businessMapper.getBusinessById(businessId);
	}

}
