package testData;

import java.io.File;

import com.google.gson.JsonParser;

public class JsonDataReader {
	String firstName , lastName , email , Password;
	public void JsonReader()
	{
		String filePath = System.getProperty("user.dir") + "\\src\\test\\java\\testData\\TestData.json";
		File srcFile = new File(filePath);
		JsonParser parser = new JsonParser();
	}
}
