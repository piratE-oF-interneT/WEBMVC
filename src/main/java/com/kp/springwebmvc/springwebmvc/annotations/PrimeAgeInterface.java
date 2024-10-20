package com.kp.springwebmvc.springwebmvc.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {AgeValidator.class})
public @interface PrimeAgeInterface {
	
	String message() default "{age must be prime number......}";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };


}
