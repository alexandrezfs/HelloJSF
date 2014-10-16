package com.supinfo.hellojsf.factory;

import java.util.ResourceBundle;

/**
 * Created by Alexandre NGUYEN on 16/10/2014.
 */
public class BundleFactory {

    private static ResourceBundle resourceBundle = null;

    public static ResourceBundle getInstance() {

        if(resourceBundle == null) {
           resourceBundle = ResourceBundle.getBundle("com.supinfo.hellojsf.i18n.lang");
        }

        return resourceBundle;
    }

}
