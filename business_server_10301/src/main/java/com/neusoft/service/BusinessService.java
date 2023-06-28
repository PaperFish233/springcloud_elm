package com.neusoft.service;

import java.util.List;

import com.neusoft.po.Business;

public interface BusinessService {

	public List<Business> listBusinessByOrderTypeId(Integer orderTypeId);

	public Business getBusinessById(Integer businessId);

}
