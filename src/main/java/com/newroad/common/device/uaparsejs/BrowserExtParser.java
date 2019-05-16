package com.newroad.common.device.uaparsejs;

import com.newroad.common.device.uaparsejs.domain.BrowserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by jackical on 2017/11/8.
 */
public class BrowserExtParser {

    private static final Logger logger = LoggerFactory.getLogger(BrowserExtParser.class);

    private final List<BrowserPattern> patterns;

    public BrowserExtParser(List<BrowserPattern> patterns) {
        this.patterns = patterns;
    }

    public static BrowserExtParser fromList(List<Map<String,String>> configList) {
        List<BrowserPattern> configPatterns = new ArrayList<BrowserPattern>();

        for (Map<String, String> configMap : configList) {
            configPatterns.add(patternFromMap(configMap));
        }
        return new BrowserExtParser(configPatterns);
    }

    public BrowserEntity parse(String agentString) {
        if (agentString == null) {
            return null;
        }

        BrowserEntity browserEntity=null;
        for (BrowserPattern p : patterns) {
            browserEntity = p.createBrowserEntity(agentString);
            if (browserEntity!=null) {
                //browserEntity.setRegexContent(p.getRegexContent());
                return browserEntity;
            }
        }
        return browserEntity;
    }

    public String parseInfo(String agentString) {
        if (agentString == null) {
            return null;
        }

        String result=null;
        for (BrowserPattern p : patterns) {
            result = p.createBrowserInfo(agentString);
            if (!"null&null".equals(result))  {
                return result;
            }
        }
        return result;
    }

    protected static BrowserPattern patternFromMap(Map<String, String> configMap) {
        String regex = configMap.get("regex");
        if (regex == null) {
            throw new IllegalArgumentException("User agent is missing regex");
        }

        return(new BrowserPattern(Pattern.compile(regex),
                configMap.get("args"),
                configMap.get("value")));
    }

}
