package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CobraConnection {
	
	public static Connection con;
	
	public static String url = "jdbc:mysql://localhost:3306/lacobrita";
	public static String user = "root";
	public static String pass = "12345678";
	
	
	public static String getUrl() {
		return url;
	}


	public static void setUrl(String url) {
		CobraConnection.url = url;
	}


	public static String getUser() {
		return user;
	}


	public static void setUser(String user) {
		CobraConnection.user = user;
	}


	public static String getPass() {
		return pass;
	}


	public static void setPass(String pass) {
		CobraConnection.pass = pass;
	}

	public static Connection getConnection(String url, String user, String pass) {
		try {
			con = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}

	public static Connection getConnection() {
		
		try {
			con = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}

}
