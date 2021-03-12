package com.cos.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class MyUtil {
	//유투브 영상 걸러내기
	public static String makeYoutube(String content){
	    Document doc = Jsoup.parse(content);
	    Elements a_tag = doc.select("a");
	    
	    String iFrame="";
	    
	    System.out.println(a_tag.size());
	    for(int i=0; i< a_tag.size(); i++){
	    	if(a_tag.get(i).attr("href").contains("www.youtube.com/watch")){
	    		System.out.println("영상 링크가 존재합니다.");
		    	String href = a_tag.get(i).attr("href");
		    	String sp[] = href.split("=");
		    	String value = sp[1];
		    	iFrame = "<iframe id=\"player\" type=\"text/html\" width=\"90%\" height=\"409\" src=\"http://www.youtube.com/embed/"+value+"\" frameborder=\"0\" webkitallowfullscreen=\"\" mozallowfullscreen=\"\" allowfullscreen=\"\"></iframe>";
		    	a_tag.get(i).after(iFrame);
		    }   
	    }
	    
	    return doc.toString();
	}
}
