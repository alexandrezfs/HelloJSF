package com.supinfo.hellojsf;

import javax.faces.bean.ManagedBean;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@ManagedBean
public class Hello {

    private final static DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    private final String welcomeMessage = "Hello World!";

    public String getWelcomeMessage() {
        String currentHour = dateFormat.format(new Date());
        return welcomeMessage + " " + currentHour;
    }

}