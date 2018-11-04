package io.github.anthonymj.foodpointtech;


import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;

public class SqlHelper {
	public static Connection conect() { //good to use verbs for methods, static means you dont need an instance of class to call method
		try {
			Class.forName("org.sqlite.JDBC");
//			Connection conect = DriverManager.getConnection("jdbc:sqlite:C:..\\WegmansDB.db"); //this is possible if database is in project folder
			Connection conect = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Matthew\\Documents\\GitHub\\WhackyHacky\\WegmansDB.db"); //this is possible if database is in project folder
			return conect;
		} catch (Exception e) {
			Log.i("Task", e.toString());
			return null;
		}
	}

}
