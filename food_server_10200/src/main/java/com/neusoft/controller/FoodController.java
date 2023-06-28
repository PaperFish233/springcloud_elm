package com.neusoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.po.CommonResult;
import com.neusoft.po.Food;
import com.neusoft.service.FoodService;

@RestController
@RequestMapping("/FoodController")
public class FoodController {
	
	@Autowired
	private FoodService foodService;

	@GetMapping("/listFoodByBusinessId/{businessId}")
	public CommonResult<List<Food>> listFoodByBusinessId(@PathVariable("businessId") Integer businessId) {
	    List<Food> list = foodService.listFoodByBusinessId(businessId);
	    return new CommonResult<>(200,"success(10200)", list);
	}
}