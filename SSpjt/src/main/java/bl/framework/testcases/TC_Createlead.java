package bl.framework.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import bl.framework.api.SeleniumBase;

public class TC_Createlead extends SeleniumBase{

	@Test
	public void createleadmthd()
	{	System.out.println(getAlertText());
		startApp("chrome", "http://leaftaps.com/opentaps/control/main");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		
		WebElement username = locateElement("id", "username");
		clearAndType(username, "DemoSalesManager");
		
		WebElement password = locateElement("id", "password");
		clearAndType(password,"crmsfa");
		
		WebElement login_button = locateElement("class", "decorativeSubmit");
		click(login_button);
		
		WebElement CRMSFA_link = locateElement("PartialLinkText", "CRM/SFA");
		click(CRMSFA_link);
		
		WebElement Createlead = locateElement("xpath", "//a[text()='Create Lead']");
		click(Createlead);
		
		//Webdriverwait statements need to write
		
		WebElement CompanyName = locateElement("id", "createLeadForm_companyName");
		clearAndType(CompanyName, "Saicompany");
		
		WebElement FirstName = locateElement("id", "createLeadForm_firstName");
		clearAndType(FirstName, "Arun");
		
		WebElement LastName = locateElement("id", "createLeadForm_lastName");
		clearAndType(LastName, "Kumar");
		
		WebElement Createleadbutton = locateElement("name", "submitButton");
		click(Createleadbutton);
	}

}
