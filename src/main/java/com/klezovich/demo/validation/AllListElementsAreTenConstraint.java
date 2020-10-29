package com.klezovich.demo.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = AllIntListElementsAreTen.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface AllListElementsAreTenConstraint {
    String message() default "There is a list element which is not 10";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}