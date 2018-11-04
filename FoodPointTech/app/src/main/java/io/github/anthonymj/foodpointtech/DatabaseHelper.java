package io.github.anthonymj.foodpointtech;

import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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
	io.github.anthonymj.foodpointtech.DataBaseManager dbm;
	ArrayList<Long> skuList;
	String catid;

	public DatabaseHelper()
	 {
		 dbm = new io.github.anthonymj.foodpointtech.DataBaseManager();

		 FirebaseDatabase frb = FirebaseDatabase.getInstance();


	 }

	 public ArrayList<Long> httpGetter(String catid){
		skuList = new ArrayList<>();
		 try {
			 //milk

			 URL url = new URL("https://api.wegmans.io/products/categories/"+catid+"?api-version=2018-10-18&subscription-key=1474d845d1ef473d9645da89d85320b0");
			 HttpURLConnection con = (HttpURLConnection) url.openConnection();
			 con.setRequestMethod("GET");
			 Log.i("Task", "After get");

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

				 //debugText = getImgURL((Integer) ((JSONObject) prodList.get(2)).get("sku"));

				 for(int i = 0; i < prodList.size(); i++){
					 JSONObject product = (JSONObject) prodList.get(i);

					 Long mysku = (Long) product.get("sku");
					 Log.i("Debug", mysku.toString() + " DEBUG SKU LONG VALIE");
//					int mysku = Integer.parseInt(skuStr);
					 //String myimgurl = getImgURL(mysku);
					 String myimgurl = "";

					 //System.out.println(product.get("sku")+" is "+product.get("name"));
					 Log.i("Task", "before add to products");
//					DatabaseReference myRef = frb.getReference().setValue();
//					dbm.addToProducts(product.get("name").toString(), "Milk", mysku, myimgurl);
					 Log.i("Task", "After add to products");
					 skuList.add(mysku);
				 }

			 }


			 con.disconnect();
			return skuList;

		 } catch (IOException e) {
			 // TODO Auto-generated catch block
			 Log.i("tag",e.toString());
		 } catch (RuntimeException e){
			 Log.i("tag",e.toString());
		 } catch (ParseException e) {
			 Log.i("tag",e.toString());
		 }

	 }

	 public String getImgURL(int sku){
         try {
             URL url = new URL("https://api.wegmans.io/products/"+sku+"?api-version=2018-10-18&subscription-key=1474d845d1ef473d9645da89d85320b0");
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
                 JSONArray trdID = (JSONArray) jobj.get("tradeIdentifiers");
                 JSONArray imgs = (JSONArray) trdID.get(trdID.indexOf("images"));
//                 JSONArray weights = (JSONArray) trdID.get(trdID.indexOf("weight"));
//				 String weight = jobj.getString("weight");

                 JSONObject imgurl = (JSONObject) imgs.get(0);
                 String reimgurl = imgurl.toString();

                 con.disconnect();
                 return reimgurl;
             }

         } catch (IOException e) {
             // TODO Auto-generated catch block
             Log.i("tag",e.toString());
         } catch (RuntimeException e){
             Log.i("tag",e.toString());
         } catch (ParseException e) {
             Log.i("tag",e.toString());
         }
         return null;
     }

	 public String getDebugText(){
		return debugText;
	 }
	 public int get_myresponsecode(){
		return _myresponsecode;
	 }


}