package com.newroad.common.device.uaparsejs.domain;

/**
 * 设备OS对象Entity
 * Created by zhenjietang on 2017/10/25.
 */
public class OSEntity {

    private String name=null;
    private String version=null;
    private Integer type=0;
    private String regexContent=null;

    public static OSEntity buildOSEntity(String name,String version){
        OSEntity osEntity=new OSEntity();
        osEntity.setName(name);
        osEntity.setVersion(version);
        return osEntity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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
        return name + "&" +version;
    }
}
