package generic;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

abstract public class BaseTest implements IAutoConst {
	
		public WebDriver driver;
		public String url = Utility.getPopertyValue(CONFIG_PATH, "URL");
		String ITO = Utility.getPopertyValue(CONFIG_PATH, "ITO");
		public long duration = Long.parseLong(ITO);
	
		static {
			System.setProperty(CHROME_KEY,CHROME_VALUE);
	
		}
		
		@BeforeMethod
		public void openBrowser() {
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(duration, TimeUnit.SECONDS);
			driver.get("");
		}
		@AfterMethod
		public void closeBrowser() {
			driver.close();
		}
}
