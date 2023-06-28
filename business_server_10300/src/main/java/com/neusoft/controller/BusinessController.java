package com.neusoft.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.feign.FoodFeignClient;
import com.neusoft.po.Business;
import com.neusoft.po.CommonResult;
import com.neusoft.service.BusinessService;

@RestController
@RequestMapping("/BusinessController")
public class BusinessController {
	
	@Autowired
	private BusinessService businessService;
	@Autowired
	private FoodFeignClient foodFeignClient;
	
	@GetMapping("/listBusinessByOrderTypeId/{orderTypeId}")
	public CommonResult<List<Business>> listBusinessByOrderTypeId(@PathVariable("orderTypeId") Integer orderTypeId) {
		List<Business> list = businessService.listBusinessByOrderTypeId(orderTypeId);
		return new CommonResult<>(200,"success(10300)",list);
	}
	
	@GetMapping("/getBusinessById/{businessId}")
	public CommonResult<Business> getBusinessById(@PathVariable("businessId") Integer businessId) {
		Business business = businessService.getBusinessById(businessId);
		//在商家微服务中调用食品微服务
		CommonResult<List> result = foodFeignClient.listFoodByBusinessId(businessId);
		//如果食品微服务返回降级响应，那么就返回空集合
		if (result.getCode() == 200) {
			business.setFoodList(result.getResult());
		}else {
			business.setFoodList(new ArrayList());
		}
		return new CommonResult<>(200,"success(10300)",business);
	}
}