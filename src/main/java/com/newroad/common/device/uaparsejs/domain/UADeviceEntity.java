package com.newroad.common.device.uaparsejs.domain;

/**
 * Created by zhenjietang on 15/11/2017.
 */
public class UADeviceEntity
{
  private Integer devType;
  private OSEntity osEntity;
  private DeviceEntity deviceEntity;
  private BrowserEntity browserEntity;

  public static UADeviceEntity buildUADeviceEntity(
      OSEntity osEntity,
      DeviceEntity deviceEntity,
      BrowserEntity browserEntity
  )
  {
    UADeviceEntity uaDeviceEntity = new UADeviceEntity();
    uaDeviceEntity.setOsEntity(osEntity==null?new OSEntity():osEntity);
    uaDeviceEntity.setDeviceEntity(deviceEntity==null?new DeviceEntity():deviceEntity);
    uaDeviceEntity.setBrowserEntity(browserEntity==null?new BrowserEntity():browserEntity);
    uaDeviceEntity.addDevType();
    return uaDeviceEntity;
  }

  public OSEntity getOsEntity()
  {
    return osEntity;
  }

  public void setOsEntity(OSEntity osEntity)
  {
    this.osEntity = osEntity;
  }

  public DeviceEntity getDeviceEntity()
  {
    return deviceEntity;
  }

  public void setDeviceEntity(DeviceEntity deviceEntity)
  {
    this.deviceEntity = deviceEntity;
  }

  public BrowserEntity getBrowserEntity()
  {
    return browserEntity;
  }

  public void setBrowserEntity(BrowserEntity browserEntity)
  {
    this.browserEntity = browserEntity;
  }

  public String getOSRegexContent(){
    return osEntity.getRegexContent();
  }

  public String getDeviceRegexContent(){
    return deviceEntity.getRegexContent();
  }

  public String getBrowserRegexContent(){
    return browserEntity.getRegexContent();
  }

  public Integer getDevType()
  {
    return devType;
  }

  public void addDevType(){
    String osName=osEntity.getName();
    String devVendor=deviceEntity.getVendor();
    String browser=browserEntity.getName();
    if(devVendor!=null&&("OTV".equalsIgnoreCase(devVendor))) {
      //otv
      this.devType = 4;
    }else if(osName!=null&&"Android".equalsIgnoreCase(osName)){
      //aos
      this.devType=1;
    }else if(osName!=null&&"iOS".equalsIgnoreCase(osName)){
      //ios
      this.devType=2;
    }else if(devVendor!=null&&"Apple".equalsIgnoreCase(devVendor)){
      //ios
      this.devType=2;
      osEntity.setName("iOS");
    } else if(osName!=null&&("Windows".equalsIgnoreCase(osName)||"Mac OS".equalsIgnoreCase(osName)
             ||"Linux".equalsIgnoreCase(osName))){
      //pc
      this.devType=3;
    } else if(browserEntity!=null&&("WeChat".equalsIgnoreCase(browser)||"MQQBrowser".equalsIgnoreCase(browser)
      ||"UCWEB".equalsIgnoreCase(browser))){
      this.devType=6;
    } else{
      //others
      this.devType=0;
    }
  }

  public static String buildStrUADeviceEntity(
      String osEntity,
      String deviceEntity,
      String browserEntity
  )
  {
    String[] osArray=osEntity.split("&");
    String[] deviceArray=deviceEntity.split("&");
    String[] browserArray=browserEntity.split("&");
    return createDevType(osArray[0],deviceArray[0],browserArray[0])+"&"+osEntity+"&"+deviceEntity+"&"+browserEntity;
  }


  public static Integer createDevType(String osName,String devVendor, String browser){
    Integer devType=0;
    if(osName!=null&&"Android".equalsIgnoreCase(osName)){
      //aos
      devType=1;
    }else if(osName!=null&&"iOS".equalsIgnoreCase(osName)){
      //ios
      devType=2;
    }else if(devVendor!=null&&"Apple".equalsIgnoreCase(devVendor)){
      //ios
      devType=2;
    } else if(osName!=null&&("Windows".equalsIgnoreCase(osName)||"Mac OS".equalsIgnoreCase(osName)
                             ||"Linux".equalsIgnoreCase(osName))){
      //pc
      devType=3;
    } else if(browser!=null&&("WeChat".equalsIgnoreCase(browser)||"MQQBrowser".equalsIgnoreCase(browser)
                                    ||"UCWEB".equalsIgnoreCase(browser))){
      devType=6;
    }
    return devType;
  }

  @Override
  public String toString(){
    return devType+"&"+osEntity+"&"+deviceEntity+"&"+browserEntity;
  }
}
