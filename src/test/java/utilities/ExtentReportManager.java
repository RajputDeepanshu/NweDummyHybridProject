package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener{

	public ExtentSparkReporter sparkreporter; //UI of the report (Theme, title, Report name)
	public ExtentReports extentreport;
	public ExtentTest test;
    String repname;
    
    public void onStart(ITestContext testcontext)
    {
    	//create the time stamp 
    	SimpleDateFormat dateformat=new SimpleDateFormat("yyyymmddhhmmss");
    	Date date=new Date();
    	String timestamp=dateformat.format(date);
    	
    	//now get the report name
    	repname="Test-Report"+timestamp+".html";
    	
    	//set the path of report where it get saved
    	sparkreporter=new ExtentSparkReporter(".\\reports\\"+repname);
    	
    	sparkreporter.config().setDocumentTitle("Automation");
    	sparkreporter.config().setReportName("Opencart application");
    	sparkreporter.config().setTheme(Theme.DARK);
    	
    	//common information pass on the report
    	
    	extentreport = new ExtentReports();
    	extentreport.attachReporter(sparkreporter);
    	extentreport.setSystemInfo("Application", "OpenCart");
    	extentreport.setSystemInfo("Module","Admin");
    	extentreport.setSystemInfo("Sub-Module","Customer");
    	extentreport.setSystemInfo("username", System.getProperty("user.name"));
    	extentreport.setSystemInfo("Environment", "QA");
    	
    	//Now pass OS name from XML file
    	String operatingsystem=testcontext.getCurrentXmlTest().getParameter("os");
    	extentreport.setSystemInfo("OperatingSystem", operatingsystem);
    	
    	//Now pass browser name from XML file
    	String browsername=testcontext.getCurrentXmlTest().getParameter("browser");
    	extentreport.setSystemInfo("Browser", browsername);
    	
    	//Now need to set groups
    	List<String> includegroups =testcontext.getCurrentXmlTest().getIncludedGroups();
    	if(!includegroups.isEmpty())
    	{
    		extentreport.setSystemInfo("Groups", includegroups.toString());
    	}
    	
    }
    
    
    public void onTestSuccess(ITestResult result)
    {
    	test=extentreport.createTest(result.getTestClass().getName());
    	test.assignCategory(result.getMethod().getGroups());
    	//test.log(Status.PASS.getName()+"Test Passed");
    }
    
	
}
