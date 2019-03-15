package com.rtmap.middle.framework.utils;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class DateUtil {


    /**
     * 格式化时间
     *
     * @param date
     * @param pattern
     * @return
     */
    public static String getDate(Date date, String pattern) {
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        return df.format(date);
    }


    /**
     * 获取当前日期是星期几
     *
     * @param date
     * @return 当前日期是星期几
     */
    public static Integer getWeekOfDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        Integer w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w == 0) {
            w = 7;
        }
        return w;
    }

    /**
     * 时间戳+随机数
     *
     * @param randomLength 自定义随机数位数
     * @return
     */
    public static String getTimestampString(int randomLength) {
        ThreadLocal<DateFormat> threadLocal = new ThreadLocal<DateFormat>() {
            @Override
            protected DateFormat initialValue() {
                return new SimpleDateFormat("yyyyMMddHHmmss");
            }
        };
        StringBuilder sb = new StringBuilder(threadLocal.get().format(new Date()));
        //0-9随机数
        for (int i = 0; i < randomLength; i++){
            sb.append(ThreadLocalRandom.current().nextInt(9));
        }
        return sb.toString();
    }

    /**
     * @Description:判断时期是不是月初，是的话返回true，不是返回false
     * @Auth zhangshaohua@rtmap.com
     * @Date 2018/7/4
     */
    public static boolean isFirstDayOfMonth(Date date) {
        if (null == date) {
            return false;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_MONTH) == Calendar.SUNDAY;
    }

    /**
     * 获取日期的年份
     *
     * @param date
     * @return
     */
    public static Integer yearOfDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }


    /**
     * 获取时分
     *
     * @param date
     * @return
     */
    public static String formatHours(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        return sdf.format(date);
    }


    /**
     * 判断是否在时间段内
     *
     * @param beginDate  12:00
     * @param endDate    12:00
     * @param targetDate 12:00
     * @return
     * @throws ParseException
     */
    public static boolean timeIsBetween(String beginDate, String endDate, String targetDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        try {
            Long begin = sdf.parse(beginDate).getTime();
            Long end = sdf.parse(endDate).getTime();
            Long target = sdf.parse(targetDate).getTime();
            return begin <= target && target <= end;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 将毫秒转换成 天、时、分、秒字符串
     *
     * @param milliseconds 毫秒数
     * @return
     */
    public static String formatMillieconds(long milliseconds) {
        StringBuilder stringBuffer = new StringBuilder();
        if (milliseconds < 1000) {
            stringBuffer.append(milliseconds).append("毫秒");
            return stringBuffer.toString();
        }
        long seconds = milliseconds / 1000;
        if (seconds < 60) {
            stringBuffer.append(seconds).append("秒");
            return stringBuffer.toString();
        }
        long second = seconds % 60;
        long min = seconds / 60;
        if (min < 60) {
            stringBuffer.append(min).append("分").append(second).append("秒");
            return stringBuffer.toString();
        }
        long hour = min / 60;
        min = min % 60;
        if (hour < 24) {
            stringBuffer.append(hour).append("小时").append(min).append("分").append(second).append("秒");
            return stringBuffer.toString();
        }
        long day = hour / 24;
        hour = hour % 24;
        stringBuffer.append(day).append("天").append(hour).append("小时").append(min).append("分").append(second).append("秒");
        return stringBuffer.toString();
    }

    /**
     * get date format
     *
     * @return
     */
    public static String getCurrentDateTime(String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = new Date();
        return sdf.format(date);
    }

    public static String transferDate(String date) {
        String[] fields = date.split("/");
        int month = Integer.parseInt(fields[1]);
        int day = Integer.parseInt(fields[2]);

        String m = null;
        String d = null;
        if (month < 10) {
            m = "0" + month;
        } else {
            m = month + "";
        }
        if (day < 10) {
            d = "0" + day;
        } else {
            d = day + "";
        }
        return fields[0] + "-" + m + "-" + d;

    }

    public static String getCurrentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        return sdf.format(date);
    }

    public static String getCurrentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        return sdf.format(date);
    }

    public static int getCurrentHour() {
        Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);

        return hour;

    }

    public static int getTimeHour(String dateTime, String format) throws ParseException {
        if (format == null) format = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sd = new SimpleDateFormat(format);
        Date d = sd.parse(dateTime);
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        int hour = c.get(Calendar.HOUR_OF_DAY);
        return hour;
    }

    public static Date translateFormat(String dateString) throws ParseException {
        Date date = new Date(dateString);
        String str = formatDate(date, "yyyy-MM-dd HH:mm:ss");
        return getDate(str, null);
    }

    public static Date getDate(String dateTime, String format) {
        if (format == null) format = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sd = new SimpleDateFormat(format);
        Date d = null;
        try {
            d = sd.parse(dateTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return d;
    }


    /**
     * @param endDate
     * @param i
     * @return
     */
    public static Date addDay(String endDate, int i) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        GregorianCalendar now = new GregorianCalendar();
        if (!StringUtils.isBlank(endDate)) {
            Date time = null;
            try {
                time = sdf.parse(endDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            now.setTime(time);
        }
        now.add(GregorianCalendar.DAY_OF_MONTH, i);
        return now.getTime();
    }

    /**
     * 在指定时间上添加天数
     */
    public static Date addDay(Date date, int offset) {
        if (null == date) {
            return null;
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, offset);
        return c.getTime();
    }

    public static boolean isToday(String dateTime, String format) throws ParseException {
        if (format == null) format = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sd = new SimpleDateFormat(format);
        Date d = sd.parse(dateTime);
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        Calendar cur = Calendar.getInstance();
        return cur.get(Calendar.YEAR) == c.get(Calendar.YEAR) && cur.get(Calendar.MONTH) == c.get(Calendar.MONTH) && cur.get(Calendar.DAY_OF_MONTH) == c.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * @param date
     * @return
     */
    public static int parseToMonth(String date) {
        String[] fields = date.split("-");
        if (fields.length > 1) {
            return Integer.parseInt(fields[1]);
        }
        return 0;
    }

    public static String parseMonthDate(int year, int month) {
        String date = year + "-";
        if (month < 10) {
            date = date + "0" + month;
        } else {
            date = date + month;
        }
        return date + "-01";
    }

    /**
     * @param date
     * @return
     */
    public static int parseToYear(String date) {
        String[] fields = date.split("-");
        if (fields[0].length() == 4) {
            return Integer.parseInt(fields[0]);
        }
        return 0;
    }

    /**
     * @param days
     * @return
     */
    public static String getDateByCondition(int days) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, days);
        return sdf.format(calendar.getTime());
    }

    public static String getDateByCondition(int days, String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(sdf.parse(date));
        calendar.add(Calendar.DATE, days);
        return sdf.format(calendar.getTime());
    }

    /**
     * @param date
     * @return
     * @throws ParseException
     */
    public static Date parseToDate(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.parse(date);
    }

    /**
     * @param year
     * @param month
     * @param day
     * @return
     */
    public static String getDirByDate(int year, int month, int day) {
        StringBuilder sb = new StringBuilder();
        sb.append(year).append("-");
        if (month < 10) {
            sb.append("0");
        }
        sb.append(month);
        sb.append("-");
        if (month < 10) {
            sb.append("0");
        }
        sb.append("day");
        return sb.toString();
    }

    /**
     * get date
     *
     * @param date
     * @return
     */
    public static int getYear(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date d = sdf.parse(date);
            return d.getYear() + 1900;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * get date
     *
     * @return
     */
    public static int getYear() {
        Date date = new Date();
        return date.getYear() + 1900;
    }

    /**
     * get current month
     *
     * @return
     */
    public static int getMonth() {
        Date date = new Date();
        return date.getMonth() + 1;
    }

    /**
     * get month
     *
     * @param date
     * @return
     */
    public static int getMonth(String date) {
        if (date == null) {
            return 0;
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date d = sdf.parse(date);
            return d.getMonth() + 1;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * get quarter
     *
     * @param date
     * @return
     */
    public static int getQuarter(String date) {
        if (date == null) {
            return 0;
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date d = sdf.parse(date);
            int month = d.getMonth() + 1;
            if (month < 4) {
                return 1;
            } else if (month < 7) {
                return 2;
            } else if (month < 10) {
                return 3;
            } else {
                return 4;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * get quarter
     *
     * @return
     */
    public static int getQuarter() {
        Date d = new Date();
        int month = d.getMonth() + 1;
        if (month < 4) {
            return 1;
        } else if (month < 7) {
            return 2;
        } else if (month < 10) {
            return 3;
        } else {
            return 4;
        }
    }

    /**
     * get day
     *
     * @param date
     * @return
     */
    public static int getDay(String date) {
        if (date == null) {
            return 0;
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date d = sdf.parse(date);
            return d.getDay() + 1;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * @param time1
     * @param time2
     * @return
     * @throws ParseException
     */
    public static long getTimeDiff(String time1, String time2) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return getTimeDiff(df.parse(time1), df.parse(time2));
    }

    /**
     * 秒
     *
     * @param time1
     * @param time2
     * @return
     * @throws ParseException
     */
    public static long getTimeDiff(Date time1, Date time2) throws ParseException {
        long t1 = time1.getTime();
        long t2 = time2.getTime();
        long diff = (t1 - t2) / 1000;
        return diff;
    }

    /**
     * @param match
     * @param target
     * @return
     * @throws ParseException
     */
    public static boolean greatThan(String match, String target) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long greater = simpleDateFormat.parse(match).getTime();
        long lower = simpleDateFormat.parse(target).getTime();
        return greater > lower;
    }

    public static boolean compareDate(String date1, String date2, String format) throws ParseException {
        SimpleDateFormat sdf = null;
        if (format == null) {
            sdf = new SimpleDateFormat("yyyy-MM-dd");
        } else {
            sdf = new SimpleDateFormat(format);
        }
        long d1 = sdf.parse(date1).getTime();
        long d2 = sdf.parse(date2).getTime();
        return d1 >= d2;
    }

    /**
     * @param date1
     * @param date2
     * @return
     * @throws ParseException
     */
    public static boolean compareDate(Date date1, Date date2) throws ParseException {
        if (date1 != null && date2 != null) {
            long d1 = date1.getTime();
            long d2 = date2.getTime();
            return d1 >= d2;
        }
        return true;
    }

    public static String formatDate(Date date, String format) throws ParseException {
        if (format == null || "".equals(format)) {
            format = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        if (date == null) {
            return "";
        }
        return sdf.format(date);
    }

    /**
     * get time millisecond from string date
     *
     * @param date
     * @return
     * @throws ParseException
     */
    public static long getMillisFromString(String date) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.parse(date).getTime();
    }

    /**
     * @param beginDate
     * @param endDate
     * @param targetDate
     * @return
     * @throws ParseException
     */
    public static boolean isBetween(String beginDate, String endDate, String targetDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        long begin = sdf.parse(beginDate).getTime();
        long end = sdf.parse(endDate).getTime();

        long target = sdf.parse(targetDate).getTime();
        return begin <= target && target <= end;
    }

    /**
     * @param beginDate
     * @param endDate
     * @param targetDate
     * @param format
     * @return
     * @throws ParseException
     */
    public static boolean isBetween(String beginDate, String endDate, String targetDate, String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        long begin = sdf.parse(beginDate).getTime();
        long end = sdf.parse(endDate).getTime();

        long target = sdf.parse(targetDate).getTime();
        return begin <= target && target <= end;
    }

    /**
     * @param date1
     * @param date2
     * @return
     * @throws ParseException
     */
    public static boolean compareTo(String date1, String date2) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        long d1 = sdf.parse(date1).getTime();
        long d2 = sdf.parse(date2).getTime();
        return d1 > d2;

    }

    public static boolean isCurrentWeek(String date) {
        if (date == null) {
            return false;
        }
        if (DateUtil.getMonth() != DateUtil.getMonth(date)) {
            return false;
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar cal = Calendar.getInstance();
            cal.setTime(new Date());
            int weekCurrent = cal.get(Calendar.WEEK_OF_MONTH);

            cal.setTime(new Date(sdf.parse(date).getTime()));
            int weekInput = cal.get(Calendar.WEEK_OF_MONTH);
            return (weekCurrent == weekInput);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean isSameWeek(String date1, String date2) {
        if (date1 == null || date2 == null) {
            return false;
        }
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date dateTime1 = df.parse(date1);
            calendar.setTime(dateTime1);
            Integer w1 = calendar.get(Calendar.WEEK_OF_YEAR);

            Date dateTime2 = df.parse(date2);
            calendar.setTime(dateTime2);
            Integer w2 = calendar.get(Calendar.WEEK_OF_YEAR);
            return w1 == w2;
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isSameMonth(String date1, String date2, String pattern) {
        if (date1 == null || date2 == null) {
            return false;
        }
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat(pattern);

        try {
            Date dateTime1 = df.parse(date1);
            calendar.setTime(dateTime1);
            Integer w1 = calendar.get(Calendar.MONTH);

            Date dateTime2 = df.parse(date2);
            calendar.setTime(dateTime2);
            Integer w2 = calendar.get(Calendar.MONTH);
            return w1 == w2;
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    }


    public static int getDaysOfMonth(String date) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        calendar.setTime(sdf.parse(date));
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

    }

    /**
     * 得到前一天
     *
     * @param date
     * @return
     */
    public static Date getPreDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        if (date != null) {
            calendar.setTime(date);
        }
        //得到前一天
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        return calendar.getTime();
    }

    public static Date getNexTDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        if (date != null) {
            calendar.setTime(date);
        }
        //得到后一天
        calendar.add(Calendar.DAY_OF_MONTH, +1);
        return calendar.getTime();
    }

    /**
     * 获得两个日期相差的天数
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int getDateDiff(String date1, String date2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            long time1 = simpleDateFormat.parse(date1).getTime();
            long time2 = simpleDateFormat.parse(date2).getTime();
            return Integer.parseInt(String.valueOf(Math.abs(time2 - time1) / (1000 * 3600 * 24)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 获得两个日期相差的小时数
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int getDateDiff(Timestamp date1, Timestamp date2) {
        try {
            long time1 = date1.getTime();
            long time2 = date2.getTime();
            return Integer.parseInt(String.valueOf(Math.abs(time2 - time1) / (1000 * 3600)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }


    /**
     * 获得两个日期相差的分钟数
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int getDateMinDiff(Timestamp date1, Timestamp date2) {
        try {
            long time1 = date1.getTime();
            long time2 = date2.getTime();
            return Integer.parseInt(String.valueOf(Math.abs(time2 - time1) / (60 * 1000)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 获得两个日期之间的所有日期
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static List<String> getDateListBtween(String startDate, String endDate) {
        int diff = getDateDiff(startDate, endDate);
        List<String> listDate = new ArrayList<>();
        for (int i = 0; i < diff + 1; i++) {
            try {
                String day = getDateByCondition(i, startDate);
                listDate.add(day);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return listDate;
    }

    /**
     * 字符串时间类型转日历
     *
     * @return
     */
    public static Calendar getCalendar(String dateTime) {
        Calendar calendar = Calendar.getInstance();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = sdf.parse(dateTime);
            calendar.setTime(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return calendar;
    }

    public static String format(Long time) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(new Date(time));
    }


    /**
     * 获取距离当天结束时间
     *
     * @return
     */
    public static int endOfDayTime() {
        Long expTime = null;
        try {
            DateTime nowTime = new DateTime();
            DateTime endOfDay = nowTime.millisOfDay().withMaximumValue();
            Long millis = endOfDay.getMillis() - nowTime.getMillis();
            expTime = millis / 1000;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return expTime.intValue();
    }

    /**
     * 获取过去第几天的日期
     *
     * @param past
     * @return
     */
    public static String getPastDate(int past) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);
        Date today = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(today);
    }

    /**
     * 宜春润达专用 reqdate
     * @return
     */
    public static String getCurrentDateYcRd() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date();
        return sdf.format(date);
    }

    /**
     * 宜春润达专用 reqtime
     * @return
     */
    public static String getCurrentTimeYcRd() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        return sdf.format(date).replace(":","");
    }
}
