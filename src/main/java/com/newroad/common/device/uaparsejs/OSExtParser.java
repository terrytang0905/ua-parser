package com.newroad.common.device.uaparsejs;

import com.newroad.common.device.uaparsejs.domain.OSEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * OS解析算法
 * Created by jackical on 2017/10/25.
 */
public class OSExtParser
{

    private static final Logger logger = LoggerFactory.getLogger(OSExtParser.class);

    private final List<OSPattern> patterns;

    public OSExtParser(List<OSPattern> patterns) {
        this.patterns = patterns;
    }

    public static OSExtParser fromList(List<Map<String,String>> configList) {
        List<OSPattern> configPatterns = new ArrayList<OSPattern>();

        for (Map<String,String> configMap : configList) {
            configPatterns.add(patternFromMap(configMap));
        }
        return new OSExtParser(configPatterns);
    }

    public OSEntity parse(String agentString) {
        if (agentString == null) {
            return null;
        }

        OSEntity os=null;
        for (OSPattern p : patterns) {
            os = p.createOSEntity(agentString);
            if (os!=null) {
                //logger.info("UA="+agentString+",OSRegex="+p.getRegexContent());
                //os.setRegexContent(p.getRegexContent());
                return os;
            }
        }
        return os;
    }

    public String parseInfo(String agentString) {
        if (agentString == null) {
            return null;
        }

        String result=null;
        for (OSPattern p : patterns) {
            result = p.createOSInfo(agentString);
            if (!"null&null".equals(result)) {
                //logger.info("UA="+agentString+",OSRegex="+p.getRegexContent());
                //os.setRegexContent(p.getRegexContent());
                return result;
            }
        }
        return result;
    }

    protected static OSPattern patternFromMap(Map<String, String> configMap) {
        String regex = configMap.get("regex");
        if (regex == null) {
            throw new IllegalArgumentException("OS is missing regex");
        }

        return(new OSPattern(Pattern.compile(regex),
                configMap.get("args"),
                configMap.get("value")));
    }

}
