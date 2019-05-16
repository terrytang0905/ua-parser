package com.newroad.common.device.executor;

/**
 * Created by jackical on 2017/10/23.
 */
public class UAParserMainExecutor
{

  public static void main(String[] args)
  {
    //String uaString ="Mozilla/5.0 (Windows; U; Windows NT 5.1; de-CH) AppleWebKit/523.15 (KHTML, like Gecko, Safari/419.3) Arora/0.2";
    //"Mozilla/5.0 (iPhone; CPU iPhone OS 5_1_1 like Mac OS X) AppleWebKit/534.46 (KHTML, like Gecko) Version/5.1 Mobile/9B206 Safari/7534.48.3";
    //String uaString1 = "Dalvik/2.1.0 (Linux; U; Android 6.0; NEM-UL10 Build/HONORNEM-UL10)";

    String uaString2 = "Mozilla/5.0 (Linux; Android 4.2.2; Coolpad+5872 Build/Coolpad+5872) AppleWebKit/534.24 (KHTML, like Gecko) Version/4.0 Chrome/43.0.2357.121 Mobile Safari/534.24";

    String uaString3 = "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1) QQBrowser/6.0";

    String uaString4 = "0:Dalvik/2.1.0 (Linux; U; Android 7.1.2; Redmi Note 5A MIUI/V8.5.10.0.NDFCNED)";

    String uaString41= "0:Dalvik/2.1.0 (Linux; U; Android 5.1; m2 Build/LMY47D)";

    String uaString42= "0:Mozilla/5.0 (Linux; Android 5.1.1; vivo Y31A Build/LMY47V; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/53.0.2785.49 Mobile MQQBrowser/6.2";

    String uaString43= "0:AndroidDownloadManager/6.0 (Linux; U; Android 6.0; Redmi Note 4X Build/MRA58K)";

    String uaString44= "0:Android51-AndroidPhone-8921-238-0-CloudMusic-wifi";

    String uaString45= "0:Dalvik/2.1.0 (Linux; U; Android 7.1.1; PRO 6 Build/NMF26O)";

    String uaString5 = "0:IPhone-8100-IPhone-8100-cscc";

    String uaString6 = "0:MicroMessenger Client";

    String uaString7 = "0:JD4iPhone/155455 (iPhone; iOS 11.0.3; Scale/2.00)";

    String uaString8 = "0:UCWEB";

    String uaString9 = "0:Youku HD;6.2.0;iOS;11.0.3;iPad6,11";

    String uaString10 = "0:iPad3,4/10.3.3 (14G60)";

    String uaString11 = "0:okhttp/3.3.0";

    String uaString12 = "0:SOHUVideo/6.8.8.0.1 CFNetwork/889.9 Darwin/17.2.0";

    String uaString13 = "0:AlipayClient";

    String uaString14= "0:Post_Multipart";

    String uaString15="0:Alipay/10.1.5.102407 iOS/11.0.3";

    String uaString18="(Windows; U; Windows NT 5.1; zh-CN; rv:1.9.2)";
    String uaString19="(compatible; MSIE 5.00; Windows 98)";
    String uaString20="(compatible; MSIE 6.0; Windows NT 5.1)";
    String uaString21="(Windows NT 6.1; WOW64)";
    String uaString22="(X11; Linux x86_64)";
    String uaString23="(SMART-TV; Linux; Tizen 2.4.0)";
    String uaString24="(iPad; CPU OS 9_3_5 like Mac OS X)";
    String uaString25="(QSP; Android TV; AP; 2.8.3.183)";
    String uaString26="(QSP; Roku; AP; 2.8.6.133)";
    String uaString27="(SmartHub; SMART-TV; U; Linux/SmartTV+2013; Maple2012)";

    String uaString28="(TVM xx; YunOS 3.0; Linux; U; Android 4.4.4 Compatible; VOTO GT7 Build/KTU84P)";
    String uaString29="(Linux; Android 5.0.2; vivo Y51A Build/LRX22G; wv)";
    String uaString30="Linux; U; Android 4.4.3; 43PFF5021 Build/KTU84M";
    String uaString31="0:Mozilla/5.0 (Linux; U; Android 5.1; zh-cn; OPPO R9tm Build/LMY47I) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/38.0.2125.114 Mobile Safari/537.36 OppoBrowser/3.8.5";

    UAParserSimpleUDF uaParserSimpleUDF = new UAParserSimpleUDF();

    long start = System.currentTimeMillis();

//    System.out.println(uaParserSimpleUDF.evaluate(uaString1,0));
    System.out.println(uaParserSimpleUDF.evaluate(uaString31,0));
//    System.out.println(uaParserSimpleUDF.evaluate(uaString3,0));
//    System.out.println(uaParserSimpleUDF.evaluate(uaString4,0));
//    System.out.println(uaParserSimpleUDF.evaluate(uaString41,0));
//    System.out.println(uaParserSimpleUDF.evaluate(uaString42,0));
//    System.out.println(uaParserSimpleUDF.evaluate(uaString43,0));
//    System.out.println(uaParserSimpleUDF.evaluate(uaString44,0));
//    System.out.println(uaParserSimpleUDF.evaluate(uaString45,0));
//    System.out.println(uaParserSimpleUDF.evaluate(uaString5,0));
//    System.out.println(uaParserSimpleUDF.evaluate(uaString6,0));
//    System.out.println(uaParserSimpleUDF.evaluate(uaString7,0));
//    System.out.println(uaParserSimpleUDF.evaluate(uaString8,0));
//    System.out.println(uaParserSimpleUDF.evaluate(uaString9,0));
//    System.out.println(uaParserSimpleUDF.evaluate(uaString10,0));
//    System.out.println(uaParserSimpleUDF.evaluate(uaString11,0));
//    System.out.println(uaParserSimpleUDF.evaluate(uaString12,0));
//    System.out.println(uaParserSimpleUDF.evaluate(uaString13,0));
//    System.out.println(uaParserSimpleUDF.evaluate(uaString14,0));
//    System.out.println(uaParserSimpleUDF.evaluate(uaString15,0));


    System.out.println(uaParserSimpleUDF.evaluate(uaString18,0));
    System.out.println(uaParserSimpleUDF.evaluate(uaString19,0));
    System.out.println(uaParserSimpleUDF.evaluate(uaString20,0));
    System.out.println(uaParserSimpleUDF.evaluate(uaString21,0));
    System.out.println(uaParserSimpleUDF.evaluate(uaString22,0));
    System.out.println(uaParserSimpleUDF.evaluate(uaString23,0));
    System.out.println(uaParserSimpleUDF.evaluate(uaString24,0));
    System.out.println(uaParserSimpleUDF.evaluate(uaString25,0));
    System.out.println(uaParserSimpleUDF.evaluate(uaString26,0));
    System.out.println(uaParserSimpleUDF.evaluate(uaString27,0));
    System.out.println(uaParserSimpleUDF.evaluate(uaString28,0));
    System.out.println(uaParserSimpleUDF.evaluate(uaString29,0));
    System.out.println(uaParserSimpleUDF.evaluate(uaString30,0));

    long end = System.currentTimeMillis() - start;

    System.out.println("ExecuteTime:" + end);

//        FileReader fr = null;
//        FileWriter fw = null;
//        BufferedReader br = null;
//        BufferedWriter bw = null;
//        DeviceUAParserTaskProcess deviceUAParserTaskProcess=new DeviceUAParserTaskProcess();
//        try {
//            fr = new FileReader("/Users/zhenjietang/Downloads/ua_sample.txt");
//            fw = new FileWriter("/Users/zhenjietang/Downloads/ua_result.txt");
//            br = new BufferedReader (fr);
//            bw = new BufferedWriter(fw);
//            String ua;
//            while ((ua = br.readLine() )!=null) {
//                UADeviceEntity uaDeviceEntity=deviceUAParserTaskProcess.parseRouteUADevice(ua);
//                bw.write(uaDeviceEntity.toString()+"       \n");
//            }
//        }
//        catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }
//        finally {
//            try {
//                br.close();
//                bw.close();
//                fr.close();
//                fw.close();
//            }
//            catch (IOException e) {
//                e.printStackTrace();
//            }
//        }


  }
}
