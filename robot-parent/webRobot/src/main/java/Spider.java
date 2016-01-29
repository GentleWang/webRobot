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
        spider.testTestPattern();
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

//        URLDigger urlDig =new URLDigger();
//        Set<String> set = urlDig.dig("https://www.hao123.com");
        /*Imgdownload imgdownload = new Imgdownload();

        Set<String> testSet = new HashSet<String>();
        testSet.add("https://gss1.bdstatic.com/5eN1dDebRNRTm2_p8IuM_a/res/r/image/2016-01-24/10b8bc53e3e9c616486b58a8b8d37681.jpg1");
        testSet.add("http://a2.att.hudong.com/65/10/01300000405561124504109556150.jpg1");
        Iterator it = testSet.iterator();
        while(it.hasNext()){
            imgdownload.downloadImg(it.next().toString());
        }*/
    }

    public void testTestPattern() {
        String url = "<a href=\"<img src=\"https://gss0.bdstatic.com/5eR1dDebRNRTm2_p8IuM_a/res/img/huawei160120.jpg\" width=\"278\" height=\"70\">qwqwwwqw";
        Pattern p = Pattern.compile("<img[^<]+src=\"([^\"]+)\"[^>]+>");
        Matcher matcher = p.matcher(url);
//        Pattern p1 = Pattern.compile("http(s*):\\\"?(.*?)(\\\"|>|\\\\s+)");
        while (matcher.find()) {
            String imgUrl = matcher.group(1);
            System.out.println(imgUrl);
//            Matcher matcher1 = p1.matcher(imgUrl);
//            System.out.println(matcher1.groupCount());
//            while(matcher1.find()){
//                System.out.println(matcher1.group());
//            }
        }
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
