package com.jbinfo.order.util;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Lists;

public class MyValidator {
	
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * 服务端参数有效性验证
	 * @param object 验证的实体对象
	 * @param groups 验证组
	 * @return 验证成功：返回true；验证失败：将错误信息添加到 message 中
	 */
	public static String beanValidator(Object object, Class<?>... groups) {
		List<String> list = Lists.newArrayList();
		String strs=StringUtils.EMPTY;
		try{
			ValidatorFactory factory = Validation.buildDefaultValidatorFactory(); 
			Validator validator = factory.getValidator();
			MyValidator.validateWithException(validator, object, groups);
		}catch(ConstraintViolationException ex){
			list = MyValidator.extractPropertyAndMessageAsList(ex, ": ");
			for (String string : list) {
				strs+=string+",";
			}
			strs=strs.substring(0, strs.length()-1);
		}
		return strs;
	}
	
	
		
		
	/**
	 * 调用JSR303的validate方法, 验证失败时抛出ConstraintViolationException.
	 */
	
	private static void validateWithException(Validator validator, Object object, Class<?>... groups)
			throws ConstraintViolationException {
		Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object, groups);
		if (!constraintViolations.isEmpty()) {
			throw new ConstraintViolationException(constraintViolations);
		}
	}


	/**
	 * 辅助方法, 转换ConstraintViolationException中的Set<ConstraintViolations>为List<propertyPath +separator+ message>.
	 */
	private static List<String> extractPropertyAndMessageAsList(ConstraintViolationException e, String separator) {
		return extractPropertyAndMessageAsList(e.getConstraintViolations(), separator);
	}

	/**
	 * 辅助方法, 转换Set<ConstraintViolation>为List<propertyPath +separator+ message>.
	 */
	@SuppressWarnings("rawtypes")
	private static List<String> extractPropertyAndMessageAsList(Set<? extends ConstraintViolation> constraintViolations,
			String separator) {
		List<String> errorMessages = Lists.newArrayList();
		for (ConstraintViolation violation : constraintViolations) {
			errorMessages.add(violation.getPropertyPath() + separator + violation.getMessage());
		}
		return errorMessages;
	}
}
