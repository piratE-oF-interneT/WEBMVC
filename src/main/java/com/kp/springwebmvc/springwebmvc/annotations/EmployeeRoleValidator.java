package com.kp.springwebmvc.springwebmvc.annotations;

import java.util.List;

import org.hibernate.validator.internal.engine.constraintvalidation.ConstraintValidatorContextImpl;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmployeeRoleValidator implements ConstraintValidator<EmployeeRoleValidation, String>{

	@Override
	public boolean isValid(String inputRole, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		
		List<String> roles = List.of("USER","ADMIN");
		
		return roles.contains(inputRole);
	}

}
