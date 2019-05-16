package com.newroad.common.device.uaparsejs;

import com.newroad.common.device.uaparsejs.domain.OSEntity;
import com.newroad.common.device.util.CompositeV2;
import com.newroad.common.device.util.ObjectUtils;

import java.util.regex.Pattern;

/**
 * Created by zhenjietang on 8/11/2017.
 */
public class OSPattern extends UACorePattern
{

  public OSPattern(Pattern pattern, String args, String value)
  {
    super(pattern, args, value);
  }

  public OSEntity createOSEntity(String agentString){
    CompositeV2<String,String> osComposite=regexMatchCompositeV2(agentString,"NAME","VERSION");
    if(ObjectUtils.isNullOrEmpty(osComposite)){
      return null;
    }
    return OSEntity.buildOSEntity(osComposite.first,osComposite.second);
  }

  public String createOSInfo(String agentString){
    return regexMatch(agentString,"NAME","VERSION");
  }

  @Override
  public String MappingData(String strVersion,String MappingData)
  {
    /// 脚本中 mapper.str 为方法，其后必然要跟一个字典，用来从字典中找到对应的值
    if(strVersion.contains("maps.os.windows") && "4.90".equalsIgnoreCase(MappingData))
    {
      strVersion="ME";
    }else if(strVersion.contains("maps.os.windows") && "NT3.51".equalsIgnoreCase(MappingData))
    {
      strVersion="NT 3.11";
    }else if(strVersion.contains("maps.os.windows") && "NT4.0".equalsIgnoreCase(MappingData))
    {
      strVersion="NT 4.0";
    }else if(strVersion.contains("maps.os.windows") && "NT 5.0".equalsIgnoreCase(MappingData))
    {
      strVersion="2000";
    }else if(strVersion.contains("maps.os.windows") && ("NT 5.1".equalsIgnoreCase(MappingData) ||"NT 5.2".equalsIgnoreCase(MappingData)))
    {
      strVersion="XP";
    }else if(strVersion.contains("maps.os.windows") && ("NT 6.0".equalsIgnoreCase(MappingData)))
    {
      strVersion="Vista";
    }else if(strVersion.contains("maps.os.windows") && ("NT 6.1".equalsIgnoreCase(MappingData)))
    {
      strVersion="7";
    }else if(strVersion.contains("maps.os.windows") && ("NT 6.2".equalsIgnoreCase(MappingData)))
    {
      strVersion="8";
    }else if(strVersion.contains("maps.os.windows") && ("NT 6.3".equalsIgnoreCase(MappingData)))
    {
      strVersion="8.1";
    }else if(strVersion.contains("maps.os.windows") && ("NT 6.4".equalsIgnoreCase(MappingData) || "NT 10.0".equalsIgnoreCase(MappingData)))
    {
      strVersion="10";
    }else if(strVersion.contains("maps.os.windows") && ("ARM".equalsIgnoreCase(MappingData)))
    {
      strVersion="RT";
    }else
    {
      strVersion=MappingData;
    }

    return strVersion;
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
