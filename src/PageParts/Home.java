package PageParts;

import PageConstants.Constants;




import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home {

	WebDriver driver;
	WebDriverWait wait;
	

	
	Constants _constant;
	   
	
	public Home(WebDriver _driver) throws Exception
	{ 
		_constant = new Constants();
		
		driver = _driver;
		wait = new WebDriverWait(driver, 60);
	
	}
	

	public void  GettingStarted() throws Exception {

		WebElement e;
		
		try {
			
			// find an element under Getstarted banner
			e = driver.findElement(By.xpath(_constant.GetStartedWidget_X));
		} catch (Exception ex) {
			//ex.printStackTrace();
			System.out.println("Get staring widget is not there, have to add");
			e = null;
		}

		if ((e) != null) // If getting started widget exits

		{
			GetStartedBanner();

		} else {
			System.out.println("Adding the widget");
			try {
				driver.findElement(By.cssSelector(_constant.CustomizeLink_Cs)).click();

				driver.findElement(By.cssSelector(_constant.AddGetStartedWidget_Cs)).click();

				FindAddExit();

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//a[contains(text(),'See helpful tips')]")));

				GetStartedBanner();
			} catch (Exception exc) {
				exc.printStackTrace();
			}
		} 

	}

	public void FindAddExit() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(_constant.AddtoHomeBut_Cs)));

		driver.findElement(By.cssSelector(_constant.AddtoHomeBut_Cs)).click();

		driver.findElement(By.cssSelector(_constant.ExitCust_Cs)).click();
	}

	public void GetStartedBanner() throws Exception

	{ 	
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//a[contains(text(),'See helpful tips')]")));

		try {
			if ((driver.findElement(By.xpath(".//a[contains(text(),'See helpful tips')]"))) != null)
			{
				driver.findElement(By.xpath(".//a[contains(text(),'See helpful tips')]")).click();
				Thread.sleep(20000);
				if ((driver.findElement(By.className("gseHead"))) != null)
				// driver.findElement(By.className("gseHead"))
				{
					System.out.println("helpful tips shown");
				} else {
					System.out.println("helpful tips not shown");
				}
			}
		} catch (NoSuchElementException e3) {
		e3.printStackTrace();
			
			
			
		}
	}

	
		
}