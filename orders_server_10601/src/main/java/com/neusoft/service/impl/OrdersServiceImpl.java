package com.neusoft.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.mapper.CartMapper;
import com.neusoft.mapper.OrderDetailetMapper;
import com.neusoft.mapper.OrdersMapper;
import com.neusoft.po.Cart;
import com.neusoft.po.OrderDetailet;
import com.neusoft.po.Orders;
import com.neusoft.service.OrdersService;

@Service
public class OrdersServiceImpl implements OrdersService {

	@Autowired
	private CartMapper cartMapper;
	
	@Autowired
	private OrdersMapper ordersMapper;
	
	@Autowired
	private OrderDetailetMapper orderDetailetMapper;

	@Override
	@Transactional
	public int createOrders(Orders orders) {
		System.out.println(orders.toString());

		// 1、查询当前用户购物车中当前商家的所有食品
		Cart cart = new Cart();
		cart.setUserId(orders.getUserId());
		cart.setBusinessId(orders.getBusinessId());
		List<Cart> cartList = cartMapper.listCart(cart);

		// 2、创建订单（返回生成的订单编号）
		//获取当前时间
		Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datetime = formatter.format(calendar.getTime());
		orders.setOrderDate(datetime);
		ordersMapper.saveOrders(orders);
		//获取自动递增的订单编号
		int orderId = orders.getOrderId();

		// 3、批量添加订单明细
		List<OrderDetailet> list = new ArrayList<>();
		for (Cart c : cartList) {
			OrderDetailet od = new OrderDetailet();
			od.setOrderId(orderId);
			od.setFoodId(c.getFoodId());
			od.setQuantity(c.getQuantity());
			list.add(od);
		}
		orderDetailetMapper.saveOrderDetailetBatch(list);

		// 4、从购物车表中删除相关食品信息
		cartMapper.removeCart(cart);
		return orderId;
	}

	@Override
	public Orders getOrdersById(Integer orderId) {
		return ordersMapper.getOrdersById(orderId);
	}

	@Override
	public List<Orders> listOrdersByUserId(String userId) {
		return ordersMapper.listOrdersByUserId(userId);
	}

}
