package com.newroad.common.device.uaparsejs.domain;

/**
 * 设备对象Entity
 * Created by jackical on 2017/10/25.
 */
public class DeviceEntity {

    private String vendor=null;
    private String model=null;
    private String regexContent=null;

    public static DeviceEntity buildDeviceEntity(String vendor,String model){
        DeviceEntity deviceEntity=new DeviceEntity();
        deviceEntity.setVendor(vendor);
        deviceEntity.setModel(model);
        return deviceEntity;
    }

    public Boolean isEmpty()
    {
        if(vendor.isEmpty() && model.isEmpty())
            return true;
        return false;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRegexContent()
    {
        return regexContent;
    }

    public void setRegexContent(String regexContent)
    {
        this.regexContent = regexContent;
    }

    @Override
    public String toString(){
        return vendor + "&" +model;
    }
}
