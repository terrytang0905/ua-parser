package com.newroad.common.device.task;

import com.newroad.common.device.uaparsejs.UAExtParser;
import com.newroad.common.device.uaparsejs.domain.OSEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

/**
 * Created by zhenjietang on 14/11/2017.
 */
public class UAOsParseTask implements Callable<OSEntity>
{
  private static final Logger logger = LoggerFactory.getLogger(UAOsParseTask.class);

  private static String UA_OS_PARSE_TASK = "uaOSParseTask-";
  private UAExtParser uaParser;
  private String userAgent;
  private CountDownLatch end;

  public UAOsParseTask(
      UAExtParser uaParser,
      String userAgent,
      CountDownLatch end
  )
  {
    this.uaParser = uaParser;
    this.userAgent = userAgent;
    this.end = end;
  }

  @Override
  public OSEntity call() throws Exception
  {
    OSEntity osEntity = null;
    try {
      osEntity = uaParser.parseOS(userAgent);
    }
    finally {
      // 每个选手到达终点时，end就减一
      end.countDown();
    }
    return osEntity;
  }
}
