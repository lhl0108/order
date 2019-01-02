package com.jbinfo.order.model;

import org.hibernate.validator.constraints.NotEmpty;

import com.jbinfo.order.base.BaseEntity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User extends BaseEntity{
	private static final long serialVersionUID = 1L;
	@NotEmpty(message="用户姓名不能为空")
	private String username;
	@NotEmpty(message="密码不能为空")
    private String password;
    private Integer age;


}
