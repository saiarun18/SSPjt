package homework;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import bl.framework.api.SeleniumBase;

public class ProjectMethods extends SeleniumBase {
	
	public String testcaseName, testDec, author, category;
	@BeforeSuite
	public void beforeSuite() {
		startReport();
	}
	@AfterSuite
	public void afterSuite() {
		endReport();
	}
	
	@BeforeClass
	public void beforeClass() {
		initializeTest(testcaseName, testDec, author, category);
	}
	@Parameters({"url","username","password"})
	@BeforeMethod
	public void login(String url,String uname,String passwd) {
		startApp("chrome", url);
		WebElement eleUsername = locateElement("id", "username");
		clearAndType(eleUsername, uname); 
		WebElement elePassword = locateElement("id", "password");
		clearAndType(elePassword, passwd); 
		WebElement eleLogin = locateElement("class", "decorativeSubmit");
		click(eleLogin);
		click(locateElement("PartialLinkText", "CRM/SFA"));
	}
	
	@AfterMethod
	public void closeApp() {
		close();
	}
}
