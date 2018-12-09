/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webapi;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject; 
/**
 *
 * @author Shehab
 */
public class testip {
    public static void main(String[] args) {
	try {
        testip.getIPAdress();
	} catch (Exception e) {
        e.printStackTrace();
	}
}
    
    public static String getIPAdress() throws Exception {
	String url = "http://httpbin.org/ip";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        int responseCode = con.getResponseCode();
        System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(
        new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
        	response.append(inputLine);
        }
        in.close();
        JSONObject myResponse = new JSONObject(response.toString());
        System.out.println("ip: "+myResponse.getString("origin"));
         return myResponse.getString("origin");
	    }
}



