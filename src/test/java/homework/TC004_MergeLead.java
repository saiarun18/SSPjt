package homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import bl.framework.api.SeleniumBase;

public class TC004_MergeLead extends SeleniumBase{

	@Test
	public void mergeLead() throws InterruptedException
	{
		startApp("chrome", "http://leaftaps.com/opentaps");
		WebElement eleUsername = locateElement("id", "username");
		clearAndType(eleUsername, "DemoSalesManager"); 
		WebElement elePassword = locateElement("id", "password");
		clearAndType(elePassword, "crmsfa"); 
		WebElement eleLogin = locateElement("class", "decorativeSubmit");
		click(eleLogin); 
		
		//click on crm/sfa link
		
		WebElement eleCRMSFALink = locateElement("xpath", "//a[contains(text(), 'CRM/SFA')]");
		click(eleCRMSFALink);
		
		//click on leads in menu bar
		WebElement eleLeadsLink = locateElement("xpath","//a[text()='Leads']");
		click(eleLeadsLink);
		
		//Click on merge lead link
		WebElement eleMergeLeadsLink = locateElement("PartialLinkText", "Merge Leads");
		click(eleMergeLeadsLink);
		
		//Click on lookup icon
				WebElement eleLookupIcon = locateElement("xpath", "//img[@alt='Lookup']");
				click(eleLookupIcon);
				
				//Switch to Window - invoke switchToWindow() method
				
				Set<String> windowHandles = driver.getWindowHandles();
				List<String> ls=new ArrayList<String>();
				ls.addAll(windowHandles);
				switchToWindow(ls.get(1));
				
				Thread.sleep(2000);
				//maximize new window
				
				//driver.manage().window().maximize();
				
				//Enter from lead id
				
				WebElement eleFrmLeadId = locateElement("name", "id");
				clearAndType(eleFrmLeadId, "10734"); 
				
				//-----------------------------------------
				
				//Click find leads button
				
				WebElement eleFindLeadBtn = locateElement("xpath", "//button[text()='Find Leads']");
				click(eleFindLeadBtn);
				Thread.sleep(3000);
				
				//select the first row lead id
				
				
				WebElement table = driver.findElementByXPath("//table[@class='x-grid3-row-table']");
				 List<WebElement> rows = table.findElements(By.tagName("tr"));
				WebElement firstrow = rows.get(0);
				
				List<WebElement> column = firstrow.findElements(By.tagName("td"));
				String leadid = column.get(0).getText();
				
				WebElement eleLeadIDCell = locateElement("PartialLinkText", leadid);
				clickWithoutSnap(eleLeadIDCell);
				
				
				
				
				
				
				
				//Switch back to primary window
				switchToWindow(ls.get(0));
				Thread.sleep(1000);
				
				//click on merge button
				//driver.findElementByXPath("//a[text()='Merge']").click();
				
				//handle alert
				
				//driver.switchTo().alert().accept();
				
				//click search icon next to to lead textbox
				
				WebElement eleToLookupIcon = locateElement("xpath", "(//img[@alt='Lookup'])[2]");
				clickWithoutSnap(eleToLookupIcon);
				
				
				//Switch the control to new window
				Set<String> windowHandles1 = driver.getWindowHandles();
					 ls=new ArrayList<String>();
						ls.addAll(windowHandles1);
						System.out.println(ls.size());
						switchToWindow(ls.get(1));
						
						
						Thread.sleep(2000);
						//maximize new window
						
						//driver.manage().window().maximize();
						
						//Enter lead id
						
						//Enter to lead id
						
						WebElement eleToLeadId = locateElement("name", "id");
						clearAndType(eleToLeadId, "10736"); 
						
						
						
						//Click find leads button
						 eleFindLeadBtn = locateElement("xpath", "//button[text()='Find Leads']");
						click(eleFindLeadBtn);
						Thread.sleep(3000);
						
						//select the first row lead id
						
						
						 table = driver.findElementByXPath("//table[@class='x-grid3-row-table']");
						 rows = table.findElements(By.tagName("tr"));
						 firstrow = rows.get(0);
						
						 column = firstrow.findElements(By.tagName("td"));
						String toleadid = column.get(0).getText();
						
						 WebElement eleToLeadIDCell = locateElement("PartialLinkText", toleadid);
						 clickWithoutSnap(eleToLeadIDCell);
						
						//Switch back to primary window
						
						switchToWindow(ls.get(0));
						Thread.sleep(1000);
				
						//click on merge button
						 WebElement eleMergeLeadBtn = locateElement("xpath", "//a[@class='buttonDangerous']");
						 clickWithoutSnap(eleMergeLeadBtn);
						 //click(eleMergeLeadBtn);
						
						//switch to alert and accept
						acceptAlert();
						
						Thread.sleep(1000);
						//click on find leads link
						
						WebElement eleFindLeadLink = locateElement("xpath", "//a[text()='Find Leads']");
						click(eleFindLeadLink);
						
						Thread.sleep(1000);
						//enter value in lead id text box
						WebElement eleLeadIdTxt = locateElement("name", "id");
						clearAndType(eleLeadIdTxt,"10736");
						
						Thread.sleep(1000);
						//click on find leads button
						 eleFindLeadBtn = locateElement("xpath", "(//td[@class='x-panel-btn-td'])[6]");
						click(eleFindLeadBtn);
						
						//Verify that , there is no record displayed in table
	}

}

