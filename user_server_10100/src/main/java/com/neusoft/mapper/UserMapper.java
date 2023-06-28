package com.neusoft.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.neusoft.po.User;

@Mapper
public interface UserMapper {

	@Select("select * from user where userId=#{userId} and password=#{password}")
	public User getUserByIdByPass(User user);

	@Insert("insert into user values(#{userId},#{password},#{userName},#{userSex},#{userImg},1)")
	public int saveUser(User user);

	@Select("select count(*) from user where userId=#{userId}")
	public int getUserById(String userId);

}
