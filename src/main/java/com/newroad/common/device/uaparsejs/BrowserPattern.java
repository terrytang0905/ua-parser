package com.newroad.common.device.uaparsejs;

import com.newroad.common.device.uaparsejs.domain.BrowserEntity;
import com.newroad.common.device.util.CompositeV2;
import com.newroad.common.device.util.ObjectUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zhenjietang on 8/11/2017.
 */
public class BrowserPattern extends UACorePattern
{
  private Map<String,String> browserMap;

  public BrowserPattern(Pattern pattern, String args, String value)
  {
    super(pattern, args, value);

    browserMap=new HashMap<String, String>();

    browserMap.put("/8","1.0");
    browserMap.put("/1","1.2");
    browserMap.put("/3","1.3");
    browserMap.put("/412","2.0");
    browserMap.put("/416","2.0.2");
    browserMap.put("/417","2.0.3");
    browserMap.put("/419","2.0.4");
    browserMap.put("/","?");
  }

  public BrowserEntity createBrowserEntity(String agentString){
    CompositeV2<String,String> browserComposite=regexMatchCompositeV2(agentString, "NAME","VERSION");
    if(ObjectUtils.isNullOrEmpty(browserComposite)){
      return null;
    }
    return BrowserEntity.buildBrowserEntity(browserComposite.first,browserComposite.second);
  }

  public String createBrowserInfo(String agentString){
    return regexMatch(agentString,"NAME","VERSION");
  }

  /**
   * 匹配映射关系
   * @param defVal
   * @param matchVal
   * @return
   */
  @Override
  public String MappingData(String defVal,String matchVal)
  {
    if(defVal.contains("maps.browser.oldsafari"))
    {
      if(browserMap.keySet().contains(matchVal))
      {
        return browserMap.get(matchVal);
      }
    }else if(defVal.contains("正则"))
    {
      //// 需要进一步解析
      Pattern pattern = Pattern.compile(defVal.replace("正则",""));
      Matcher matcher =pattern.matcher(matchVal);
      if(matcher.find() )
      {
        if (matcher.groupCount()>1)
        {
          return matcher.group(1)+" "+matcher.group(2);
        }
        else if(matcher.groupCount()>0)
        {
          return matcher.group(1);
        }
      }
    }

    return matchVal;
  }

  @Override
  public String MappingDataKey(String defVal, String matchVal)
  {
    return null;
  }

  @Override
  public String MappingDataKey2(String defVal, String matchVal)
  {
    return null;
  }
}
