package stepDefinitions;



import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BaseClass {
	public static WebDriver Driver = null;
	public static AppiumDriver MobileDriver = null;
	public static TouchAction TouchAction = null;

	public void intilizeDriver() throws Exception{
		String chromeDriverlocation = null;
		String os = System.getProperty("os.name").toLowerCase();
		if (os.contains("win")) {
		chromeDriverlocation = new File("chromedriver.exe").getAbsolutePath();
		}
		if (os.contains("mac")) {
			chromeDriverlocation = new File("chromedriver").getAbsolutePath();
		}
		System.setProperty("webdriver.chrome.driver", chromeDriverlocation);
		Driver = new ChromeDriver();
	}
	
	public void intilizeMobileDriver() throws Exception{
		DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Emulator");
        capabilities.setCapability("automationName","appium");
        capabilities.setCapability("appPackage","com.buuuk.st");
		capabilities.setCapability("appActivity","com.sph.straitstimes.views.activities.SplashActivity");
        MobileDriver = new AndroidDriver(new URL("http://172.26.158.153:4723/wd/hub"), capabilities);
        MobileDriver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
		TouchAction = new TouchAction(MobileDriver);
	}
}
