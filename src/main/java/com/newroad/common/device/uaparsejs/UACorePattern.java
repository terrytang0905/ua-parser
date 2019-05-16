package com.newroad.common.device.uaparsejs;

import com.newroad.common.device.util.Util;
import com.newroad.common.device.util.CompositeV2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zhenjietang on 8/11/2017.
 */
public abstract class UACorePattern
{
    protected Pattern pattern;
    protected String args,value;


    public UACorePattern(Pattern pattern, String args, String value){
        this.pattern=pattern;
        this.args=args;
        this.value=value;
    }

    private String[] uaRegexMatch(String ua){
        String group1="null";
        String group2="null";
        Matcher uaMatch = pattern.matcher(ua);
        if (uaMatch.find()) {
            if (uaMatch.groupCount() > 0)
                group1=uaMatch.group(1);
            if (uaMatch.groupCount() > 1)
                group2=uaMatch.group(2);
        }
        return new String[]{group1,group2};
    }

    public String regexMatch(String agentString,String NAME_KEY,String VALUE_KEY)
    {
        String[] matchers=uaRegexMatch(agentString);
        if(checkMatchResultExist(matchers[0])||checkMatchResultExist(matchers[1])) {
            String[] deepMatch=this.regexDeepMatch(matchers[0],matchers[1], NAME_KEY, VALUE_KEY);
            String first="".equals(deepMatch[0])?"null":deepMatch[0];
            String second="".equals(deepMatch[1])?"null":deepMatch[1];
            return first+"&"+second;
        }
        return "null&null";
    }

    public String regexMatch2(String agentString,String KEY,String KEY2)
    {
        String[] matchers=uaRegexMatch(agentString);
        if(checkMatchResultExist(matchers[0]) && checkMatchResultExist(matchers[1])) {
            String[] deepMatch2=this.regexDeepMatch2(matchers[0],matchers[1],KEY,KEY2);
            String first="".equals(deepMatch2[0])?"null":deepMatch2[0];
            String second="".equals(deepMatch2[1])?"null":deepMatch2[1];
            return first+"&"+second;
        }
        return "null&null";
    }

    public static boolean checkMatchResultExist(String group){
        return !"null".equals(group);
    }

    public CompositeV2<String,String> regexMatchCompositeV2(String agentString, String NAME_KEY, String VALUE_KEY)
    {
        String[] matchers=uaRegexMatch(agentString);
        if(checkMatchResultExist(matchers[0]) || checkMatchResultExist(matchers[1])) {
            String[] deepMatch = this.regexDeepMatch(matchers[0],matchers[1], NAME_KEY, VALUE_KEY);
            String first="".equals(deepMatch[0])?"null":deepMatch[0];
            String second="".equals(deepMatch[1])?"null":deepMatch[1];
            return new CompositeV2<String,String>(first,second);
        }
        return null;
    }

    public CompositeV2<String,String> regexMatch2CompositeV2(String agentString,String KEY,String KEY2)
    {
        String[] matchers=uaRegexMatch(agentString);
        if(checkMatchResultExist(matchers[0]) || checkMatchResultExist(matchers[1])) {
             String[] deepMatch2=this.regexDeepMatch2(matchers[0], matchers[1], KEY, KEY2);
             String first="".equals(deepMatch2[0])?"null":deepMatch2[0];
             String second="".equals(deepMatch2[1])?"null":deepMatch2[1];
             return new CompositeV2<String,String>(first,second);
        }
        return null;
    }

    private String[] regexDeepMatch(String group1,String group2,String NAME_KEY,String VALUE_KEY){
        //Matcher matcher = pattern.matcher(agentString);

        String strName=null;
        String strVersion=null;

        String[] strArgs= Util.split(args, ";");
        String[] strValue=Util.split(value,";");

        /**
         * 正则拆出两个值
         */

        //// 位置1，没有默认值
        if(checkMatchResultExist(group1) && strValue[0].equals("") && strArgs[0].equals(VALUE_KEY))
        {
            strVersion=group1;
        }
        //// 位置1，有默认值
        else if(checkMatchResultExist(group1) && !strValue[0].equals("") && strArgs[0].equals(VALUE_KEY))
        {
            strVersion=MappingData(strValue[0],group1);
        }

        if(checkMatchResultExist(group1) && strValue[0].equals("") && strArgs[0].equals(NAME_KEY))
        {
            strName=group1;
        } else if(checkMatchResultExist(group1) && !strValue[0].equals("") && strArgs[0].equals(NAME_KEY))
        {
            strName=strValue[0];
        }

        if(checkMatchResultExist(group1) && !strValue[1].equals("") && strArgs[1].equals(NAME_KEY))
        {
            strName=strValue[1];
        }

        //// 位置2，没有默认值
        if(checkMatchResultExist(group2) && strValue[1].equals("") && strArgs[1].equals(VALUE_KEY))
        {
            strVersion=group2;
        } //// 位置2，有默认值
        else if(checkMatchResultExist(group2) && !strValue[1].equals("") && strArgs[1].equals(VALUE_KEY))
        {
            strVersion=MappingData(strValue[1],group2);
        }

        if(checkMatchResultExist(group2) && strValue[1].equals("") && strArgs[1].equals(NAME_KEY))
        {
            strName=group2;
        } else if(checkMatchResultExist(group2) && !strValue[1].equals("") && strArgs[1].equals(NAME_KEY))
        {
            strName=strValue[1];
        }

        strVersion=Util.replaceUnderline(strVersion);

        return new String[]{strName,strVersion};
    }

    private String[] regexDeepMatch2(String group1,String group2,String KEY,String KEY2){
        //Matcher matcher = pattern.matcher(agentString);

        String strKey1=null;
        String strKey2=null;

        String[] strArgs= Util.split(this.args, ";");
        String[] strValue=Util.split(this.value,";");

        /**
         * 正则拆出两个值
         */

        //// 位置1，没有默认值
        if(checkMatchResultExist(group1) && strValue[0].equals("") && strArgs[0].equals(KEY2))
        {
            strKey2=group1;
        }else if(checkMatchResultExist(group1) && strValue[0].equals("") && strArgs[0].equals(KEY))
        {
            strKey1=group1;
        }
        //// 位置1，有默认值
        else if(checkMatchResultExist(group1) && !strValue[0].equals("") && strArgs[0].equals(KEY2))
        {
            strKey2= MappingDataKey2(strValue[0],group1);
        }else if(checkMatchResultExist(group1) && !strValue[0].equals("") && strArgs[0].equals(KEY))
        {
            strKey1=MappingDataKey(strValue[0],group1);
        }

        //// 位置2 有默认值，但位置2没有匹配数据
        if(checkMatchResultExist(group1) && !checkMatchResultExist(group2) && !strValue[1].equals("") && strArgs[1].equals(KEY))
        {
            strKey1=strValue[1];
        }else if(checkMatchResultExist(group1) && !checkMatchResultExist(group2) && !strValue[1].equals("") && strArgs[1].equals(KEY2))
        {
            strKey2=strValue[1];
        }

        //// 位置2，没有默认值
        if(checkMatchResultExist(group2) && strValue[1].equals("") && strArgs[1].equals(KEY2))
        {
            strKey2=group2;
        }else if(checkMatchResultExist(group2) && strValue[1].equals("") && strArgs[1].equals(KEY))
        {
            strKey1=group2;
        }
        //// 位置2，有默认值
        else if(checkMatchResultExist(group2) && !strValue[1].equals("") && strArgs[1].equals(KEY2))
        {
            strKey2=MappingDataKey2(strValue[1],group2);
        }
        else if(checkMatchResultExist(group2) && !strValue[1].equals("") && strArgs[1].equals(KEY))
        {
            strKey1=MappingDataKey(strValue[1],group2);
        }


        strKey2=Util.replaceUnderline(strKey2);

        return new String[]{strKey1,strKey2};
    }

    public abstract String MappingData(String defVal,String matchVal);

    public abstract String MappingDataKey(String defVal,String matchVal);

    public abstract String MappingDataKey2(String defVal,String matchVal);

    public String getRegexContent(){
        return pattern.pattern();
    }
}
