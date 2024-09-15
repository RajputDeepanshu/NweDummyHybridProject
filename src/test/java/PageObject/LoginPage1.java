package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Base.BasePage;

public class LoginPage1 extends BasePage{
	
	public LoginPage1(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement emailfield;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement passwordfield;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginbutton;

	public void enterEmailLogin(String email)
	{
		emailfield.sendKeys(email);
	}
	
	public void enterPassword(String password) {
		passwordfield.sendKeys(password);
	}
	
	public void clickLogin()
	{
		loginbutton.click();
	}
	
}
