package com.supinfo.hellojsf.Converter;

import com.supinfo.hellojsf.factory.BundleFactory;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Alexandre NGUYEN on 16/10/2014.
 */

@FacesConverter("birthdayConverter")
public class BirthdayConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

            try {

                Date convertedDate = formatter.parse(s);
                System.out.println(convertedDate);
                System.out.println(formatter.format(convertedDate));

                if(convertedDate.before(new Date())) {
                    return convertedDate;
                }
                else {
                    throw new ConverterException(getFacesErrorMsg());
                }

            } catch (ParseException e) {
                e.printStackTrace();

                throw new ConverterException(getFacesErrorMsg());
            }
    }

    private FacesMessage getFacesErrorMsg() {
        FacesMessage msg =
                new FacesMessage(BundleFactory.getInstance().getString("DateMsgError"),
                        BundleFactory.getInstance().getString("InvalidDate"));

        msg.setSeverity(FacesMessage.SEVERITY_ERROR);

        return msg;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(o);

    }

}