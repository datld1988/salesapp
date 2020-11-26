package com.salesapp.saleskitservice.util;

import org.apache.commons.lang.StringUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtil {

    public static Date convertStringToDate(String value) {
        Date result = null;
        if (StringUtils.isBlank(value)) {
            return result;
        }
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            result = dateFormat.parse(value);
        } catch (Exception ex) {
            result = null;
        }
        return result;
    }

    public static String convertDateToString(Date value) {
        String result = null;
        if (value == null) {
            return result;
        }
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            result = dateFormat.format(value);
        } catch (Exception ex) {
            result = null;
        }
        return result;
    }
}
