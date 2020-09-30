package testData;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {
	// load the property file from the folder
	public static Properties userData = 
	loadProperties(System.getProperty("user.dir") + "\\src\\main\\java\\properties\\PropertyFile");

	private static Properties loadProperties(String path)
	{
		Properties pro = new Properties();
		// stream to read the file
		try {
			FileInputStream stream = new FileInputStream(path);
			pro.load(stream);
		} 
		catch (FileNotFoundException e) {
			System.out.println("Error Occurred " + e.getMessage());
		} 
		catch (IOException e) {
			System.out.println("Error Occurred " + e.getMessage());
		}
		catch (NullPointerException e) {
			System.out.println("Error Occurred " + e.getMessage());
		}
		return pro;
	}
}
