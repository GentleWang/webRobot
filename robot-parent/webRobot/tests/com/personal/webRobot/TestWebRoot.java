package com.personal.webRobot;

import org.junit.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class TestWebRoot {

	@Test
	public void testImgDownLoad(){
      URLDigger urlDig =new URLDigger();
      Set<String> set = urlDig.dig("http://www.cebbank.com/");
      Imgdownload imgdownload = new Imgdownload();

      Iterator it = set.iterator();
      while(it.hasNext()){
          imgdownload.downloadImg("D:\\img\\",it.next().toString());
      }
	}
	@Test
	public void testTestPattern() {
        String url = "<img id=\"yeshi\" src=\"/site/resource/cms/2015/03/2015032617521049792.jpg\">";
//        String url = "<img  id=\"yeshi\" src=\"/site/resource/cms/2016/01/2016010716095694979.jpg\" height=\"60\" border=\"0\">";
        Pattern p = Pattern.compile("<img[^<]+src=\"([^\"]+)\"[^>]*>");
        Matcher matcher = p.matcher(url);
        while (matcher.find()) {
            String imgUrl = matcher.group(1);
            System.out.println(imgUrl);
        }
    }
    @Test
    public void test(){
        System.out.println("12121");
    }
}
