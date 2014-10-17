package com.supinfo.hellojsf.constrain.annotation;

import com.supinfo.hellojsf.constrain.validator.PasswordConstrainValidator;

import javax.validation.Constraint;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import javax.validation.Payload;

/**
 * Created by Alexandre NGUYEN on 16/10/2014.
 */

@Target( { METHOD, FIELD, ANNOTATION_TYPE } )
@Retention(RUNTIME)
@Constraint(validatedBy = PasswordConstrainValidator.class)
@Documented
public @interface PasswordAnnotation {

    String message() default "a digit, a lower case, an upper case, a special character must occur at least once and must be > 6 characters.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    PasswordMode value();

}
