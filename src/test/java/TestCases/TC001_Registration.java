package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseClassNew;
import PageObject.AccRegistrationPage;
import PageObject.HomePage1;

public class TC001_Registration extends BaseClassNew{

	
	@Test(groups={"sanity", "regression"})
	public void verifyRegistration()
	{ 
		logger.info("TC started....");
		
		try
		{
			
		HomePage1 hmp=new HomePage1(driver);
		hmp.myAccountHP();
		hmp.registerHP();
		
		AccRegistrationPage ac=new AccRegistrationPage(driver);
		
		ac.firstNameMthd(randomString().toUpperCase());
		logger.info("Entered firstName...");
		
		ac.lastNameMthd(randomString().toUpperCase());
		logger.info("Entered lastname...");
		
		ac.emailMthd(randomEmail()+"@gmail.com");
		logger.info("Enterd email...");
		
		ac.telephnMthd(randomMobile());
		ac.psswdMthd("Test@123");
		ac.confirmPsswdMthd("Test@123");
		ac.agreecheckMthd();
		
		ac.continuetbuttonMthd();
		logger.info("clicked on continue button...");
		
		String actual=ac.getConfirmation();
		logger.info("Account created...");
		
		Assert.assertEquals(actual, "Your Account Has Been Created!");
		}
		catch(Exception e)
		{
			logger.error("Error logs...");
			logger.debug("Debug failed...");
			Assert.fail();
		}
			
	}
	
	
	
}
