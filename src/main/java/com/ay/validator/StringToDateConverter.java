package com.ay.validator;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDateConverter implements Converter<String, Date> {
    private String datePattern = "yyyy-MM-dd";

    @Override
    public Date convert(String date) {

        SimpleDateFormat dateFormat = new SimpleDateFormat(this.datePattern);
        try {
            Date oneDate =  dateFormat.parse(date);
            return oneDate;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getDatePattern() {
        return datePattern;
    }

    public void setDatePattern(String datePattern) {
        this.datePattern = datePattern;
    }
}
