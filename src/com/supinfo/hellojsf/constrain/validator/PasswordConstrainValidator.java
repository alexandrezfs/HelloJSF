package com.supinfo.hellojsf.constrain.validator;

import com.supinfo.hellojsf.constrain.annotation.Password;
import com.supinfo.hellojsf.constrain.annotation.PasswordMode;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by Alexandre NGUYEN on 16/10/2014.
 */
public class PasswordConstrainValidator implements ConstraintValidator<Password, String> {

    private PasswordMode passwordMode;

    @Override
    public void initialize(Password password) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {



        return false;
    }
}
