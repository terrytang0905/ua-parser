package com.newroad.common.device.task;

import com.newroad.common.device.uaparsejs.UAExtParser;
import com.newroad.common.device.uaparsejs.domain.BrowserEntity;
import com.newroad.common.device.uaparsejs.domain.DeviceEntity;
import com.newroad.common.device.uaparsejs.domain.OSEntity;
import com.newroad.common.device.uaparsejs.domain.UADeviceEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 设备UA解析并行处理任务
 * Created by zhenjietang on 14/11/2017.
 */
public class DeviceUAParserTaskProcess
{
  private static final Logger logger = LoggerFactory.getLogger(DeviceUAParserTaskProcess.class);

  private UAExtParser uaParser = null;

  public DeviceUAParserTaskProcess()
  {
    uaParser=UAExtParser.getInstance();
  }

  public OSEntity parseOsTask(String userAgent){
    return uaParser.parseOS(userAgent);
  }

  public String parseStrOsTask(String userAgent){
    return uaParser.parseStrOS(userAgent);
  }

  public DeviceEntity parseDeviceTask(String userAgent){
    return uaParser.parseDeviceExt(userAgent);
  }

  public String parseStrDeviceTask(String userAgent){
    return uaParser.parseStrDeviceExt(userAgent);
  }

  public BrowserEntity parseBrowserTask(String userAgent){
    return uaParser.parseBrowser(userAgent);
  }

  public String parseStrBrowserTask(String userAgent){
    return uaParser.parseStrBrowser(userAgent);
  }

  public UADeviceEntity parseRouteUADevice(String ua)
  {
    final CountDownLatch end = new CountDownLatch(3);
    final ExecutorService exec = Executors.newFixedThreadPool(3);
    List<Future<?>> uaResultList = new ArrayList<>();
    try {
      //long startTime=System.currentTimeMillis();
      UAOsParseTask uaOsParseTask = new UAOsParseTask(uaParser, ua, end);
      Future<OSEntity> osFuture = exec.submit(uaOsParseTask);
      uaResultList.add(osFuture);
      UADeviceParseTask uaDeviceParseTask = new UADeviceParseTask(uaParser, ua, end);
      Future<DeviceEntity> deviceFuture = exec.submit(uaDeviceParseTask);
      uaResultList.add(deviceFuture);
      UABrowserParseTask uaBrowserParseTask = new UABrowserParseTask(uaParser, ua, end);
      Future<BrowserEntity> browserFuture = exec.submit(uaBrowserParseTask);
      uaResultList.add(browserFuture);

      end.await(30,TimeUnit.MILLISECONDS);

      //long endTime=System.currentTimeMillis()-startTime;
      //System.out.println("ExecuteTime:"+endTime);
    }catch (InterruptedException e) {
      logger.error("uaParser running InterruptedException:",e);
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    finally {
      exec.shutdown();
    }

    OSEntity osEntity=new OSEntity();
    DeviceEntity deviceEntity=new DeviceEntity();
    BrowserEntity browserEntity=new BrowserEntity();
    try {
      osEntity = (OSEntity) uaResultList.get(0).get();
      deviceEntity = (DeviceEntity) uaResultList.get(1).get();
      browserEntity = (BrowserEntity) uaResultList.get(2).get();
    }
    catch (InterruptedException e) {
      logger.error("Get uaParser result InterruptedException:",e);
    }
    catch (ExecutionException e) {
      logger.error("Get uaParser result ExecutionException:",e);
    }finally {

    }
    return UADeviceEntity.buildUADeviceEntity(osEntity,deviceEntity,browserEntity);
  }

}
