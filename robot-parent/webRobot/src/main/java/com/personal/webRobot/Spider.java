package com.personal.webRobot;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Spider {

    public static void main(String [] arts){
//        System.out.println("Hello world");
        Spider spider = new Spider();
//        String url = "http://www.baidu.com";
//        spider.urlConnect(url);
//        spider.downloadImg("http://a2.att.hudong.com/65/10/01300000405561124504109556150.jpg");
        /*File f = new File("D:\\img\\33817.html?uid=432006");
        FileOutputStream fos  = null;
        try {
            fos = new FileOutputStream(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(fos.toString());*/


    }
    public void  urlConnect(String url){
        try{
            URL urlConnect = new URL(url);
            String page;
            StringBuffer pageBuffer = new StringBuffer();
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnect.openStream()));
            while ((page=reader.readLine()) != null){
                pageBuffer.append(page);
            }
            System.out.println(pageBuffer.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }



}
