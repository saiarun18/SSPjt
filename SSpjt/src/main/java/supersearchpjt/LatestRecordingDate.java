package supersearchpjt;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import bl.framework.api.SeleniumBase;
import pages.Homepage;

public class LatestRecordingDate extends SeleniumBase{
	

	String testcaseName;
	String testDec;
	String author;
	String category;
	String Fromdate="05/18/2019";
	String Todate="05/24/2019";

	@BeforeSuite
	public void beforeSuite() {
		startReport();
	}

	@AfterSuite
	public void afterSuite() {
		endReport();
	}

	@BeforeTest
	public void setData() {
		testcaseName = "RecordingDateVerification";
		testDec = "Latest Document Recorded Date";
		author = "Arun";
		category = "Smoke";
	}

	@BeforeClass
	public void beforeClass() {
		initializeTest(testcaseName, testDec, author, category);
	}

	public LatestRecordingDate() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Test(priority=1)
	public void VerifyIsabella() throws InterruptedException
	{
		//Verify the application launched successfully
		startApp("chrome","http://isabelladeeds.com/");
		waitElementtobevisible(Homepage.homelink(driver));
		verifyDisplayed(Homepage.homelink(driver));
		//System.out.println("The Application launched successfully");
		Thread.sleep(3000);
		String Recordingdata=Homepage.Latest_recordingdate(driver).getText();
		logStep("Isabella County - The Latest Document Recorded date is "+ Recordingdata,"pass");
		System.out.println("Isabella - Latest Recording date is "+ driver.findElement(By.xpath("(//td[@class='text-left']//span)[2]")).getText());
		close();
	} 
	
	@Test(priority=2)
	public void VerifyOceana() throws InterruptedException
	{
		//Verify the application launched successfully
		startApp("chrome","https://www.oceanadeeds.com/");
		waitElementtobevisible(Homepage.homelink(driver));
		Thread.sleep(3000);
		String Recordingdata=Homepage.Latest_recordingdate(driver).getText();
		logStep("Oceana County - The Latest Document Recorded date is "+ Recordingdata,"pass");
		
		//logStep("Oceana - The Latest Document Recorded date is "+ driver.findElement(By.xpath("(//td[@class='text-left']//span)[2]")).getText(), "pass");
		System.out.println("Oceana - Latest Recording date is "+ driver.findElement(By.xpath("(//td[@class='text-left']//span)[2]")).getText());
		close();
	} 
	

	@Test(priority=3)
	public void VerifyPanola() throws InterruptedException
	{
		//Verify the application launched successfully
		startApp("chrome","http://www.panolacountysearch.com/");
		WebDriverWait wait =new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='Orders']"))));
		Thread.sleep(3000);
		String Recordingdata=Homepage.Latest_recordingdate(driver).getText();
		logStep("Panola County - The Latest Document Recorded date is "+ Recordingdata,"pass");
		//logStep("Panola - The Latest Document Recorded date is "+ driver.findElement(By.xpath("(//td[@class='text-left']//span)[2]")).getText(), "pass");
		System.out.println("Panola - Latest Recording date is "+ driver.findElement(By.xpath("(//td[@class='text-left']//span)[2]")).getText());
		close();
	} 
	
	@Test(priority=4)
	public void VerifyTaylor() throws InterruptedException
	{
		//Verify the application launched successfully
		startApp("chrome","http://www.taylorcountyrecords.com/");
		waitElementtobevisible(Homepage.homelink(driver));
		Thread.sleep(3000);
		String Recordingdata=Homepage.Latest_recordingdate(driver).getText();
		logStep("Taylor County - The Latest Document Recorded date is "+ Recordingdata,"pass");
		
		//logStep("Taylor - The Latest Document Recorded date is "+ driver.findElement(By.xpath("(//td[@class='text-left']//span)[2]")).getText(), "pass");
		System.out.println("Taylor - Latest Recording date is "+ driver.findElement(By.xpath("(//td[@class='text-left']//span)[2]")).getText());
		close();
	} 
	
	@Test(priority=5)
	public void Verifymecosta() throws InterruptedException
	{
		//Verify the application launched successfully
		startApp("chrome","http://www.mecostadeeds.com/");
		WebDriverWait wait =new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='Orders']"))));	
		Thread.sleep(3000);
		String Recordingdata=Homepage.Latest_recordingdate(driver).getText();
		logStep("Mecosta County - The Latest Document Recorded date is "+ Recordingdata,"pass");
		
		
		
		//logStep("Mecosta - The Latest Document Recorded date is "+ driver.findElement(By.xpath("(//td[@class='text-left']//span)[2]")).getText(), "pass");
		System.out.println("Mecosta - Latest Recording date is "+ driver.findElement(By.xpath("(//td[@class='text-left']//span)[2]")).getText());
		close();
	} 
	
	@Test(priority=6)
	public void VerifyTarrant() throws InterruptedException
	{
		//Verify the application launched successfully
		startApp("chrome","https://tcrecordsonline.com/");
		waitElementtobevisible(Homepage.homelink(driver));
		Thread.sleep(3000);
		WebDriverWait wait =new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//td[@class='text-left']//span)[2]"))));
		Thread.sleep(3000);
		String Recordingdata=Homepage.Latest_recordingdate(driver).getText();
		logStep("Tarrant County - The Latest Document Recorded date is "+ Recordingdata,"pass");
		
		
		//logStep("Tarrant - The Latest Document Recorded date is "+ driver.findElement(By.xpath("(//td[@class='text-left']//span)[2]")).getText(), "pass");
		System.out.println("Tarrant - Latest Recording date is "+ driver.findElement(By.xpath("(//td[@class='text-left']//span)[2]")).getText());
		close();
	} 
	
	@Test(priority=7)
	public void VerifyOakland() throws InterruptedException
	{
		//Verify the application launched successfully
		startApp("chrome","https://ocmideeds.com/");
		waitElementtobevisible(Homepage.homelink(driver));
		Thread.sleep(3000);
		WebDriverWait wait =new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@class='btn btn-default']"))));
		
		WebElement Advanced_button=driver.findElement(By.xpath("//a[@class='btn btn-default']"));
		click(Advanced_button);
		
		//Enter From Date
		WebElement Process_Fromdate=driver.findElement(By.xpath(" //input[@id='inputRecordedDateFrom']"));
		Process_Fromdate.sendKeys(Fromdate);
		
		//Enter To Date
		WebElement Process_TOdate=driver.findElement(By.xpath("//input[@id='inputRecordedDateTo']"));
		Process_TOdate.sendKeys(Todate,Keys.ENTER);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//div[@class='panel panel-success']//td//small)[2]"))));
		
		Thread.sleep(3000);
		WebElement Recorded_Date=driver.findElement(By.xpath("(//div[@class='panel panel-success']//td//small)[2]"));
		String LatestRecorded_date= Recorded_Date.getText();
		logStep("Oakland County - The Latest Document Recorded date is "+ LatestRecorded_date,"pass");
		System.out.println("Oakland - Latest Recording date is "+LatestRecorded_date);
	
	} 
	
	@Test(priority=8)
	public void VerifyMacomb() throws InterruptedException
	{
		//Verify the application launched successfully
		startApp("chrome","http://deeds.macombgov.org/");
		//waitElementtobevisible(Homepage.homelink(driver));
		Thread.sleep(3000);
		WebDriverWait wait =new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@class='btn btn-default']"))));
		
		WebElement Advanced_button=driver.findElement(By.xpath("//a[@class='btn btn-default']"));
		click(Advanced_button);
		
		//Enter From Date
		WebElement Process_Fromdate=driver.findElement(By.xpath(" //input[@id='inputRecordedDateFrom']"));
		Process_Fromdate.sendKeys(Fromdate);
		
		//Enter To Date
		WebElement Process_TOdate=driver.findElement(By.xpath("//input[@id='inputRecordedDateTo']"));
		Process_TOdate.sendKeys(Todate,Keys.ENTER);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//div[@class='panel panel-success']//td//small)[2]"))));
		
		Thread.sleep(3000);
		WebElement Recorded_Date=driver.findElement(By.xpath("(//div[@class='panel panel-success']//td//small)[2]"));
		String LatestRecorded_date= Recorded_Date.getText();
		logStep("Macomb County - The Latest Document Recorded date is "+ LatestRecorded_date,"pass");
		System.out.println("Macomb County - Latest Recording date is "+LatestRecorded_date);
	
	} 
	
}
