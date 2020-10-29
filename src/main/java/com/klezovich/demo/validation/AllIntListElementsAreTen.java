package com.klezovich.demo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

import static java.util.stream.Collectors.toSet;

public class AllIntListElementsAreTen implements ConstraintValidator<AllListElementsAreTenConstraint, List<Integer>> {
   public void initialize(AllListElementsAreTenConstraint constraint) {
   }

   public boolean isValid(List<Integer> obj, ConstraintValidatorContext context) {
      return obj.stream()
          .filter( val -> val != 10 )
          .collect(toSet())
          .isEmpty();
   }
}
