package com.newroad.common.device.route.enums;

/**
 * Created by zhenjietang on 13/11/2017.
 */
public enum RouteDeviceType
{
  aos(1,"aos"),
  ios(2,"ios"),
  pc(3,"pc"),
  otv(4,"otv"),
  blend(5,"blend"),
  other(0,"other");

  Integer code;
  String desc;

  RouteDeviceType(Integer code,String desc){
    this.code=code;
    this.desc=desc;
  }

  public static Integer getDeviceTypeCode(String devDesc){
    for(RouteDeviceType routeDeviceType:RouteDeviceType.values()){
      if(devDesc.equalsIgnoreCase(routeDeviceType.name())){
        return routeDeviceType.code;
      }
    }
    return -1;
  }


}
