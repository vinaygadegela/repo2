package TestSuite;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageParts.DelWidgets;
import PageParts.Home;
import PageParts.MessageBoards;
import PageParts.Signin;
import PageParts.VerfiyandAddWidgets;
import Source.Environment;




public class VerifyingWidgets extends Environment{

	WebDriver _driver;
	Signin s;
	Home h;
	MessageBoards mb;
	VerfiyandAddWidgets vaw;
	DelWidgets delwidget;
	
	
	@BeforeMethod
	public void Setup() throws Exception 
	{
	Envr();
	_driver = driver;
	s= new Signin();
	h = new Home(_driver);
	mb = new MessageBoards(_driver);
	vaw = new VerfiyandAddWidgets(_driver);
	
	}
	
	
	public  void GS() throws Exception
	{
		s.Login(_driver);
		_driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		h.GettingStarted();	
		_driver.navigate().back();
		mb.VerifiesMessageBoards();
		
	}
	
	@Test
	  
	public void checkallwidgets() throws Exception
	{
		s.Login(_driver);
		_driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		vaw.XX();
		
	}
}
