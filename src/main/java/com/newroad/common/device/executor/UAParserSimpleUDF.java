package com.newroad.common.device.executor;

import com.newroad.common.device.task.DeviceUAParserTaskProcess;
import org.apache.hadoop.hive.ql.exec.UDF;

/**
 * Created by zhenjie.tang on 2017/10/23.
 */
public class UAParserSimpleUDF extends UDF {

    /*
    获取UA设备解析数据
     */
    public String evaluate(String ua,Integer type)
    {
        DeviceUAParserTaskProcess deviceUAParserTask=new DeviceUAParserTaskProcess();
        switch (type){
            case 1:
                return deviceUAParserTask.parseStrOsTask(ua);
            case 2:
                return deviceUAParserTask.parseStrDeviceTask(ua);
            case 3:
                return deviceUAParserTask.parseStrBrowserTask(ua);
            default:
                return deviceUAParserTask.parseRouteUADevice(ua).toString();
        }
    }



}
