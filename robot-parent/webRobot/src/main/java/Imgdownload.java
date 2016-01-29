import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by WS on 2016/1/20.
 */
public class Imgdownload {

    public void downloadImg(String url){
        InputStream imgInputStream = null;
        FileOutputStream fos = null;
        try{
            String imgPath = "D:\\img1\\";
            URL imgUrl = new URL(url);
            imgInputStream = imgUrl.openStream();
            System.out.println(url);
            String fileName = url.substring(url.lastIndexOf("/") + 1,url.length());
            File f = new File(imgPath + fileName);
            fos = new FileOutputStream(f);
            int length= 0;
            byte [] b = new byte[1024];
            while ((length = imgInputStream.read(b,0,b.length)) != -1){
                fos.write(b,0,length);
            }
            fos.flush();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                imgInputStream.close();
                fos.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
