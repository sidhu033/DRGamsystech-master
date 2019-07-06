/*
 * Siddhu
 */

package com.example.user.drgamsystech.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimeFormater
{
    //to get current time
    public static String getCurrentTime()
    {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("h:mm:ss a");
        String time = simpleDateFormat.format(Calendar.getInstance().getTime());
        return time;
    }

    //to get formated date
    public static String getFormatedDate(Date dateNew)
    {
        SimpleDateFormat curFormater = new SimpleDateFormat("dd/MM/yyyy");
        String selectedDate = curFormater.format(dateNew);
        return selectedDate;
    }

    //to get total time
    public static long getTotalTime(String startTime)
    {
        SimpleDateFormat curFormater = new SimpleDateFormat("h:mm:ss a");
        String currentTime = getCurrentTime();

        long time = 0;
        try {
            Date sTime = curFormater.parse(startTime);
            Date cTime = curFormater.parse(currentTime);

            long dif = cTime.getTime() - sTime.getTime();
            time = (long) (dif / 1000);
        } catch (ParseException e)
        {
            e.printStackTrace();
        }
        return time;
    }

    //to get to date
    public static Date stringTodate(String datestr)
    {
        SimpleDateFormat curFormater = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date date = curFormater.parse(datestr);
            return date;
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
}
