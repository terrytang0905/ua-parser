package com.newroad.common.device.executor;

import com.newroad.common.device.uaparsejs.domain.UADeviceEntity;
import org.apache.hadoop.hive.ql.exec.UDF;

/**
 * Created by zhenjietang on 20/11/2017.
 */
public class DevTypeParserUDF extends UDF
{
  public String evaluate(Integer currentType,String osName, String devVendor, String browser)
  {
    Integer devType=0;
    if(currentType>0){
      devType=currentType;
    }else {
      devType = UADeviceEntity.createDevType(osName, devVendor, browser);
    }
    return String.valueOf(devType);
  }
}
