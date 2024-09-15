package Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class BaseClassNew {
	
   public WebDriver driver;
   public Logger logger;     //Log4j
   public Properties p;
	 
	@BeforeClass(groups="sanity")
	@Parameters({"os", "browser"})
	public void setUp(String os, String br) throws IOException
	{
		
		//FileReader file=new FileReader("./src//test//resource//config.properties");
		FileInputStream file=new FileInputStream(".//src//test//resource//config.properties");
		//FileReader file=new FileReader("C:\\Users\\Admin\\eclipse-workspace\\NewHybridFrameWork\\src\\test\\resource\\config.properties");
		p=new Properties();
		p.load(file);
		
		logger=LogManager.getLogger(this.getClass());
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities cap=new DesiredCapabilities();
			//OS
               if(os.equalsIgnoreCase("windows"))
               {
                   cap.setPlatform(Platform.WIN11);
               }
               else if(os.equalsIgnoreCase("Mac"))
               {
            	   cap.setPlatform(Platform.MAC);
               }
               else if(os.equalsIgnoreCase("Linux"))
               {
            	   cap.setPlatform(Platform.LINUX);
               }
               else
               {
            	   System.out.println("Invlid Opertaing system passed from XML file....");
            	   return;
               }
               
               //browser
               switch(br.toLowerCase())
               {
               case "chrome": cap.setBrowserName("chrome"); break;
               case "edge": cap.setBrowserName("MicrosoftEdfe"); break;
               case "firefox": cap.setBrowserName("firefox"); break;
               default: System.out.println("Invalid browser passed from xml file.."); return;
               }
 
               driver=new RemoteWebDriver(URI.create("http://localhost:4444/wd/hub").toURL(), cap);
              
	     	}
		
		
		if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{
			switch(br.toLowerCase() )
			{
			case "chrome": driver=new ChromeDriver(); break;
			case "edge": driver=new EdgeDriver(); break;
			case "firefox": driver=new FirefoxDriver (); break; 
			default: System.out.println("Invalid browser..."); return;
			}
		}
			
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(p.getProperty("appURL"));
		
		driver.manage().window().maximize();
	}
	
	@AfterClass(groups="sanity")
	public void tearDown()
	{
		driver.quit();
	}
	
	
	public String randomEmail()
	{
	
		String generatedstring=RandomStringUtils.randomAlphanumeric(7);
		return generatedstring;
	}
	
	public String randomString()
	{
	
		String generatedemail=RandomStringUtils.randomAlphabetic(5);
		return generatedemail;
	}
	
	public String randomMobile()
	{
	
		String generatedmobile=RandomStringUtils.randomNumeric(10);
		return generatedmobile;
	}

}
