package com.neusoft.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.neusoft.po.DeliveryAddress;

@Mapper
public interface DeliveryAddressMapper {
	
	@Select("select * from deliveryaddress where userId=#{userId} order by daId")
	public List<DeliveryAddress> listDeliveryAddressByUserId(String userId);
	
	@Insert("insert into deliveryaddress values(null,#{contactName},#{contactSex},#{contactTel},#{address},#{userId})")
    public int saveDeliveryAddress(DeliveryAddress deliveryAddress);
    
	@Delete("delete from deliveryaddress where daId=#{daId}")
    public int removeDeliveryAddress(Integer daId);
    
    @Select("select * from deliveryaddress where daId=#{daId}")
    public DeliveryAddress getDeliveryAddressById(Integer daId);
    
    @Update("update deliveryaddress set contactName=#{contactName},contactSex=#{contactSex},contactTel=#{contactTel},address=#{address} where daId=#{daId}")
    public int updateDeliveryAddress(DeliveryAddress deliveryAddress);

}
