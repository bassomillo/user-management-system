package com.bassomillo.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtil {
    public static String getNowString(String pattren){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattren);
        return LocalDate.now().format(dateTimeFormatter);
    }

    public static String getNowString(){
        return getNowString("yyyy-MM-dd");
    }
}
