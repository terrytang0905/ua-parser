package com.newroad.common.device.task;

import com.newroad.common.device.uaparsejs.UAExtParser;
import com.newroad.common.device.uaparsejs.domain.DeviceEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

/**
 * Created by zhenjietang on 14/11/2017.
 */
public class UADeviceParseTask implements Callable<DeviceEntity>
{
  private static final Logger logger = LoggerFactory.getLogger(UADeviceParseTask.class);

  private static String UA_DEVICE_PARSE_TASK="uaDeviceParseTask-";
  private UAExtParser uaParser;
  private String userAgent;
  private CountDownLatch end;

  public UADeviceParseTask(UAExtParser uaParser, String userAgent, CountDownLatch end){
    this.uaParser=uaParser;
    this.userAgent=userAgent;
    this.end=end;
  }

  @Override
  public DeviceEntity call() throws Exception
  {
    DeviceEntity deviceEntity=null;
    try {
      deviceEntity=uaParser.parseDeviceExt(userAgent);
    } finally {
      // 每个选手到达终点时，end就减一
      end.countDown();
    }
    return deviceEntity;
  }

}
