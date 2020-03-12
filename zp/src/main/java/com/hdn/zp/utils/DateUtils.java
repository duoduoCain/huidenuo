package com.hdn.zp.utils;

import cn.hutool.core.date.DateUtil;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.lang.management.ManagementFactory;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * {@link Date} 解析、格式化的脚手架构工具类.
 *
 * @author devzzm
 *
 */
public final class DateUtils extends org.apache.commons.lang3.time.DateUtils{

    /** 简单的日期格式： yyyy-MM-dd */
    public static final String PATTERN_SIMPLE_DATE = "yyyy-MM-dd";

    public static final Date parse(String source, String pattern) {
        try {
            return new SimpleDateFormat(pattern).parse(source);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static final String format(Date date, String pattern) {
        return new SimpleDateFormat(pattern).format(date);
    }

    /**
     * 判断指定的两个日期的所属的星期是否相同.
     *
     * @return 当两个日期相同时返回 <code>true</code>
     */
    public static boolean isSameWeekOfday(Date d1, Date d2) {
        Calendar d1Cal = Calendar.getInstance();
        d1Cal.setTime(d1);
        Calendar d2Cal = Calendar.getInstance();
        d2Cal.setTime(d2);
        return d1Cal.get(Calendar.DAY_OF_WEEK) == d2Cal.get(Calendar.DAY_OF_WEEK);
    }

    public static String YYYY = "yyyy";

    public static String YYYY_MM = "yyyy-MM";

    public static String YYYY_MM_DD = "yyyy-MM-dd";

    public static String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    public static String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    private static String[] parsePatterns = { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM",
            "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM", "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss",
            "yyyy.MM.dd HH:mm", "yyyy.MM" };

    /**
     * 获取当前Date型日期yyyymmdd HH:mm:ss
     *
     * @return Date() 当前日期
     */
    public static Date getNowDate() {
        return new Date();
    }

    /**
     * 获取当前Date型日期,yyyy-mm-dd
     */
    public static Date getNowDateOnly() {
        try {
            return new SimpleDateFormat(YYYY_MM_DD).parse(getDate());
        } catch (ParseException e) {
            return getNowDate();
        }
    }

    /**
     * 获取当前日期, 默认格式为yyyy-MM-dd
     *
     * @return String
     */
    public static String getDate() {
        return dateTimeNow(YYYY_MM_DD);
    }

    public static final String getTime() {
        return dateTimeNow(YYYY_MM_DD_HH_MM_SS);
    }

    public static final String dateTimeNow() {
        return dateTimeNow(YYYYMMDDHHMMSS);
    }

    public static final String dateTimeNow(final String format) {
        return parseDateToStr(format, new Date());
    }

    public static final String dateTime(final Date date) {
        return parseDateToStr(YYYY_MM_DD, date);
    }

    public static final String parseDateToStr(final String format, final Date date) {
        return new SimpleDateFormat(format).format(date);
    }

    public static final Date dateTime(final String format, final String ts) {
        try {
            return new SimpleDateFormat(format).parse(ts);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 日期路径 即年/月/日 如2018/08/08
     */
    public static final String datePath() {
        Date now = new Date();
        return DateFormatUtils.format(now, "yyyy/MM/dd");
    }

    /**
     * 日期路径 即年/月/日 如20180808
     */
    public static final String dateTime() {
        Date now = new Date();
        return DateFormatUtils.format(now, "yyyyMMdd");
    }

    /**
     * 日期型字符串转化为日期 格式
     */
    public static Date parseDate(Object str) {
        if (str == null) {
            return null;
        }
        try {
            return parseDate(str.toString(), parsePatterns);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 获取服务器启动时间
     */
    public static Date getServerStartDate() {
        long time = ManagementFactory.getRuntimeMXBean().getStartTime();
        return new Date(time);
    }

    /**
     * 计算两个时间差
     */
    public static String getDatePoor(Date endDate, Date nowDate) {
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        // long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - nowDate.getTime();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        // long sec = diff % nd % nh % nm / ns;
        return day + "天" + hour + "小时" + min + "分钟";
    }

    /**
     * 计算相差的小时
     *
     * @param fromDate 从一个时间时间小的
     * @param toDate   到一个时间 大的
     * @return
     */
    public static Long getDatePoorHour(Date fromDate, Date toDate) {
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long diff = toDate.getTime() - fromDate.getTime();
        long hour = diff % nd / nh;
        return hour;
    }

    /**
     * 计算相差的周
     *
     * @param start
     * @param end
     * @return
     */
    public static Integer getDatePoorWeek(Date start, Date end) {
        Integer twoDateDays = getTwoDateDays(start, end);
        Integer week = twoDateDays / 7;
        long asd = twoDateDays % 7;
        if (asd != 0) {
            week += 1;
        }
        return Integer.valueOf(String.valueOf(week));
    }

    public static Integer getTwoDateDays(Date start, Date end) {
        long timeStamp = end.getTime() - start.getTime();
        long betweenDate = (timeStamp) / (60 * 60 * 24 * 1000);
        long nd = 1000 * 24 * 60 * 60;
        long hour = timeStamp % nd;
        if (hour != 0) {
            betweenDate += 1;
        }
        return Integer.valueOf(String.valueOf(betweenDate));
    }

    public static Integer getTwoDateMonth(Date start, Date end) {
        Integer twoDateDays = getTwoDateDays(start, end);
        Integer month = twoDateDays / 30;
        long asd = twoDateDays % 30;
        if (asd != 0) {
            month += 1;
        }
        System.out.println(asd);
        return Integer.valueOf(String.valueOf(month));
    }


    /**
     * 比较当前时间和传入时间的差值 以日形式表示 true 表示 已经超出期限
     *
     * @param endDate
     * @param diffTime 传入的期限
     * @return
     */
    public static Boolean getDatePoorInTimeStamp(Date endDate, double diffTime) {
        long diff = new Date().getTime() - endDate.getTime();
        double div = (double) diff / (double) (1000 * 3600 * 24);
        boolean bb = div > diffTime ? true : false;
        return bb;
    }

    public static Date addDateByNumberDay(Date date, int numberDay) {
        return addDays(date, numberDay);
    }

    /**
     * 获取当前时间到当天最后一秒钟的 秒数
     *
     * @return
     */
    public static Long getCurDateEndTime() {
        long curTime = System.currentTimeMillis();
        Date date = getNowDate();
        Date days = addDays(date, 1);
        SimpleDateFormat fa = new SimpleDateFormat(YYYY_MM_DD);
        try {
            Date date2 = fa.parse(DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD, days));
            long time = date2.getTime();
            return (time - curTime) / 1000;
        } catch (ParseException e) {
            return 0L;
        }
    }


    public static Date getCurDateStart(int number) throws ParseException {
        Date date = getNowDate();
        Date addDays = addDays(date, -number);
        SimpleDateFormat fa = new SimpleDateFormat(YYYY_MM_DD);
        Date parse = fa.parse(parseDateToStr(YYYY_MM_DD_HH_MM_SS, addDays));

        return parse;
    }

    public static Date getCurDateEnd() throws ParseException {
        Date date = getNowDate();
        Date addDays = addDays(date, 1);
        SimpleDateFormat fa = new SimpleDateFormat(YYYY_MM_DD);
        Date parse = fa.parse(parseDateToStr(YYYY_MM_DD_HH_MM_SS, addDays));
        return parse;
    }

    /**
     * 获取当前日期跟明天凌晨（00:00:00）相差的秒数
     *
     */
    public static Long getLessTomorrowSecond() {
        Long tomorrowLong = DateUtil.beginOfDay(DateUtil.tomorrow()).getTime();
        Long nowLong = DateUtil.date().getTime();
        return (tomorrowLong - nowLong) / 1000;
    }


}
