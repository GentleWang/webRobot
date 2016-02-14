package com.personal.webRobot;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;

/**
 * Created by WS on 2016/1/20.
 */
public class Imgdownload {

    public void downloadImg(String storePath,String url){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try{
           
            URL imgUrl = new URL(url);
            bis = new BufferedInputStream(imgUrl.openStream());
            System.out.println(url);
            
            String fileName = url.substring(url.lastIndexOf("/") + 1,url.length());
            File filePath = new File(storePath);
            if(!filePath.isDirectory()){
            	filePath.mkdir();
            }
            File f = new File(storePath + fileName);
            bos = new BufferedOutputStream(new FileOutputStream(f));
            int length= 0;
            byte [] b = new byte[1024];
            while ((length = bis.read(b,0,b.length)) != -1){
            	bos.write(b,0,length);
            }
            bos.flush();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
            	bis.close();
                bos.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
