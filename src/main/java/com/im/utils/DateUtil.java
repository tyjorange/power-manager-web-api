package com.im.utils;

/**
 * 日期工具类
 * Created by tss on 2018/11/26.
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {


    /**
     * 获取某月份的天数
     *
     * @param date
     * @return
     */
    public static int getDaysOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取某年某月的第一天
     *
     * @param year
     * @param month
     * @return
     */
    public static String getFisrtDayOfMonth(String year, String month) {
        Calendar cal = Calendar.getInstance();
        if (year != null && !year.isEmpty() && month != null && !month.isEmpty()) {
            //设置年份
            cal.set(Calendar.YEAR, Integer.parseInt(year));
            //设置月份
            cal.set(Calendar.MONTH, Integer.parseInt(month) - 1);
        }
        //获取某月最小天数
        int firstDay = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
        //设置日历中月份的最小天数
        cal.set(Calendar.DAY_OF_MONTH, firstDay);
        //格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String firstDayOfMonth = sdf.format(cal.getTime());
        return firstDayOfMonth;
    }

    /**
     * 获取某年某月的最后一天日期
     *
     * @param year
     * @param month
     * @return
     */
    public static String getDateLastDay(String year, String month) {
        Calendar calendar = Calendar.getInstance();
        // 设置时间,当前时间不用设置
        if (year != null && !year.isEmpty() && month != null && !month.isEmpty()) {
            calendar.set(Calendar.YEAR, Integer.parseInt(year));
            calendar.set(Calendar.MONTH, Integer.parseInt(month) - 1);
        }
        calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(calendar.getTime());
    }

    /**
     * 获取某年第一天日期
     * @param year 年份
     * @return String
     */
    public static String getYearFirst(int year){
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        Date currYearFirst = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(currYearFirst);
    }

    /**
     * 获取某年最后一天日期
     * @param year 年份
     * @return String
     */
    public static String getYearLast(int year){
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        calendar.roll(Calendar.DAY_OF_YEAR, -1);
        Date currYearLast = calendar.getTime();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(currYearLast);
    }


    public static void main(String[] args) throws Exception {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
//        System.out.println(getDaysOfMonth(sdf.parse("2018-10")));
//        System.out.println(String.format("%02d",1));
        System.out.println(getYearFirst(2018));
        System.out.print(getYearLast(2018));
    }
}


