package Source;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;



public class Environment {

	public static WebDriver driver;
	
	public static void instantiateBrowser(BrowserType browserType)
		{
		driver = getWebDriver(browserType);
	 
		}
	
	
	
	public static WebDriver getWebDriver(BrowserType browserType)
	{
		switch (browserType)
		{
		case FIREFOX:
			driver=new FirefoxDriver();
			return driver;
		case IE:
			System.setProperty("webdriver.ie.driver","D:\\Webd 32\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			return driver;
		case CHROME:
			System.setProperty("webdriver.chrome.driver", "D:\\Webd 32\\chromedriver.exe");
			driver = new ChromeDriver();
   	        return driver;

		default:
			throw new RuntimeException("Browser type unsupported");
	}
	
	}
	public enum BrowserType
	{
	FIREFOX, IE, CHROME,
	}
	  public  static void Envr ()
	  {
	   BrowserType brw=BrowserType.FIREFOX;
	  instantiateBrowser(brw);
	  }
	
}
