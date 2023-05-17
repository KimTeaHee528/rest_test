package http;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.util.FileCopyUtils;

public class HttpClient {

	public static void main(String[] args) {
		
		
		//================================//
		//=============  GET  ============//
		//================================//
//		String targetUrl = "http://localhost:88/info/cityByCountryCode?countryCode=KOR&population=100";
//		
//		try {
//			URL targetURL = new URL(targetUrl);
//			HttpURLConnection httpURLConnection = (HttpURLConnection) targetURL.openConnection();
//			httpURLConnection.setRequestMethod("GET"); 
//			
//            int responseCode = httpURLConnection.getResponseCode();
//            System.out.println("요청\ntargetUrl\n" + targetUrl + "\ngetResponseCode : " + responseCode);
//                        
//            if(responseCode != 200) {
//            	System.out.println("httpUrlSend targetUrl 호출 후 responseCode [" + responseCode + "] 입니다.");                
//            } else {
//             	InputStream inputStream = httpURLConnection.getInputStream();
//             	byte[] entityByte = FileCopyUtils.copyToByteArray(inputStream);
//    			System.out.println("\n결과\n" + new String(entityByte, "UTF-8").trim());    			
//            }
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
		
		
		
		//================================//
		//============  POST  ============//
		//================================//
		String targetUrl = "http://localhost:88/info/cityListByCode/";
		String data = "{\"test\":\"data\"}";
		
		System.out.println("요청 평문 String    >>\n"+data);
		
		try {
			byte[] encryptData = data.getBytes("UTF-8");
			URL targetURL = new URL(targetUrl);
			HttpURLConnection conn = (HttpURLConnection) targetURL.openConnection();
			
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			
			conn.setRequestProperty("Accept-Language","UTF-8");
			conn.setRequestProperty("connection","Keep-Alive");
			conn.setRequestProperty("cache-control","no-cache");
			conn.setRequestProperty("Content-Type","application/json");
			conn.setRequestMethod("POST"); 
			
			DataOutputStream out = new DataOutputStream(conn.getOutputStream());
			out.write(encryptData);
			out.flush();
			out.close();
			
			int responseCode = conn.getResponseCode();
			System.out.println("httpUrlSend targetUrl " + targetUrl + " getResponseCode " + responseCode + "");
			
			if(responseCode != 200) {
				System.out.println("httpUrlSend targetUrl 호출 후 responseCode [" + responseCode + "] 입니다.");                
			} else {
				InputStream in = conn.getInputStream();
				byte[] entityByte = FileCopyUtils.copyToByteArray(in);
				System.out.println("응답 복호화 String>>\n"+new String(entityByte, "UTF-8").trim());    			
			}
		}catch (Exception e) {
			e.printStackTrace();
		}

		
		
	}
}
