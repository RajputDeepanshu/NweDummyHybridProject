package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Base.BasePage;

public class MyAccountPage1 extends BasePage {

	public MyAccountPage1(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//a[normalize-space()='Cameras']")   //h2[normalize-space()='My Account']
	WebElement myaccount;
	
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement linklogout;
	
	public boolean myAccountTitle()
	{
		try
		{
		return (myaccount.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public void clinklogout()
	{
		linklogout.click();
	}
}
