package com.kp.springwebmvc.springwebmvc.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {DeptTitleValidator.class})

public @interface DeptTitleValidation {
	
	String message() default "{title must have one upper , one lower and one special character}";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

}
