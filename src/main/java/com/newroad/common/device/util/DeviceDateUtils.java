package com.newroad.common.device.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by zhenjietang on 14/11/2017.
 */
public class DeviceDateUtils
{

   public static String getCurrentDate(){
     SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
     return sdf.format(new Date());
   }

  public static String getYesterdayDate(){
    Calendar calendar=Calendar.getInstance();
    calendar.add(Calendar.DAY_OF_MONTH, -1);
    SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
    return sdf.format(calendar.getTime());
  }

  public static String getDayBeforeYestDate(){
    Calendar calendar=Calendar.getInstance();
    calendar.add( Calendar.DAY_OF_MONTH, -2);
    SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
    return sdf.format(calendar.getTime());
  }

  public static void main(String[] args){
     System.out.println(getCurrentDate());
   }
}
