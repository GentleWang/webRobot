import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by WS on 2016/1/20.
 */
public class URLDigger {

    public String  urlConnect(String url){

        try{
            URL urlConnect = new URL(url);
            String page;
            StringBuffer pageBuffer = new StringBuffer();
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnect.openStream()));
            while ((page=reader.readLine()) != null){
                pageBuffer.append(page);
            }
            url = pageBuffer.toString();
        }catch (Exception e){
            e.printStackTrace();
        }
        return url;
    }
    public Set<String> getImgURL(String url){
        Set<String> imgURLSet = new HashSet<String>();
        Pattern p = Pattern.compile("<img[^<]+src=\"([^\"]+)\"[^>]+>");
        Matcher matcher = p.matcher(url);
//        Pattern p1 = Pattern.compile("http[s*]:\\\"?(.*?)(\\\"|>|\\\\s+)");
        while (matcher.find()) {
            String imgUrl = matcher.group(1);
            System.out.println(imgUrl);
//            Matcher matcher1 = p1.matcher(imgUrl);
//            while(matcher1.find()){
//                String imgSrcUrl = matcher1.group();
//                System.out.println(imgSrcUrl);
//                imgURLSet.add(imgSrcUrl);
//            }
        }
        System.out.println(imgURLSet.size());
        return imgURLSet;
    }
    public Set<String> dig(String url){
        Set<String> set = null;
        String result = urlConnect(url);
        set = getImgURL(result);
        return set;
    }
}
