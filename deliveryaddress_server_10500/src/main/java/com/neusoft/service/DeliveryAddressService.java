package com.neusoft.service;

import java.util.List;

import com.neusoft.po.DeliveryAddress;

public interface DeliveryAddressService {
	
	public List<DeliveryAddress> listDeliveryAddressByUserId(String userId);
	
    public int saveDeliveryAddress(DeliveryAddress deliveryAddress);
    
    public int removeDeliveryAddress(Integer daId);
    
    public DeliveryAddress getDeliveryAddressById(Integer daId);
    
    public int updateDeliveryAddress(DeliveryAddress deliveryAddress);

}
