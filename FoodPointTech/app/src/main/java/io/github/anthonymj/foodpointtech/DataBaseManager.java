package io.github.anthonymj.foodpointtech;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.NoSuchElementException;

public class DataBaseManager {
	private Connection connection;
	
	private void openConnection() {
		connection = SqlHelper.connect();
		if (connection == null) {
			System.out.println("Not conencted to a data base");
		}
	}
	
    private void closeConnection() {
    	try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	public boolean addToProducts(String name, String catagory, int sku) {
		openConnection();
		String query = "INSERT INTO Products (ProductName, Catagory, sku) VALUES (?, ?, ?);"; // ? is place holders
		try (PreparedStatement preparedStatment = connection.prepareStatement(query)){
			preparedStatment.setString(1, name);
			preparedStatment.setString(2, catagory);
			preparedStatment.setInt(3, sku);
			preparedStatment.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} 
		return true;
	}
	
	public Impact getEnviormentalImpact(int sku) {
		ResultSet rs = null;
		String query = "select * from Products where sku=?;"; //? is place holders
		try (PreparedStatement preparedStatment = connection.prepareStatement(query)){
			preparedStatment.setInt(1, sku);
			rs = preparedStatment.executeQuery();
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
					e.printStackTrace();
					return null;
				}
			} else {
				throw new NoSuchElementException();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
