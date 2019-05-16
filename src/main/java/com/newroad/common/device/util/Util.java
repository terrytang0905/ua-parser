package com.newroad.common.device.util;


/**
 * Created by jackical on 2017/10/25.
 */
public class Util {

    /**
     * 判断是否相等
     * @param str1
     * @param str2
     * @return
     */
    public static Boolean has(String str1, String str2)
    {
        if(str1.equals(str2))
            return true;
        return false;
    }

    /**
     * 转小写
     * @param str
     * @return
     */
    public static String lowerize(String str)
    {
        return str.toLowerCase();
    }

    /**
     * 仅保留数字与“.”
     * @param version
     * @return
     */
    public static String major(String version)
    {
        String strResult="";

        try{
            strResult=version.replaceAll("[^\\d.]","").split("\\.")[0];
        }catch(Exception e)
        {
            e.printStackTrace();
        }

        return strResult;
    }

    /**
     * 去除字符串中所有空格
     * @param str
     * @return
     */
    public static String trim(String str)
    {
        if(ObjectUtils.isNotNullOrEmpty(str))
            return str.replaceAll("[\\s\\uFEFF\\xA0]+|[\\s\\uFEFF\\xA0]+","");
        return "";
    }

    /**
     * 替换"_" 为 " "
     * @param strContent
     * @return
     */
    public static String replaceUnderline(String strContent)
    {
        if(ObjectUtils.isNotNullOrEmpty(strContent))
            return strContent.replaceAll("_"," ");
        return "";
    }

    /**
     * 根据源与"Mark"切割数据
     * @param strSource
     * @param splitMark
     * @return
     */
    public static String[] split(String strSource,String splitMark)
    {
        if(strSource.trim().length()==1)
            return new String[]{"",""};

        return strSource.split(splitMark,-1);
    }

}
