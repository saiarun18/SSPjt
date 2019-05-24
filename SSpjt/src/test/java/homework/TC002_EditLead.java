package homework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import bl.framework.api.SeleniumBase;

public class TC002_EditLead extends ProjectMethods{

	@Test
	public void editLead() throws InterruptedException
	{
		//Login to Leaftaps and click CRM - Login will be handled by BeforeMethod under ProjectMethods
			
		//click on leads in menu bar
		WebElement eleLeadsLink = locateElement("xpath", "//a[text()='Leads']");
		click(eleLeadsLink);
		
		//Find Leads
		//click on Find leads in menu bar
				WebElement eleFindLeadsLink = locateElement("xpath", "//a[text()='Find Leads']");
				click(eleFindLeadsLink);
				
				//Click on Email tab
				WebElement eleEmailTab = locateElement("xpath", "//span[text()='Email']");
				click(eleEmailTab);
				
				//Enter email id
				WebElement eleEmailTxt = locateElement("xpath", "//input[@name='emailAddress']");
				clearAndType(eleEmailTxt, "Test1213@gmail.com");
				
				//Click on Find leads
				WebElement eleFindLeadsBtn = locateElement("xpath", "//button[text()='Find Leads']");
				click(eleFindLeadsBtn);
				
				Thread.sleep(2000);
				//in result table - select first matching record
				WebElement eleTableName = locateElement("xpath", "(//table[@class='x-grid3-row-table'])[1]");
				  List<WebElement> rows = eleTableName.findElements(By.tagName("tr"));
				 WebElement firstrow = rows.get(0);
			 List<WebElement> columns = firstrow.findElements(By.tagName("td"));
				 String firstMatchingLeadid=columns.get(0).getText();
				 
				 WebElement eleFirstMatchingLeadId = locateElement("linkText",firstMatchingLeadid);
				 click(eleFirstMatchingLeadId);
				 
				 
				 
boolean verifyTitle = verifyTitle("View Lead");
				 
				 if(verifyTitle)
					 System.out.println("given value  View Lead Title is matching");
				 else
					 System.out.println("Given value is not matching with the value");
				 
				 //Click on Edit menu/button at the top
				 
				 //Click on Edit lead - 
				 WebElement eleEditLink = locateElement("xpath", "//a[text()='Edit']");
				 click(eleEditLink);
				 Thread.sleep(2000);
				 
				 //Change company name

					
					WebElement eleCompanyNameTxt = locateElement("xpath", "//input[@id='updateLeadForm_companyName']");
					clearAndType(eleCompanyNameTxt, "Saicompanyedited");
					//Click on update button
					WebElement eleUpdateBtn = locateElement("xpath","//input[@value='Update']");
					 click(eleUpdateBtn);
					 
					 //Verify the company name after updation - 
					 
					 WebElement eleCompanyNameLbl = locateElement("xpath","//span[@id='viewLead_companyName_sp']");
					 String getCompanyNametxt = getElementText(eleCompanyNameLbl);
					 
					 if(getCompanyNametxt.contains("Saicompanyedited"))
					 {
						 System.out.println("Company name "+getCompanyNametxt+"is updated succesfully");
				     }
					 else
						 System.out.println("Company name is not updated ");	
	}
}

