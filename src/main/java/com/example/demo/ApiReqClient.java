//package com.example.demo;
//
//import java.io.BufferedReader;
//import java.io.DataOutputStream;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
//
//import org.springframework.util.FileCopyUtils;
//
//import com.google.gson.JsonObject;
//
//public class ApiReqClient {
//
//	public static void main(String[] args) {
//		
//		//================================//
//		//=============  GET  ============//
//		//================================//
//////		String targetUrl = "http://localhost:88/info/cityListByCode";
//////		String targetUrl = "http://localhost:88/info/cityByCountryCode?countryCode=KOR&population=100";
////		String targetUrl = "http://localhost:88/info/cityByCountryCode/KOR/100";
//////		String targetUrl = "http://localhost:88/info/cityAdd/TEST/TST/Seoul/100";
//////		String targetUrl = "http://localhost:88/info/cityAdd/TEST/TST/Seoul/100";
////		try {
////			URL targetURL = new URL(targetUrl);
////			HttpURLConnection httpURLConnection = (HttpURLConnection) targetURL.openConnection();
////			httpURLConnection.setRequestMethod("GET"); 
////			
////            int responseCode = httpURLConnection.getResponseCode();
////            System.out.println("요청\ntargetUrl\n" + targetUrl + "\ngetResponseCode : " + responseCode);
////                        
////            if(responseCode != 200) {
////            	System.out.println("httpUrlSend targetUrl 호출 후 responseCode [" + responseCode + "] 입니다.");                
////            } else {
////             	InputStream inputStream = httpURLConnection.getInputStream();
////             	byte[] entityByte = FileCopyUtils.copyToByteArray(inputStream);
////    			System.out.println("\n결과\n" + new String(entityByte, "UTF-8").trim());    			
////            }
////		}catch (Exception e) {
////			e.printStackTrace();
////		}
//	
//	
//		
//		//================================//
//		//============  POST  ============//
//		//================================//
//		try {
//            // 요청을 보낼 URL 설정
//            URL url = new URL("http://localhost:88/info/cityAdd/");
//            
//            // HttpURLConnection 객체 생성 및 설정
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            connection.setRequestMethod("POST");
//            connection.setRequestProperty("Content-Type", "application/json"); // 요청의 Content-Type 설정
//            connection.setDoOutput(true);
//            
//            // 요청 데이터 설정
//    		JsonObject reqJson = new JsonObject();
//    		reqJson.addProperty("id", 1);
//    		reqJson.addProperty("name", "TEST");
//    		reqJson.addProperty("countryCode", "TST");
//    		reqJson.addProperty("district", "Seoul");
//    		reqJson.addProperty("population", 100);
//    		
//            String requestData = new String(reqJson.toString());
//            System.out.println("requestData: " + requestData);
//            
//            // 요청 데이터를 서버로 전송
//            DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream());
//            outputStream.writeBytes(requestData);
//            outputStream.flush();
//            outputStream.close();
//            
//            // 응답 코드 확인
//            int responseCode = connection.getResponseCode();
//            System.out.println("Response Code: " + responseCode);
//            
//            // 응답 데이터 읽기
//            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//            String line;
//            StringBuffer response = new StringBuffer();
//            
//            while ((line = reader.readLine()) != null) {
//                response.append(line);
//            }
//            reader.close();
//            
//            // 응답 데이터 출력
//            System.out.println("Response Data: " + response.toString());
//            
//            // 연결 종료
//            connection.disconnect();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//	}
//
//}
