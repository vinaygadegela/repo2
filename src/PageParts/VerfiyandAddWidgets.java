package PageParts;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import PageConstants.Constants;
import Results.HtmlResults;

public class VerfiyandAddWidgets {
	
	WebDriver driver;
	WebDriverWait wait;
	WebElement e;
	HtmlResults r;
	
	XSSFCell cell;
	XSSFCell cell11;
	String s;
	String s11;

	String Sheetname = ".Fr";
	File file = new File("D:\\selenium-automation\\ASS\\Data\\Widgets1.xlsx");
	FileInputStream fis = new FileInputStream(file);
	XSSFWorkbook workbook = new XSSFWorkbook(fis);
	XSSFSheet sheet = workbook.getSheet(Sheetname);

	
	Constants _constant;
	
	
	
	public VerfiyandAddWidgets(WebDriver _driver) throws Exception
	{ 
		
		
		_constant = new Constants();
	
		driver = _driver;
		wait = new WebDriverWait(driver, 30);  
	
	}  
	
	
	public void XX() throws IOException
	 {
		
		r= new HtmlResults();
		
	
	 for(int i=1; i<= sheet.getLastRowNum();i++)
	 {
	
	cell = sheet.getRow(i).getCell(2);
	s = cell.getStringCellValue();
	
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(s)));
			e=driver.findElement(By.xpath(s));
		//	System.out.println("Widget \" + sheet.getRow(i).getCell(1)"+ "  is existing ");
				try
				{
				r.results("Widget " + sheet.getRow(i).getCell(1) ,"Pass");
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
		}
		catch(Exception e1)
		{
			System.out.println("Widget " + sheet.getRow(i).getCell(1)+ " is not added , Have to add ");
		//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(_constant.CustomizeLink_Cs)));
		//	driver.findElement(By.cssSelector(_constant.CustomizeLink_Cs)).click();
			
				try
				{
					driver.findElement(By.cssSelector(_constant.CustomizeLink_Cs)).click();
					cell11 = sheet.getRow(i).getCell(3);
					s11 = cell11.getStringCellValue();
					//System.out.println(s11);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(s11)));
					driver.findElement(By.xpath(s11)).click();
				//	System.out.println("Widget " + sheet.getRow(i).getCell(1)+ " is now added");
					
					FindAddExit();
					r.results("Widget " + sheet.getRow(i).getCell(1) ,"Pass");
					
				}
			catch(Exception sss)
				{
					System.out.println("Widget " + sheet.getRow(i).getCell(1)+ " is not there");	
						try
						{
							driver.findElement(By.cssSelector(_constant.ExitCust_Cs)).click();
						r.results("Widget " + sheet.getRow(i).getCell(1) ,"Fail");
						}
						catch(Exception vv)
						{
							System.out.println(vv.getMessage());
						}
					
				}
		}
	
	 } 
	 }
		public void FindAddExit() {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(_constant.AddtoHomeBut_Cs)));

			driver.findElement(By.cssSelector(_constant.AddtoHomeBut_Cs)).click();

			driver.findElement(By.cssSelector(_constant.ExitCust_Cs)).click();
		}
	 

}
