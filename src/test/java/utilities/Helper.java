package utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {
// taking screenshot shared class
	public static void CaptureScreenshot(WebDriver driver, String screenshotName)
	{
		Path dest=Paths.get("./screenshots",screenshotName+".png");
		try {
			Files.createDirectories(dest.getParent());
			FileOutputStream fileInOut =new FileOutputStream(dest.toString());
			fileInOut.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
			fileInOut.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error while taking screenshot"+e.getMessage());
		}
	}
}
