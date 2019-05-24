package week6.day2;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import homework.ProjectMethods;


// Data provider sample programs

public class CreateLead extends ProjectMethods{
	
	/* @DataProvider(name="getdata")
		public String[][] mydata()
		{
			String [][] data = new String[2][3];
			
			data[1][0]="Temenoz1";
			data[1][1]="gk1";
			data[1][2]="malar1";
		
			data[0][0]="Temenoz2";
			data[0][1]="kg2";
			data[0][2]="varun2";
			return data;		
		}
	 
	 @DataProvider(name="getdata2")
		public String[][] mydata1()
		{
			String [][] data = new String[2][3];
			
			data[1][0]="Temenoz1";
			data[1][1]="gk1";
			data[1][2]="malar1";
		
			data[0][0]="Temenoz2";
			data[0][1]="kg2";
			data[0][2]="varun2";
			return data;		
		}*/
	 
	 
	 
	 
	@BeforeTest
	public void setData() {
		testcaseName = "TC001_CreateLead";
		testDec = "Create a new Lead in leaftaps";
		author = "Gayatri";
		category = "Smoke";
		filename="Mytestdata";
	} 
	
	@Test(dataProvider="getdata")
	public void createLead(String cname,String fname,String lname) {
		click(locateElement("linkText", "Leads"));
		click(locateElement("linkText", "Create Lead"));
		clearAndType(locateElement("id", "createLeadForm_companyName"), cname);
		clearAndType(locateElement("id", "createLeadForm_firstName"), fname);
		clearAndType(locateElement("id", "createLeadForm_lastName"), lname);
		click(locateElement("name", "submitButton")); 
	}
}
