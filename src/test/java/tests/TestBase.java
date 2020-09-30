package tests;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import utilities.Helper;
public class TestBase extends AbstractTestNGCucumberTests {
	public static WebDriver driver;
	public static String downloadPath = System.getProperty("user.dir")+"\\downloads";
	public static FirefoxOptions firefoxOption()
	{
		// customizing the downloading path
		FirefoxOptions option = new FirefoxOptions();
		// 0 means default  1 means custom 2 means download path
		option.addPreference("browser.download.folderList", 2);
		option.addPreference("browser.download.dir", downloadPath);
		option.addPreference("browser.helperApps.neverAsk.saveToDisk","application/octet-stream");
		option.addPreference("browser.download.manager.showWhenStarting", false);
		option.addPreference("pdfjs.disabled",true);
		return option;
	}
	public static ChromeOptions chromeOptions()
	{
		ChromeOptions chromeOption = new ChromeOptions();
		HashMap<String, Object> chromeprefs= new HashMap<String, Object>();
		chromeprefs.put("profile.default.content_settings.popups", 0);
		chromeprefs.put("download.default_directory", downloadPath);
		chromeOption.setExperimentalOption("prefs",chromeprefs);
		chromeOption.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		return chromeOption;
	}
	@BeforeSuite
	@Parameters({"browser"})
	// in case user doesn't run testng.xml file the app run as chrome by optional parameter @Optional("chrome") inside method parameter
	public void startTest(@Optional("chrome") String driverName)
	{
		String url="https://demo.nopcommerce.com/";
		String driverPath;
		//if browser upper or lower case
		if (driverName.equalsIgnoreCase("chrome")) {
			driverPath=System.getProperty("user.dir")+"/drivers/chromedriver2.35.exe";
			System.setProperty("webdriver.chrome.driver", driverPath);
			driver = new ChromeDriver(chromeOptions());
		}
		else if (driverName.equalsIgnoreCase("firefox")) {
			driverPath=System.getProperty("user.dir")+"/drivers/geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", driverPath);
			driver = new FirefoxDriver(firefoxOption());
		} 
		else if (driverName.equalsIgnoreCase("edge")) {
			driverPath=System.getProperty("user.dir")+"/drivers/msedgedriver64.exe";
			System.setProperty("webdriver.edge.driver", driverPath);
			driver = new EdgeDriver();
		}
		else if (driverName.equalsIgnoreCase("ie")) {
			driverPath=System.getProperty("user.dir")+"/drivers/IEDriverServer.exe";
			System.setProperty("webdriver.ie.driver", driverPath);
			driver = new InternetExplorerDriver();
		}
		driver.navigate().to(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	@AfterMethod
	public void takeScreenshotOnFailure(ITestResult result)
	{
		if (result.getStatus()==ITestResult.FAILURE) {
			System.out.println("Failed");
			System.out.println("Take Screenshot");
			Helper.CaptureScreenshot(driver,result.getName());
		}
	}
	@AfterSuite
	public void closeTest()
	{
		driver.quit();
	}
	
	
	
}
