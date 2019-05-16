package com.newroad.common.device.uaparsejs;


import com.newroad.common.device.uaparsejs.domain.DeviceEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * 设备解析算法
 * Created by jackical on 2017/10/25.
 */

public class DeviceExtParser
{
    private static final Logger logger = LoggerFactory.getLogger(DeviceExtParser.class);

    private final List<DevicePattern> patterns;

    public DeviceExtParser(List<DevicePattern> patterns) {
        this.patterns = patterns;
    }

    public static DeviceExtParser fromList(List<Map<String,String>> configList) {
        List<DevicePattern> configPatterns = new ArrayList<DevicePattern>();

        for (Map<String, String> configMap : configList) {
            configPatterns.add(patternFromMap(configMap));
        }
        return new DeviceExtParser(configPatterns);
    }

    public DeviceEntity parse(String agentString) {
        if (agentString == null) {
            return null;
        }

        DeviceEntity deviceEntity=null;
        for (DevicePattern p : patterns) {
            deviceEntity = p.createDeviceEntity(agentString);
            if (deviceEntity!=null)  {
                //logger.info("UA="+agentString+",DeviceRegex="+p.getRegexContent());
                //deviceEntity.setRegexContent(p.getRegexContent());
                return deviceEntity;
            }
        }
        return deviceEntity;
    }

    public String parseInfo(String agentString) {
        if (agentString == null) {
            return null;
        }

        String result=null;
        for (DevicePattern p : patterns) {
            result = p.createDeviceInfo(agentString);
            if (!"null&null".equals(result))  {
                return result;
            }
        }
        return result;
    }

    protected static DevicePattern patternFromMap(Map<String, String> configMap) {
        String regex = configMap.get("regex");
        if (regex == null) {
            throw new IllegalArgumentException("User agent is missing regex");
        }

        return(new DevicePattern(Pattern.compile(regex),
                configMap.get("args"),
                configMap.get("value")));
    }

}
