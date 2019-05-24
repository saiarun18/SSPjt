package week6.day1;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import homework.ProjectMethods;

public class CreateLead extends ProjectMethods{
	
	@BeforeTest
	public void setData() {
		testcaseName = "TC001_CreateLead";
		testDec = "Create a new Lead in leaftaps";
		author = "Gayatri";
		category = "Smoke";
	} 
	@Test
	public void createLead() {
		click(locateElement("linkText", "Leads"));
		click(locateElement("linkText", "Create Lead"));
		clearAndType(locateElement("id", "createLeadForm_companyName"), "TL");
		clearAndType(locateElement("id", "createLeadForm_firstName"), "koushik");
		clearAndType(locateElement("id", "createLeadForm_lastName"), "c");
		click(locateElement("name", "submitButton")); 
	}
}
