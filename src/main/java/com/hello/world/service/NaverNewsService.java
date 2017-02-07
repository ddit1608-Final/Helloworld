package com.hello.world.service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import com.hello.world.dto.News;


@Service
public class NaverNewsService {
	private static String clientID = "R6hjrHGIbpEiTl74Np3R";
	private static String clientSecret = "LZI9A2Z5XI";

	// display ==> 몇개 출력
	// start ==> 몇번째부터 (item)
	public List<News> searchNews(String keyword, int display, int start){
		List<News> list = null;
		try{
			URL url;
			url = new URL("https://openapi.naver.com/v1/search/"
					+ "news.xml?query="
					+ URLEncoder.encode(keyword, "UTF-8")
					+ (display !=0 ? "&display=" + display : "")
					+ (start !=0 ? "&start=" + start : ""));
			
			URLConnection urlConn = url.openConnection();
			urlConn.setRequestProperty("X-Naver-Client-Id", clientID);
			urlConn.setRequestProperty("X-Naver-Client-Secret", clientSecret);
			
			XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
			XmlPullParser parser = factory.newPullParser();
			parser.setInput(new InputStreamReader(urlConn.getInputStream()));
			
			int eventType = parser.getEventType();
			News b = null;
			while(eventType != XmlPullParser.END_DOCUMENT) {
				switch(eventType) {
				case XmlPullParser.END_DOCUMENT:
					break;
				case XmlPullParser.START_DOCUMENT:
					list = new ArrayList<News>();
					break;
				case XmlPullParser.END_TAG: {
					String tag = parser.getName();
					if(tag.equals("item")){
						list.add(b);
						b = null;
					}
				}
				case XmlPullParser.START_TAG: {
					String tag = parser.getName();
					switch(tag){
					case "item":
						b = new News();
						break;
					case "title":
						if(b != null)
							b.setTitle(parser.nextText());
						break;
					case "originallink":
						if(b != null)
							b.setOriginallink(parser.nextText());
						break;
					case "description":
						if(b != null)
							b.setDescription(parser.nextText());
						break;
					}
				}
				}
				eventType = parser.next();
			}
			
			
			
		}catch (MalformedURLException e) {
			e.printStackTrace();
		}catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}catch (XmlPullParserException e) {
			e.printStackTrace();
		}
		return list;
	}
}
