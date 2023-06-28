package com.neusoft.service;

import java.util.List;

import com.neusoft.po.Food;

public interface FoodService {

	public List<Food> listFoodByBusinessId(Integer businessId);

}
