package com.neusoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.po.Cart;
import com.neusoft.po.CommonResult;
import com.neusoft.service.CartService;

@RestController
@RequestMapping("/CartController")
public class CartController {

	@Autowired
	private CartService cartService;
	
	@GetMapping("/listCart/{userId}")
	public CommonResult<List<Cart>> listCart(@PathVariable("userId") String userId) {
		Cart param = new Cart();
		param.setUserId(userId);
		List<Cart> list = cartService.listCart(param);
		return new CommonResult<>(200,"success(10401)",list);
	}
	
	@GetMapping("/listCart/{userId}/{businessId}")
	public CommonResult<List<Cart>> listCart(
			   @PathVariable("userId") String userId,
			   @PathVariable("businessId") Integer businessId) {
		Cart param = new Cart();
		param.setUserId(userId);
		param.setBusinessId(businessId);
		List<Cart> list = cartService.listCart(param);
		return new CommonResult<>(200,"success(10401)",list);
	}
	
	@PostMapping("/saveCart/{userId}/{businessId}/{foodId}")
	public CommonResult<Integer> saveCart(
			   @PathVariable("userId") String userId,
			   @PathVariable("businessId") Integer businessId,
			   @PathVariable("foodId") Integer foodId) {
		Cart param = new Cart();
		param.setUserId(userId);
		param.setBusinessId(businessId);
		param.setFoodId(foodId);
		int result = cartService.saveCart(param);
		return new CommonResult<>(200,"success(10401)",result);
	}
	
	@PutMapping("/updateCart/{userId}/{businessId}/{foodId}/{quantity}")
	public CommonResult<Integer> updateCart(
			   @PathVariable("userId") String userId,
			   @PathVariable("businessId") Integer businessId,
			   @PathVariable("foodId") Integer foodId,
			   @PathVariable("quantity") Integer quantity) {
		Cart param = new Cart();
		param.setUserId(userId);
		param.setBusinessId(businessId);
		param.setFoodId(foodId);
		param.setQuantity(quantity);
		int result = cartService.updateCart(param);
		return new CommonResult<>(200,"success(10401)",result);
	}
	
	@DeleteMapping("/removeCart/{userId}/{businessId}/{foodId}")
	public CommonResult<Integer> removeCart(
			   @PathVariable("userId") String userId,
			   @PathVariable("businessId") Integer businessId,
			   @PathVariable("foodId") Integer foodId) {
		Cart param = new Cart();
		param.setUserId(userId);
		param.setBusinessId(businessId);
		param.setFoodId(foodId);
		int result = cartService.removeCart(param);
		return new CommonResult<>(200,"success(10401)",result);
	}
}