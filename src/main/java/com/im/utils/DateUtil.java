package com.im.utils;

/**
 * 日期工具类
 * Created by tss on 2018/11/26.
 */

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {


    public static int getDaysOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    public static void main(String[] args) throws ParseException {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
//        System.out.println(getDaysOfMonth(sdf.parse("2018-10")));
//        System.out.println(String.format("%02d",1));
    }
}


