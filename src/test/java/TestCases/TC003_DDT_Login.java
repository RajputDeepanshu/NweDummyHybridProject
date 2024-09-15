package TestCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.BaseClassNew;
import PageObject.HomePage1;
import PageObject.LoginPage1;
import PageObject.MyAccountPage1;
import utilities.DataProviders;

public class TC003_DDT_Login extends BaseClassNew{

	@Test(dataProvider="logindata", dataProviderClass=DataProviders.class) //getting data provider from different class
	public void verfiyLoginDDT(String email, String password, String exp)
	{	
		//HomePage
		HomePage1 hp=new HomePage1(driver);
		hp.myAccountHP();
		hp.loginButton();
		
		//Login
		LoginPage1 lp=new LoginPage1(driver);
		lp.enterEmailLogin(email);
		lp.enterPassword(password);
		lp.clickLogin();
		
		//My Account 
		MyAccountPage1 macc=new MyAccountPage1(driver);
		boolean target=macc.myAccountTitle();
		
		if(exp.equalsIgnoreCase("Valid"))
		{
			
		}
		
		
	
	}
	
}

