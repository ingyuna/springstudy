package com.koreait.integration1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Date;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class SearchBoardTest {

	@Test
	public void test() {

		try {
			String query = URLEncoder.encode("영화", "utf-8");
			String apiURL = "http://localhost:9090/integration1/selectQuery.do?column=TITLE&query=" + query;		
																	
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();	
			BufferedReader br = new BufferedReader( new InputStreamReader( con.getInputStream() ) )  ;
														
			String resultMap = "";
			String line = null;
			while ( (line = br.readLine()) != null) {
				resultMap += line;
			}		
		
			JSONObject obj = new JSONObject(resultMap);
			
			JSONArray arr = obj.getJSONArray("list");
			for (int i = 0; i < arr.length(); i++) {
				JSONObject board = (JSONObject)arr.get(i);
				System.out.println("번호: " + board.getInt("no"));
				System.out.println("제목: " + board.getString("title"));
				System.out.println("내용: " + board.getString("content"));
				System.out.println("작성일: " + new Date((long)board.get("regdate")));
			}		
			
			br.close();
			con.disconnect();
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
}
