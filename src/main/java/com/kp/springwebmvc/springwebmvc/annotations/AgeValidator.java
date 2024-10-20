package com.kp.springwebmvc.springwebmvc.annotations;

import java.util.Iterator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AgeValidator implements ConstraintValidator<PrimeAgeInterface, Integer>{

	@Override
	public boolean isValid(Integer inputAge, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		
		if (inputAge >= 25 && inputAge <= 60) {
			
//			check for prime age.
			
			for (int i = 2; i <= Math.sqrt(inputAge); i++) {
				if (inputAge%i==0) {
					return false;
				}
			}
			return true;
		}
		else {
			return false;
		}
		
		
	}

}
