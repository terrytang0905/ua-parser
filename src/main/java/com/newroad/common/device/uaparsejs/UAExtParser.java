package com.newroad.common.device.uaparsejs;

import com.newroad.common.device.uaparse.Device;
import com.newroad.common.device.uaparse.DeviceParser;
import com.newroad.common.device.uaparsejs.domain.BrowserEntity;
import com.newroad.common.device.uaparsejs.domain.DeviceEntity;
import com.newroad.common.device.uaparsejs.domain.OSEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.SafeConstructor;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * UA通用解析算法
 * Created by jackical on 2017/10/25.
 */
public class UAExtParser {

    private static final Logger logger = LoggerFactory.getLogger(UAExtParser.class);

    private static volatile UAExtParser instance = null;

    private static final String REGEX_YAML_PATH = "/regexes_lite.yaml";
    //OS解析
    private OSExtParser osParser;
    //UA解析
    private DeviceExtParser uaParser;
    //browser解析
    private BrowserExtParser browserParser;
    //old device解析
    private DeviceParser deviceParser;


    public static UAExtParser getInstance() {
       // if(instance == null) {
       //     synchronized(UAExtParser.class) {
                if (instance == null){
                    instance = new UAExtParser(UAExtParser.class.getResourceAsStream(REGEX_YAML_PATH));
                }
        //     }
        //}
        return instance;
    }

//    public UAExtParser() throws IOException {
//        this(UAExtParser.class.getResourceAsStream(REGEX_YAML_PATH));
//    }

    public UAExtParser(InputStream regexYaml) {
        initialize(regexYaml);
    }

    public DeviceEntity parseDeviceExt(String agentString) {
        return uaParser.parse(agentString);
    }

    public String parseStrDeviceExt(String agentString) {
        return uaParser.parseInfo(agentString);
    }

    public Device parseDevice(String agentString) {
        return deviceParser.parse(agentString);
    }

    public OSEntity parseOS(String agentString) {
        return osParser.parse(agentString);
    }

    public String parseStrOS(String agentString) {
        return osParser.parseInfo(agentString);
    }

    public BrowserEntity parseBrowser(String agentString) {
        return browserParser.parse(agentString);
    }

    public String parseStrBrowser(String agentString) {
        return browserParser.parseInfo(agentString);
    }


    private void initialize(InputStream regexYaml) {
        Yaml yaml = new Yaml(new SafeConstructor());
        @SuppressWarnings("unchecked")
        Map<String,List<Map<String,String>>> regexConfig = (Map<String,List<Map<String,String>>>) yaml.load(regexYaml);

        List<Map<String,String>> osParserConfigs = regexConfig.get("os");
        if (osParserConfigs == null) {
            throw new IllegalArgumentException("os_parsers is missing from yaml");
        }
        osParser = OSExtParser.fromList(osParserConfigs);

        List<Map<String,String>> uaParserConfigs = regexConfig.get("device");
        if (uaParserConfigs == null) {
            throw new IllegalArgumentException("user_agent_parsers is missing from yaml");
        }
        uaParser = DeviceExtParser.fromList(uaParserConfigs);

        List<Map<String,String>> browserParserConfigs = regexConfig.get("browser");
        if (browserParserConfigs == null) {
            throw new IllegalArgumentException("browser_parsers is missing from yaml");
        }
        browserParser = BrowserExtParser.fromList(browserParserConfigs);
    }

}
