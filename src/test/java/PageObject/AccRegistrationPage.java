package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Base.BasePage;

public class AccRegistrationPage extends BasePage {
	
	
	public AccRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']") 
	WebElement txtFirstName;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtLastName;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txtTelephone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPssword;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txtConfirmPassword;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement chkPolicy;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnContinue;	
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	
	public void firstNameMthd(String fname)
	{
		txtFirstName.sendKeys(fname);	
	}
	
	public void lastNameMthd(String lname)
	{
		txtLastName.sendKeys(lname);	
	}
	
	public void emailMthd(String email)
	{
		txtEmail.sendKeys(email);	
	}
	
	public void telephnMthd(String telephnnumber)
	{
		txtTelephone.sendKeys(telephnnumber);	
	}
	
	public void psswdMthd(String pwd)
	{
		txtPssword.sendKeys(pwd);	
	}
	
	public void confirmPsswdMthd(String pwd)
	{
		txtConfirmPassword.sendKeys(pwd);	
	}
	
	public void agreecheckMthd()
	{
		chkPolicy.click();	
	}
	
	public void continuetbuttonMthd()
	{
		btnContinue.click();
	}
	
	public String getConfirmation()
	{
		try {
			return(msgConfirmation.getText());
		}catch(Exception e)
		{
			return (e.getMessage());
		}
		
	}

}
