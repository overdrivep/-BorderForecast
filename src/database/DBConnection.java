package database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static final String DB_PROP_FILE = "db.properties";
	private static final String DRIVER = "driver";
	private static final String URL = "url";
	private static final String USER = "user";
	private static final String PASSWORD = "pw";

	public static void loadDriver() throws IOException,ClassNotFoundException {
		String driver = PropertyLoader.getProperty(DB_PROP_FILE,DRIVER);
		Class.forName(driver);
	}

	public static Connection connect() throws IOException,SQLException {
		String url = PropertyLoader.getProperty(DB_PROP_FILE,URL);
		String user = PropertyLoader.getProperty(DB_PROP_FILE,USER);
		String password =PropertyLoader.getProperty(DB_PROP_FILE,PASSWORD);

		return DriverManager.getConnection(url,user,password);
	}

	public static void disconnect(Connection conn) throws SQLException {
		if(null != conn) {
			conn.close();
		}
	}
}
