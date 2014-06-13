


package PageParts;

import PageConstants.Constants;




import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessageBoards {

	WebDriver driver;
	WebDriverWait wait;
	

	
	Constants _constant;
	   
	
	public MessageBoards(WebDriver _driver) throws Exception
	{ 
		_constant = new Constants();
		
		driver = _driver;
		wait = new WebDriverWait(driver, 60);
	
	}
	

	
	public void FindAddExit() 
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(_constant.AddtoHomeBut_Cs)));

		driver.findElement(By.cssSelector(_constant.AddtoHomeBut_Cs)).click();

		driver.findElement(By.cssSelector(_constant.ExitCust_Cs)).click();
	}

	

	public void VerifiesMessageBoards() {
		
		WebElement m;
		
		try {
			m = driver.findElement(By.xpath(" .//*[contains(@class,'portalWidgetContainer widgetMessageBoardFavorites')]"));
			// locator for mesg boards favourites
		} catch (Exception m1) {
			m = null;
			// m1.printStackTrace();
		}

		if (m != null) {
			MessageBoardContainer();

		} else {
			try {
				Thread.sleep(10000);
				
				System.out.println("Have to add Msg boards");
				driver.findElement(By.cssSelector(_constant.CustomizeLink_Cs)).click();
				driver.findElement(By.xpath(".//a[@id='availItemAL_14']")).click();
				
				FindAddExit();
				
					MessageBoardContainer();

				
			} catch (Exception mm) {
				mm.printStackTrace();
			}
		}
	}

	public void MessageBoardContainer() {
		System.out.println("Messgae Boards Favourites exits");
	}
}