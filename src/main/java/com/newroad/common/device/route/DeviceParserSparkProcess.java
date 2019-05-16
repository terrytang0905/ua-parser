
package com.newroad.common.device.route;

//import DeviceDateUtils;
//import org.apache.spark.api.java.JavaRDD;
//import org.apache.spark.api.java.function.Function;
//import org.apache.spark.api.java.function.MapFunction;
//import org.apache.spark.sql.Dataset;
//import org.apache.spark.sql.Encoders;
//import org.apache.spark.sql.Row;
//import org.apache.spark.sql.RowFactory;
//import org.apache.spark.sql.SparkSession;
//import org.apache.spark.sql.types.DataTypes;
//import org.apache.spark.sql.types.StructField;
//import org.apache.spark.sql.types.StructType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/*
 * Created by zhenjietang on 8/11/2017.
 * Spark数据处理-DeviceParser
 */


public class DeviceParserSparkProcess
{
  private Logger logger = LoggerFactory.getLogger(DeviceParserSparkProcess.class);

//  public void executeRouteDeviceDataFrame()
//  {
//    SparkSession spark = SparkSession
//        .builder()
//        .appName("RouteDeviceParser")
//        .config("spark.some.config.option", "some-value")
//        .enableHiveSupport()
//        .getOrCreate();
//
//    logger.info("Start xdb_mac_device_info data process...");
//    buildDeviceInfoByUA(spark);
//    //buildDeviceInfoByURL(spark);
//
//
//    //buildDeviceInfoByDNS(spark);
//  }
//
//  public void buildDeviceInfoByUA(SparkSession spark)
//  {
//    logger.info("Stage2:insert into xdb_mac_device_info by UA...");
//
//    List<StructField> fields = Arrays.asList(
//        DataTypes.createStructField("rid", DataTypes.StringType, true),
//        DataTypes.createStructField("mac", DataTypes.StringType, false),
//        DataTypes.createStructField("route", DataTypes.StringType, true),
//        DataTypes.createStructField("dev_type", DataTypes.IntegerType, true),
//        DataTypes.createStructField("dev_brand", DataTypes.StringType, true),
//        DataTypes.createStructField("dev_model", DataTypes.StringType, true),
//        DataTypes.createStructField("os_type", DataTypes.StringType, true),
//        DataTypes.createStructField("os_ver", DataTypes.StringType, true),
//        DataTypes.createStructField("browser", DataTypes.StringType, true),
//        DataTypes.createStructField("bro_ver", DataTypes.StringType, true),
//        DataTypes.createStructField("source", DataTypes.StringType, true)
//    );
//    StructType schema = DataTypes.createStructType(fields);
//
//    spark.sql("use dbr01_dpr");
//    Dataset<RouteMacDeviceInfo> deviceDataSet =
//        spark.read()
//                                 .orc(HDFSConstants.R01_ORG01_DEV_DAY_LOCATION)
//                                 .map(new MapFunction<Row, RouteMacDeviceInfo>(){
//                                       public RouteMacDeviceInfo call(Row row)
//                                       {
//                                         String rid = (String) row.get(0);
//                                         String mac = (String) row.get(1);
//                                         String ua = (String) row.get(2);
//
//                                         DeviceUAParserTaskProcess deviceUAParserTaskProcess = new DeviceUAParserTaskProcess();
//                                         UADeviceEntity uaDeviceEntity = null;
//                                             deviceUAParserTaskProcess
//                                             .parseRouteUADevice(ua);
//                                         return RouteMacDeviceInfo.buildRouteMacDeviceInfo(
//                                             rid,
//                                             mac,
//                                             uaDeviceEntity
//                                                 .getOsEntity(),
//                                             uaDeviceEntity
//                                                 .getDeviceEntity(),
//                                             uaDeviceEntity
//                                                 .getBrowserEntity(),
//                                             ua
//                                         );
//                                       }
//                                      }, Encoders.bean(RouteMacDeviceInfo.class)
//                                 );
//    //JavaRDD<Row> javaFile = orcFile.javaRDD();
//
//    //df.registerTempTable("xdb_mac_device_temp");
//    //df.saveAsTable() --仅支持parquet/text
//    //hiveContext.sql("INSERT INTO TABLE xdb_mac_device_info SELECT rid,mac,dev_type,dev_brand,"
//    //                + "dev_model,os_type,os_ver,browser,bro_ver,source FROM xdb_mac_device_temp;");
//    deviceDataSet.write().saveAsTable("tmp_xdb_mac_device_info");
//    logger.info("Stage2:finish xdb_mac_device_info update.");
//  }
//
//  public void buildDeviceInfoByURL(SparkSession spark)
//  {
//    logger.info("Stage3:insert into xdb_mac_device_info by URL...");
//
//    logger.info("Stage3:finish xdb_mac_device_info update 2.");
//  }
//
//  public void buildDeviceInfoByDNS(SparkSession spark)
//  {
//    logger.info("Stage4:insert into xdb_mac_device_info by DNS...");
//
//    logger.info("Stage4:finish xdb_mac_device_info update 3.");
//  }

}
