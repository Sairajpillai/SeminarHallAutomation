package in.ineuron.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class JDBCUtil {
	
	private JDBCUtil() {
		// making constructor private so that object cannot be created
	}
	
	static {
		// Loading and registering the Driver
		System.out.println("MySQL Driver loaded");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}
	
	@SuppressWarnings("unused")
	public static Connection getPhysicalConnection() throws FileNotFoundException, IOException, SQLException {
		// Step 2:Establish the connection
		// Take the data from properties File
		String fileLoc = "G:\\INeuron Internship\\SeminarHallBooking\\SeminarHallBooking\\src\\main\\java\\in\\ineuron\\properties\\application.properties";
		FileInputStream fis = new FileInputStream(fileLoc);
		Properties pr = new Properties();
		pr.load(fis);


		String url = pr.getProperty("jdbcUrl");
		String username = pr.getProperty("user");
		String password = pr.getProperty("password");

		return DriverManager.getConnection(url, username, password);
	}
	
	public static Connection getJdbcConnection() throws SQLException, IOException {
		String fileLoc = "G:\\INeuron Internship\\SeminarHallBooking\\SeminarHallBooking\\src\\main\\java\\in\\ineuron\\properties\\application.properties";
		HikariConfig config = new HikariConfig(fileLoc);
		HikariDataSource dataSource = new HikariDataSource(config);

		return dataSource.getConnection();

	}

}
