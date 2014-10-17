package com.supinfo.hellojsf.constrain.validator;

import com.supinfo.hellojsf.constrain.annotation.PasswordAnnotation;
import com.supinfo.hellojsf.constrain.annotation.PasswordMode;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by Alexandre NGUYEN on 16/10/2014.
 */
public class PasswordConstrainValidator implements ConstraintValidator<PasswordAnnotation, String> {

    private PasswordMode passwordMode;

    @Override
    public void initialize(PasswordAnnotation passwordAnnotation) {
        this.passwordMode = passwordAnnotation.value();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,}$";

        if(s == null) {
            return false;
        }

        if(s.matches(pattern)) {
            return true;
        }
        else {
            return false;
        }
    }
}
