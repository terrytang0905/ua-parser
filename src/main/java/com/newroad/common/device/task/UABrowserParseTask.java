package com.newroad.common.device.task;

import com.newroad.common.device.uaparsejs.UAExtParser;
import com.newroad.common.device.uaparsejs.domain.BrowserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

/**
 * Created by zhenjietang on 14/11/2017.
 */
public class UABrowserParseTask implements Callable<BrowserEntity>
{
  private static final Logger logger = LoggerFactory.getLogger(UABrowserParseTask.class);

  private static String UA_BROWSER_PARSE_TASK="uaBrowserParseTask-";
  private UAExtParser uaParser;
  private String userAgent;

  private CountDownLatch end;

  public UABrowserParseTask(UAExtParser uaParser, String userAgent, CountDownLatch end){
    this.uaParser=uaParser;
    this.userAgent=userAgent;
    this.end=end;
  }

  @Override
  public BrowserEntity call() throws Exception
  {
    BrowserEntity browserEntity=null;
    try {
      browserEntity=uaParser.parseBrowser(userAgent);
      //browserEntity=new BrowserEntity();
    } finally {
      // 每个选手到达终点时，end就减一
      end.countDown();
    }
    return browserEntity;
  }

}
