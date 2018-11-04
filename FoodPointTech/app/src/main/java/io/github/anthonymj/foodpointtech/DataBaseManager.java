package io.github.anthonymj.foodpointtech;


import android.util.Log;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.NoSuchElementException;

public class DataBaseManager {
	private Connection connection;
	
	private void openConnection() {
		connection = SqlHelper.conect();
		if (connection == null) {
			Log.i("Task", "Not connected to data base");
		}
	}
	
    private void closeConnection() {
    	try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			Log.i("Task", e.toString());
		}
    }
	
	public boolean addToProducts(String name, String catagory, int sku, String URL) {
		openConnection();
		String query = "INSERT INTO Products (ProductName, Catagory, sku, ImageURL) VALUES (?, ?, ?, ?);"; // ? is place holders
		try (PreparedStatement preparedStatment = connection.prepareStatement(query)){
			preparedStatment.setString(1, name);
			preparedStatment.setString(2, catagory);
			preparedStatment.setInt(3, sku);
			preparedStatment.setString(4, URL);
			preparedStatment.executeUpdate();
		} catch (SQLException e) {
			Log.i("Task", e.toString());
			return false;
		} 
		return true;
	}
	
	public Impact getEnviormentalImpact(int sku) {
		ResultSet rs = null;
		String query = "select * from Products where sku=?;"; //? is place holders
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
			preparedStatement.setInt(1, sku);
			rs = preparedStatement.executeQuery();
			if (rs.next()) { // if result comes in with a match it returns true
				String catagory = rs.getString("Catagory");
				ResultSet reset = null;
				query = "select * from CatagoryEffects where Catagory=?;"; //? is place holders
				try (PreparedStatement ps = connection.prepareStatement(query)){
					ps.setString(1, catagory);
					reset = ps.executeQuery();
					if (reset.next()) { // if result comes in with a match it returns true
						 Impact impact = new Impact(reset.getDouble("WaterUsage"), reset.getDouble("LandUsage"), 
								 reset.getDouble("CO2PPM"), reset.getInt("AvgExpiration"));
						closeConnection();
						return impact;
					} else {
						throw new NoSuchElementException();
					}
				} catch (SQLException e) {
					Log.i("Task", e.toString());
					return null;
				}
			} else {
				throw new NoSuchElementException();
			}
		} catch (SQLException e) {
			Log.i("Task", e.toString());
			return null;
		}
	}

}
