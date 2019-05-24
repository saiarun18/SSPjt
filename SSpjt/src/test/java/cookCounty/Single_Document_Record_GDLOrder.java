package cookCounty;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import Cookcountypages.Cook_HomePage;
import bl.framework.api.SeleniumBase;
import bl.framework.api.SeleniumBaseCopy;

public class Single_Document_Record_GDLOrder extends SeleniumBaseCopy {

	WebDriver driver;

	public Single_Document_Record_GDLOrder() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test
	public void login_IE() throws InterruptedException {
		System.setProperty("webdriver.ie.driver", ".//drivers//IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		driver.get("http://192.168.204.223:9100/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		try {
			WebElement Agree_button = driver.findElement(By.xpath("//input[@class='blue_button']"));
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", Agree_button);
			
			Thread.sleep(2000);
			// Passing UserName and Password & Click on Login button
			driver.findElement(By.xpath("//input[@name='txtEmail']")).sendKeys("jeba03@fmail.com");
	        driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("Jefe1234#");
		
			Thread.sleep(8000);
			WebElement loginbutton = driver.findElement(By.xpath("//input[@value='Login']"));
			
			executor.executeScript("arguments[0].click();", loginbutton);
		
			Thread.sleep(4000);
			
			// Verify the user successfully logged into the Application or not
		   driver.findElement(By.xpath(" //div[@class='dropdown pull-right']/a")).isDisplayed();
		 	
			System.out.println("User successfully logged into the Application");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("User unable to log in");
		} finally {
			driver.manage().deleteAllCookies();
		}

	}
}
