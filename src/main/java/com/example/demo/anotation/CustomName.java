package com.example.demo.anotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({  FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = { CustomNameAnotationImp.class})
public @interface CustomName {

    String message() default "İsim Yasin Olamaz";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
