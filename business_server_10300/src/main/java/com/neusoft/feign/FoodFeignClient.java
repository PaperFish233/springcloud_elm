package com.neusoft.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.neusoft.po.CommonResult;

//name属性指定调用的食品微服务名,fallback属性指定熔断降级方法
@FeignClient(name="food-server",fallback=FoodFeignClientCallBack.class)
public interface FoodFeignClient {

	@GetMapping("/FoodController/listFoodByBusinessId/{businessId}")
	public CommonResult listFoodByBusinessId(@PathVariable("businessId") Integer businessId);
}
