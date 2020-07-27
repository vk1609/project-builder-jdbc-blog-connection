package utility;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
public class ConnectionManager{
	public static Properties loadPropertiesFile() throws IOException {
		Properties prop = new Properties();
		InputStream in = ConnectionManager.class.getClassLoader().getResourceAsStream("jdbc.properties");
		prop.load(in);
		in.close();
		return prop;
	}
	public static Connection getConnection() throws IOException {
		String driver;
		String url;
		String username;
		String password;
		
		Properties newprop = new Properties ();
		
		newprop = loadPropertiesFile();
		
		driver = newprop.getProperty("driver");
		url = newprop.getProperty("url");
		username = newprop.getProperty("username");
		password = newprop.getProperty("password");
		
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url,username,password);
			if(con != null){
				System.out.println("Connection Established");
			}
		}
		catch (Exception e){
			System.out.println("Check Your Connection");
		}
		return null;	
	}	
}

