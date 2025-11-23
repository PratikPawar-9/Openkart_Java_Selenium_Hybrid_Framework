package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{
	
	
	
	@Test
	public void verify_account_registration()
	{
		
		logger.info("***** Starting TC001_AccountRegistrationTest *****");
		
		try {
		HomePage hp = new HomePage(driver);   // We need to pass the driver to constructor to invoke
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount Link");
		
		hp.clickRegister();
		logger.info("Clicked on Register Link");
		
		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		
		logger.info("Providing Customer Details...");
		regpage.setFirstName(randomString().toUpperCase());  //for capital letters
		regpage.setLastName(randomString().toUpperCase());
		regpage.setEmail(randomString()+"@gmail.com");
		regpage.setTelephone(randomNumber());
		
		String password = randomAlphanumeric(); //if confirm pass box is there then we can store in variable and used in confirm pass to match the pass
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		
		logger.info("Validating expected Message..");
		String confmsg = regpage.getConfirmationMsg();
		if (confmsg.equals("Your Account Has Been Created!")) //WE didnt write this in exception because it will only execute if the try got failed inbetween so logger or assert will not execute if try got passed
		{
		Assert.assertTrue(true);	  
		}
		else
		{
			logger.error("Test Failed...");
			logger.debug("Debug Logs..");
			Assert.assertTrue(false);
		}
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
	}
		
}
