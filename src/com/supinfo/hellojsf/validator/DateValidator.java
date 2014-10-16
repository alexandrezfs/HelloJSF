package com.supinfo.hellojsf.validator;

import com.supinfo.hellojsf.factory.BundleFactory;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Alexandre NGUYEN on 16/10/2014.
 */

@FacesValidator("dateValidator")
public class DateValidator implements Validator {

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        try {

            Date date = formatter.parse(o.toString());

        } catch (Exception e) {

            e.printStackTrace();

            FacesMessage msg =
                    new FacesMessage(BundleFactory.getInstance().getString("InvalidDate"),
                            BundleFactory.getInstance().getString("InvalidDate"));
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);

        }
    }
}
