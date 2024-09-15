package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Base.BasePage;

public class HomePage1 extends BasePage{
	
	public HomePage1(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//a[@title='My Account']")
	WebElement myaccount;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement register;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement login;
	
	public void myAccountHP()
	{
		myaccount.click();
	}
	
	public void registerHP()
	{
		register.click();
	}
	
	public void loginButton()
	{
		login.click();
	}	
	
}
