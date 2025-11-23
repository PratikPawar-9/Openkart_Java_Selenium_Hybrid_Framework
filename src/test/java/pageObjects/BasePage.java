package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	
	WebDriver driver;
	
	/*BasePage(WebDriver driver):Constructor that accepts a WebDriver object from outside (your test).*/
	
	public BasePage(WebDriver driver)  //Constructor
	{
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	
}
