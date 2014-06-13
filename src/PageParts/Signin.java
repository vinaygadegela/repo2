package PageParts;

import PageConstants.Constants;


import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.thoughtworks.selenium.SeleneseTestBase;

public class Signin 
 {
	Constants _constant;
	 public Signin()throws Exception
		{
			
			_constant = new Constants();
		}
	 
	public void Login(WebDriver d) throws Exception
	{
		WebElement e;
		WebDriverWait wait;
		wait = new WebDriverWait(d, 30);
		try
		{
		d.navigate().to(_constant.Url);
		d.manage().window().maximize();
		
		try
		{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(_constant.PopUpModalClose_Cs)));
		 e= d.findElement(By.cssSelector(_constant.PopUpModalClose_Cs));
		 
		if((e)!=null)
		{
			e.click();
		}
		}
		catch(Exception e1)
		{
		
		}
		
		d.findElement(By.xpath(_constant.SigninDropdown_X)).click(); 
		d.findElement(By.id(_constant.Username_I)).sendKeys(_constant.Username);
		d.findElement(By.id(_constant.Password_I)).sendKeys(_constant.Password);
		d.findElement(By.id(_constant.SigninButton_I)).click();
		
		String HomeUrl= "http://home.ancestrystage.it/";
		
		
		
		
		Assert.assertEquals(HomeUrl, d.getCurrentUrl());
		
		}
		catch(Exception v)
		{
			System.out.println(v.getMessage());
		
		}
		
		
		

		try
		{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(_constant.PopUpModalClose_Cs)));
		 e= d.findElement(By.cssSelector(_constant.PopUpModalClose_Cs));
		 
		if((e)!=null)
		{
			e.click();
		}
		}
		catch(Exception e1)
		{
		
		}
	}
 
 }