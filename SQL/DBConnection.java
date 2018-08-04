import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost/border_forecast?serverTimezone=JST";
	private static final String USER = "root";
	private static final String PASSWORD = "root";

	public static Connection connect() throws IOException, ClassNotFoundException, SQLException{
		Class.forName(DRIVER);
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}

	public static void disconnect(Connection conn) throws SQLException{
		if(null != conn){
			conn.close();
		}
	}
}
