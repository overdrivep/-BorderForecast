package database;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {
	public static String getProperty(String file,String prop) throws IOException {
		Properties pro = new Properties();
		// pathどうする？がちがちのローカルになっちゃう
		FileReader fr = new FileReader("/Users/syouta/git/BorderForecast/src/properties/" + file);
		pro.load(fr);
		return pro.getProperty(prop);
	}
}