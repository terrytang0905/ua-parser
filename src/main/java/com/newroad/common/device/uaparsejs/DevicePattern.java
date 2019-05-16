package com.newroad.common.device.uaparsejs;

import com.newroad.common.device.uaparsejs.domain.DeviceEntity;
import com.newroad.common.device.util.CompositeV2;
import com.newroad.common.device.util.ObjectUtils;

import java.util.regex.Pattern;

/**
 * Created by zhenjietang on 8/11/2017.
 */
public class DevicePattern extends UACorePattern
{
  public DevicePattern(Pattern pattern, String args, String value)
  {
    super(pattern, args, value);
  }

  public DeviceEntity createDeviceEntity(String agentString){
    CompositeV2<String,String> deviceComposite=regexMatch2CompositeV2(agentString, "VENDOR","MODEL");
    if(ObjectUtils.isNullOrEmpty(deviceComposite)){
      return null;
    }
    String vendor=deviceComposite.first;
    String model=deviceComposite.second;
    return DeviceEntity.buildDeviceEntity(vendor,model);
  }

  public String createDeviceInfo(String agentString){
    return regexMatch2(agentString,"VENDOR","MODEL");
  }

  /**
   * 匹配品牌映射关系
   * @param defVal
   * @param matchVal
   * @return
   */
  @Override
  public String MappingDataKey(String defVal,String matchVal)
  {
    if(defVal.contains("maps.device"))
    {
      matchVal=matchVal.replace("APA","HTC");
    }
    return defVal;
  }

  /**
   * 匹配型号映射关系
   * @param defVal
   * @param matchVal
   * @return
   */
  @Override
  public String MappingDataKey2(String defVal,String matchVal)
  {
    /// 脚本中 mapper.str 为方法，其后必然要跟一个字典，用来从字典中找到对应的值
    if(defVal.contains("maps.device.sprint.model"))
    {
      matchVal=matchVal.replace("7373KT","Evo Shift 4G");
    }else if(defVal.contains("maps.device.amazon.model") && "SD".equalsIgnoreCase(matchVal))
    {
      matchVal="Fire Phone";
    }else if(defVal.contains("maps.device.amazon.model") && "KF".equalsIgnoreCase(matchVal))
    {
      matchVal="Fire Phone";
    }

    return matchVal;
  }


  /**
   * 匹配品牌映射关系
   * @param defVal
   * @param matchVal
   * @return
   */
  @Override
  public String MappingData(String defVal,String matchVal)
  {
      return null;
  }
}
