package com.supinfo.hellojsf.validator;

import com.supinfo.hellojsf.factory.BundleFactory;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.ConverterException;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Alexandre NGUYEN on 16/10/2014.
 */

@FacesValidator("emailValidator")
public class EmailValidator implements Validator{

    private final static String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private final static Pattern EMAIL_COMPILED_PATTERN = Pattern.compile(EMAIL_PATTERN);

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {

        // No value is not ok
        if (o == null || "".equals((String)o)) {
            throw new ValidatorException(getFacesErrorMsg());
        }

        // The email matcher
        Matcher matcher = EMAIL_COMPILED_PATTERN.matcher((String)o);

        if (!matcher.matches()) {   // Email doesn't match
            throw new ValidatorException(getFacesErrorMsg());
        }
    }

    private FacesMessage getFacesErrorMsg() {
        FacesMessage msg =
                new FacesMessage(BundleFactory.getInstance().getString("EmailValidationError"),
                        BundleFactory.getInstance().getString("EmailValidationError"));

        msg.setSeverity(FacesMessage.SEVERITY_ERROR);
        return msg;
    }
}
