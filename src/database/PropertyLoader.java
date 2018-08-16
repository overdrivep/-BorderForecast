package database;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {
	public static String getProperty(String file,String prop) throws IOException {
		Properties pro = new Properties();
		FileReader fr = new FileReader(new File("src/properties/").getAbsolutePath() + "/" + file);
		pro.load(fr);
		return pro.getProperty(prop);
	}
}