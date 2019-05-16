package com.newroad.common.device.uaparsejs.domain;

/**
 * Created by jackical on 2017/11/8.
 */
public class BrowserEntity {

    private String name=null;
    private String version=null;
    private String regexContent=null;

    public static BrowserEntity buildBrowserEntity(String name,String version){
        BrowserEntity browserEntity=new BrowserEntity();
        browserEntity.setName(name);
        browserEntity.setVersion(version);
        return browserEntity;
    }

    public Boolean isEmpty()
    {
        if(name.isEmpty() && version.isEmpty())
            return true;
        return false;
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
