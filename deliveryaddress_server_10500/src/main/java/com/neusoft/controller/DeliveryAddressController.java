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

import com.neusoft.po.CommonResult;
import com.neusoft.po.DeliveryAddress;
import com.neusoft.service.DeliveryAddressService;

@RestController
@RequestMapping("/DeliveryAddressController")
public class DeliveryAddressController {

	@Autowired
	private DeliveryAddressService deliveryAddressService;
	
	@GetMapping("/listDeliveryAddressByUserId/{userId}")
	public CommonResult<List<DeliveryAddress>> listDeliveryAddressByUserId(@PathVariable("userId") String userId) {
		List<DeliveryAddress> list = deliveryAddressService.listDeliveryAddressByUserId(userId);
		return new CommonResult<>(200,"success",list);
	} 
	
	@GetMapping("/getDeliveryAddressById/{daId}")
	public CommonResult<DeliveryAddress> getDeliveryAddressById(@PathVariable("daId") Integer daId) {
		DeliveryAddress deliveryAddress = deliveryAddressService.getDeliveryAddressById(daId);
		return new CommonResult<>(200,"success",deliveryAddress);
	} 
	
	@PostMapping("/saveDeliveryAddress/{contactName}/{contactSex}/{contactTel}/{address}/{userId}")
	public CommonResult<Integer> saveDeliveryAddress(
			   @PathVariable("contactName") String contactName,
			   @PathVariable("contactSex") Integer contactSex,
			   @PathVariable("contactTel") String contactTel,
			   @PathVariable("address") String address,
			   @PathVariable("userId") String userId) {
		DeliveryAddress param = new DeliveryAddress();
		param.setContactName(contactName);
		param.setContactSex(contactSex);
		param.setContactTel(contactTel);
		param.setAddress(address);
		param.setUserId(userId);
		int result = deliveryAddressService.saveDeliveryAddress(param);
		return new CommonResult<>(200,"success",result);
	} 
	
	@PutMapping("/updateDeliveryAddress/{daId}/{contactName}/{contactSex}/{contactTel}/{address}")
	public CommonResult<Integer> updateDeliveryAddress(
			   @PathVariable("daId") Integer daId,
			   @PathVariable("contactName") String contactName,
			   @PathVariable("contactSex") Integer contactSex,
			   @PathVariable("contactTel") String contactTel,
			   @PathVariable("address") String address) {
		DeliveryAddress param = new DeliveryAddress();
		param.setDaId(daId);
		param.setContactName(contactName);
		param.setContactSex(contactSex);
		param.setContactTel(contactTel);
		param.setAddress(address);
		int result = deliveryAddressService.updateDeliveryAddress(param);
		return new CommonResult<>(200,"success",result);
	} 
	
	@DeleteMapping("/removeDeliveryAddress/{daId}")
	public CommonResult<Integer> removeDeliveryAddress(@PathVariable("daId") Integer daId) {
		int result = deliveryAddressService.removeDeliveryAddress(daId);
		return new CommonResult<>(200,"success",result);
	} 
}