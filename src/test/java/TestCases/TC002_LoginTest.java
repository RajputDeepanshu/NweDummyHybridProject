package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseClassNew;
import PageObject.HomePage1;
import PageObject.LoginPage1;
import PageObject.MyAccountPage1;


public class TC002_LoginTest extends BaseClassNew{

	@Test(groups={"sanity", "regression"})
	public void verfiy_login()
	{
		
		logger.info("**** Test case TC_002 LoginTest Started *****");
		
		try
		{
		//HomePage
		HomePage1 hp=new HomePage1(driver);
		hp.myAccountHP();
		hp.loginButton();
		
		//Login
		LoginPage1 lp=new LoginPage1(driver);
		lp.enterEmailLogin(p.getProperty("email"));
		lp.enterPassword(p.getProperty("password"));
		lp.clickLogin();
		
		//My Account 
		MyAccountPage1 macc=new MyAccountPage1(driver);
		boolean target=macc.myAccountTitle();
		Assert.assertEquals(target, true, "Title verification Failed");	
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("**** Test case TC_002 LoginTest Finished *****");
	}
	
}
