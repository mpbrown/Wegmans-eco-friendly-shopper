package io.github.anthonymj.foodpointtech;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class DatabaseHelper
{
	private String debugText = "";
	private int _myresponsecode;
	private ArrayList<String> cats;

	public DatabaseHelper()
	 {


		 try {
			 //milk
			String catid = "577-583";
			URL url = new URL("https://api.wegmans.io/products/categories/"+catid+"?api-version=2018-10-18&subscription-key=1474d845d1ef473d9645da89d85320b0");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			
			String inline = "";
			
			int responsecode = con.getResponseCode();
			if(responsecode != 200){
				throw new RuntimeException("HttpResponseCode: "+responsecode);
			}
			else{
				Scanner sc = new Scanner(url.openStream());
				while(sc.hasNext()){
					inline+=sc.nextLine();
				}

				JSONParser parse = new JSONParser();
				JSONObject jobj = (JSONObject)parse.parse(inline);
				JSONArray prodList = (JSONArray) jobj.get("products");
				debugText = ((JSONObject) prodList.get(2)).toString();

				for(int i = 0; i < prodList.size(); i++){
					JSONObject product = (JSONObject) prodList.get(i);
					System.out.println(product.get("sku")+" is "+product.get("name"));

				}
				
			}
			
			con.disconnect();
			
			URL url2 = 
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			 e.printStackTrace();
		} catch (RuntimeException e){
			 e.printStackTrace();
		} catch (ParseException e) {
			 e.printStackTrace();
		 }
	 }

	 public String getDebugText(){
		return debugText;
	 }
	 public int get_myresponsecode(){
		return _myresponsecode;
	 }
}