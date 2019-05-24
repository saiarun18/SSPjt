package homework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import bl.framework.api.SeleniumBase;

public class TC003_DuplicateLead extends ProjectMethods{
	
	@Test
	public void findDuplicateLead() throws InterruptedException
	{
	
		//Login to Leaftaps and click CRM - Login will be handled by BeforeMethod under ProjectMethods
		
		//click on leads in menu bar
		WebElement eleLeadsLink = locateElement("xpath", "//a[text()='Leads']");
		click(eleLeadsLink);
		
		//Find Leads
		//click on Find leads in menu bar
				WebElement eleFindLeadsLink = locateElement("xpath", "//a[text()='Find Leads']");
				click(eleFindLeadsLink);
		//click on email tab
				
				
				WebElement eleEmailTab = locateElement("xpath", "//span[text()='Email']");
				click(eleEmailTab);
				
				//Enter email id
				WebElement eleEmailTxt = locateElement("xpath", "//input[@name='emailAddress']");
				clearAndType(eleEmailTxt, "Test1213@gmail.com");
				
		//Click on find leads button -
				
				WebElement eleFindLeadsBtn = locateElement("xpath", "//button[text()='Find Leads']");
				click(eleFindLeadsBtn);
				
				//select first matching record
				//identify table - 
				
				WebElement eleTableName = locateElement("xpath", "(//table[@class='x-grid3-row-table'])[1]");
				List<WebElement> rows = eleTableName.findElements(By.tagName("tr"));
				WebElement firstrow = rows.get(0);
			 List<WebElement> columns = firstrow.findElements(By.tagName("td"));
				 String firstMatchingLeadid=columns.get(0).getText();
				 System.out.println(firstMatchingLeadid);
				 WebElement eleFirstMatchingLeadId = locateElement("linkText",firstMatchingLeadid);
				 click(eleFirstMatchingLeadId);
				 
				 //Click on Duplicate lead - 
				 WebElement eleDuplicateLeadLink = locateElement("xpath", "//a[text()='Duplicate Lead']");
				 click(eleDuplicateLeadLink);
				 Thread.sleep(2000);
				 //Verify Url
				 boolean verifyTitle = verifyTitle("Duplicate Lead");
				 
				 if(verifyTitle)
					 System.out.println("given value  Duplicate Lead Title is matching");
				 else
					 System.out.println("Given value is not matching with the value");
				 
				 //Click on create lead  - 
				 
				 WebElement eleCreateLeadBtn = locateElement("xpath", "//input[@value='Create Lead']");
				 click(eleCreateLeadBtn);
				 
				 //Verify the duplicate lead name same as captured name
				 
				//verifying lead creation
					//viewLead_firstName_sp
					WebElement eleFirstNameLabel = locateElement("id", "viewLead_firstName_sp");
					WebElement eleLastNameLabel = locateElement("id", "viewLead_lastName_sp");
					String txtFstName = getElementText(eleFirstNameLabel);
					String txtLstName = getElementText(eleLastNameLabel);
					
					if((txtFstName.equals("Arun")) && (txtLstName.equals("Kumar")))
					{
						System.out.println(" Duplicate Lead is created successfully");
					}
					
					else
						System.out.println("Duplicate is not created");			
				
	}

}
	
	


