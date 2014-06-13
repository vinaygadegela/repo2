package PageParts;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageConstants.Constants;
import Results.HtmlResults;

public class DelWidgets extends VerfiyandAddWidgets {
	
	static WebDriver driver;
	WebDriverWait wait;
	WebElement e;
	HtmlResults r;

	Constants _constant;
	
	
	
	
	public DelWidgets(WebDriver _driver) throws Exception
		{
		super(driver);
		_constant = new Constants();
		driver= _driver;
		wait = new WebDriverWait(driver, 30);
		
	}
	
	public void DelExistingwidgets()
	{
		r= new HtmlResults();
		
		
		 for(int i=1; i<= sheet.getLastRowNum();i++)
		 {
		
		cell = sheet.getRow(i).getCell(2);
		s = cell.getStringCellValue();
		
			try
			{
				driver.findElement(By.cssSelector(_constant.CustomizeLink_Cs)).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(s)));
				e=driver.findElement(By.xpath(s));
				System.out.println("Widget \" + sheet.getRow(i).getCell(1)"+ "  is existing ");
					try
					{
						driver.findElement(By.xpath(s+"/div/div[1]/div[2]/button[3]"));
						
						driver.findElement(By.xpath("//button[@class='link lihpWidgetDeletedButton underline']")).click();
					r.results("Widget " + sheet.getRow(i).getCell(1) ,"Pass");
					}
					catch(Exception e)
					{
						System.out.println(e.getMessage());
					}
			}
			catch(Exception e1)
			{
				System.out.println("Widget " + sheet.getRow(i).getCell(1)+ " is not added by default ");
			
			}
		
		 } 
	}
	
	
}

