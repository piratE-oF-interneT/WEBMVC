package com.kp.springwebmvc.springwebmvc.annotations;

import java.util.function.Predicate;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DeptTitleValidator implements ConstraintValidator<DeptTitleValidation, String>{

	@Override
	public boolean isValid(String password, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		
//		note ---> using title as password --> nothing to worry...............
		
	    if (password == null) {
            return false; // Password should not be null
        }

        // Validate password length
        if (password.length() < 6) {
            return false; // Minimum length requirement
        }

        // Check for at least one uppercase letter
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }

        // Check for at least one lowercase letter
        if (!password.matches(".*[a-z].*")) {
            return false;
        }

        // Check for at least one digit
        if (!password.matches(".*[0-9].*")) {
            return false;
        }

        // Check for at least one special character
        if (!password.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
            return false;
        }
        
        return true;
	}
	
	

}
