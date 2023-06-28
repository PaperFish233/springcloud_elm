package com.neusoft.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.neusoft.po.Business;

@Mapper
public interface BusinessMapper {

	@Select("select * from business where orderTypeId = #{orderTypeId}")
	public List<Business> listBusinessByOrderTypeId(Integer orderTypeId);

	@Select("select * from business where businessId = #{businessId}")
	public Business getBusinessById(Integer businessId);
	
}
