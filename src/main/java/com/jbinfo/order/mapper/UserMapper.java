package com.jbinfo.order.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.jbinfo.order.base.BaseMapper;
import com.jbinfo.order.model.User;

@Mapper
public interface UserMapper extends BaseMapper<User> {
	
}
