package com.newroad.common.device.route.domain;

import com.newroad.common.device.uaparsejs.domain.BrowserEntity;
import com.newroad.common.device.uaparsejs.domain.DeviceEntity;
import com.newroad.common.device.uaparsejs.domain.OSEntity;

/**
 * Created by zhenjietang on 10/11/2017.
 */
public class RouteMacDeviceInfo
{
  private String rid;
  private String mac;
  private Integer route;
  private Integer devType;
  private String devBrand;
  private String devModel;
  private String osName;
  private String osVersion;
  private String browser;
  private String broVersion;
  //http=UA or dns
  private String source;

  public static RouteMacDeviceInfo buildRouteMacDeviceInfo(String rid, String mac, OSEntity osEntity, DeviceEntity deviceEntity, BrowserEntity browserEntity,String source){
    RouteMacDeviceInfo routeMacDeviceInfo=new RouteMacDeviceInfo();
    routeMacDeviceInfo.setRid(rid);
    routeMacDeviceInfo.setMac(mac);
    routeMacDeviceInfo.setRoute(0);
    routeMacDeviceInfo.setDevType(osEntity.getType());
    routeMacDeviceInfo.setOsName(osEntity.getName());
    routeMacDeviceInfo.setOsVersion(osEntity.getVersion());
    routeMacDeviceInfo.setDevBrand(deviceEntity.getVendor());
    routeMacDeviceInfo.setDevModel(deviceEntity.getModel());

    routeMacDeviceInfo.setBrowser(browserEntity.getName());
    routeMacDeviceInfo.setBroVersion(browserEntity.getVersion());
    if(deviceEntity==null&&osEntity==null&&browserEntity==null){
      routeMacDeviceInfo.setSource(source);
    }
    return routeMacDeviceInfo;
  }

  public String getRid()
  {
    return rid;
  }

  public void setRid(String rid)
  {
    this.rid = rid;
  }

  public String getMac()
  {
    return mac;
  }

  public void setMac(String mac)
  {
    this.mac = mac;
  }

  public Integer getRoute()
  {
    return route;
  }

  public void setRoute(Integer route)
  {
    this.route = route;
  }

  public Integer getDevType()
  {
    return devType;
  }

  public void setDevType(Integer devType)
  {
    this.devType = devType;
  }

  public String getDevBrand()
  {
    return devBrand;
  }

  public void setDevBrand(String devBrand)
  {
    this.devBrand = devBrand;
  }

  public String getDevModel()
  {
    return devModel;
  }

  public void setDevModel(String devModel)
  {
    this.devModel = devModel;
  }

  public String getOsName()
  {
    return osName;
  }

  public void setOsName(String osName)
  {
    this.osName = osName;
  }

  public String getOsVersion()
  {
    return osVersion;
  }

  public void setOsVersion(String osVersion)
  {
    this.osVersion = osVersion;
  }

  public String getBrowser()
  {
    return browser;
  }

  public void setBrowser(String browser)
  {
    this.browser = browser;
  }

  public String getBroVersion()
  {
    return broVersion;
  }

  public void setBroVersion(String broVersion)
  {
    this.broVersion = broVersion;
  }

  public String getSource()
  {
    return source;
  }

  public void setSource(String source)
  {
    this.source = source;
  }

  @Override
  public String toString(){
    return "RouteMacDeviceInfo{" +
           "rid=" + rid +
           ", mac=" + mac +
           ", route=" + route +
           ", devType=" + devType +
           ", osName=" + osName +
           ", osVersion=" + osVersion +
           ", devBrand=" + devBrand +
           ", devModel=" + devModel +
           ", browser=" + browser +
           ", broVersion=" + broVersion +
           ", source=" + source +
           '}';
  }
}
