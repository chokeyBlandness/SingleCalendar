package group.usst.singlecalendar.calendar.utils;

import java.util.Calendar;

/**
 * Created by Administrator on 2017/8/16.
 */

public class DateUtil {

    /**
     * get the last day of the current month
     * @return the number of the last day
     */
    public static int getCurrentMonthLastDay() {
        Calendar a = Calendar.getInstance();
        a.set(Calendar.DATE, 1);//把日期设置为当月第一天
        a.roll(Calendar.DATE, -1);//日期回滚一天，也就是最后一天
        int maxDate = a.get(Calendar.DATE);
        return maxDate;
    }

    /**
     * get the week number of the first day of current month
     * @return the week number
     */
    public static int getFirstDayOfMonth(){
        Calendar a = Calendar.getInstance();
        a.set(Calendar.DAY_OF_MONTH,1);
        return a.get(Calendar.DAY_OF_WEEK);
    }

    /**
     * get the month of the current date
     * @return the number of the month
     */
    public static int getCurrentMonth() {
        return Calendar.getInstance().get(Calendar.MONTH);
    }

    /**
     * get the year of the current date
     * @return the number of the year
     */
    public static int getCurrentYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }

    /**
     * get the day of the current date
     * @return the day number
     */
    public static int getCurrentDay(){
        return Calendar.getInstance().get(Calendar.DATE);
    }
}
