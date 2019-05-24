package homework;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import bl.framework.api.SeleniumBase;

public class TC001_CreateLead extends ProjectMethods{

	@Test
	public void createLead() throws InterruptedException
	{
		

		//Login to Leaftaps and click CRM - Login will be handled by BeforeMethod under ProjectMethods
		
		//Click on Create Lead link
		WebElement eleCreateLeadLink = locateElement("xpath", "//a[text()='Create Lead']");
		click(eleCreateLeadLink);

		//Enter company name
		WebElement eleCompanynameTxt = locateElement("id", "createLeadForm_companyName");
		clearAndType(eleCompanynameTxt, "Saicompany2");

		//enter firstname
		WebElement eleFirstNameTxt = locateElement("id","createLeadForm_firstName");
		clearAndType(eleFirstNameTxt, "Arun");

		//Enter lastname
		WebElement eleLastNameTxt = locateElement("id", "createLeadForm_lastName");
		clearAndType(eleLastNameTxt, "Kumar");

		//Select value from dropdown-source
		WebElement eleSourceDD = locateElement("id","createLeadForm_dataSourceId");
		selectDropDownUsingValue(eleSourceDD, "LEAD_PARTNER");

		//Select by value for dropdown -Marketing
		WebElement eleMarketingDD = locateElement("id", "createLeadForm_marketingCampaignId");
		selectDropDownUsingText(eleMarketingDD, "Catalog Generating Marketing Campaigns");

        //Enter firstname(local)
		WebElement eleFirstNameLocalTxt = locateElement("name", "firstNameLocal");
		clearAndType(eleFirstNameLocalTxt, "Matt");
		
		//Enter Lastname(local)
		WebElement eleLastNameLocalTxt = locateElement("name","lastNameLocal");
		clearAndType(eleLastNameLocalTxt, "Booker");
		
		//Enter Salutation
		WebElement eleSalutationTxt = locateElement("id", "createLeadForm_personalTitle");
		clearAndType(eleSalutationTxt, "TestSalutation");
		
		
		//Enter Title
		WebElement eleTitleTxt = locateElement("id", "createLeadForm_generalProfTitle");
		clearAndType(eleTitleTxt, "TestTitle");
		
		//Enter Dob
		WebElement eleDOB = locateElement("name", "birthDate");
		clearAndType(eleDOB, "25/01/80");
		
		//Enter Annual Revenue
		WebElement eleAnnualRevenueTxt = locateElement("name", "annualRevenue");
		clearAndType(eleAnnualRevenueTxt, "2000000");
		
		//Enter Department 
		WebElement eleDeptTxt = locateElement("id", "createLeadForm_departmentName");
		clearAndType(eleDeptTxt, "Business Analyst");
		
		//Select Preferred country dropdown 
		WebElement elePreferredCountryDD = locateElement("id", "createLeadForm_currencyUomId");
		selectDropDownUsingText(elePreferredCountryDD, "GBP - British Pound");

		
		//Select Industry dropdown using visibletext option
		WebElement eleIndustryDD = locateElement("id", "createLeadForm_industryEnumId");
		selectDropDownUsingText(eleIndustryDD, "Computer Software");
		
		//Enter Number of employees
		WebElement eleNumOfEmployessTxt = locateElement("id", "createLeadForm_numberEmployees");
		clearAndType(eleNumOfEmployessTxt, "50");
		
		//Enter SIC Code
		WebElement eleSICCode = locateElement("name", "sicCode");
		clearAndType(eleSICCode, "121");
		
		//Select Ownership dropdown using visiblebytxt
		WebElement eleOwnerShipTxt = locateElement("id", "createLeadForm_ownershipEnumId");
		selectDropDownUsingText(eleOwnerShipTxt, "LLC/LLP");
		
		//enter Ticker symbol
		WebElement eleTickerSymbolTxt = locateElement("name", "tickerSymbol");
		clearAndType(eleTickerSymbolTxt, "121");
		
		//Enter country code
		WebElement eleCountryCodeTxt = locateElement("xpath", "//input[@id='createLeadForm_primaryPhoneCountryCode']");
		clearAndType(eleCountryCodeTxt, "91");
		Thread.sleep(1000);
		//Enter phonenumber
		WebElement elePhonenumbTxt = locateElement("xpath", "//input[@id='createLeadForm_primaryPhoneNumber']");
		clearAndType(elePhonenumbTxt, "9999999988");
		
		//Enter email
		
		WebElement eleEmailTxt = locateElement("id", "createLeadForm_primaryEmail");
		clearAndType(eleEmailTxt, "Test1213@gmail.com");
		
		//Primary address section
		//To name
		WebElement eleToNameTxt = locateElement("id", "createLeadForm_generalToName");
		clearAndType(eleToNameTxt, "Matt");
		
		//enter address1
		WebElement eleAddress1Txt = locateElement("name", "generalAddress1");
		clearAndType(eleAddress1Txt, "No.12, Flora Homes");
		
		//Enter postal code
		WebElement elePostalCodeTxt = locateElement("id", "createLeadForm_generalPostalCode");
		clearAndType(elePostalCodeTxt, "600088");
		//createLeadForm_generalPostalCode
		
//enter city
		WebElement eleCityTxt = locateElement("id", "createLeadForm_generalCity");
		clearAndType(eleCityTxt, "Kanchipuram");
		//Select country
		WebElement eleCountryDD = locateElement("id", "createLeadForm_generalCountryGeoId");
		
		selectDropDownUsingText(eleCountryDD,"India");
		Thread.sleep(2000);
		
		//select state
WebElement eleStateDD = locateElement("id", "createLeadForm_generalStateProvinceGeoId");
		
		selectDropDownUsingText(eleStateDD,"TAMILNADU");
		
		//click on submit button
		
		WebElement eleSubmitBtn = locateElement("name", "submitButton");
		click(eleSubmitBtn);
		
		
//verifying lead creation
		//viewLead_firstName_sp
		WebElement eleFirstNameLabel = locateElement("id", "viewLead_firstName_sp");
		WebElement eleLastNameLabel = locateElement("id", "viewLead_lastName_sp");
		String txtFstName = getElementText(eleFirstNameLabel);
		String txtLstName = getElementText(eleLastNameLabel);
		
		if((txtFstName.equals("Arun")) && (txtLstName.equals("Kumar")))
		{
			System.out.println("Lead is created successfully");
		}
		
		else
			System.out.println("Lead is not created");
	}
}

	
	

