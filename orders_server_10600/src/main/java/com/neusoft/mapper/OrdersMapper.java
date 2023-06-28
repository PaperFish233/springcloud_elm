package com.neusoft.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectKey;

import com.neusoft.po.Orders;

@Mapper
public interface OrdersMapper {
	
	@Insert("insert into orders values(null,#{userId},#{businessId},#{orderDate},#{orderTotal},#{daId},0)")
	//获取主键
	@SelectKey(statement = "SELECT LAST_INSERT_ID() AS id", keyProperty = "orderId", before = false, resultType = int.class)
	public int saveOrders(Orders orders);
	
    public Orders getOrdersById(Integer orderId);
    
    public List<Orders> listOrdersByUserId(String userId);

}
