package week5.day2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import bl.framework.api.SeleniumBase;

public class Facebook extends SeleniumBase {

	String testcaseName;
	String testDec;
	String author;
	String category;

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
		testcaseName = "FBloginVerification";
		testDec = "Verify FB login and validate";
		author = "Arun";
		category = "Smoke";
	}

	@BeforeClass
	public void beforeClass() {
		initializeTest(testcaseName, testDec, author, category);
	}

	@Test
	public void FB() throws InterruptedException {
		startApp("chrome", "https://www.facebook.com/");

		// Login To Facebook
		WebElement Email = locateElement("id", "email");
		clearAndTypewithtab(Email, "kumar.arun413@gmail.com");
		WebElement Password = locateElement("xpath", "//input[@id='pass']");
		clearAndType(Password, "kumaranarun");

		WebElement login_button = locateElement("xpath", "//input[@value='Log In']");
		click(login_button);

		// Send Text in Search box and click Search button

		WebElement SearchTextbox = locateElement("xpath", "  (//input[@placeholder='Search'])[1]");
		clearAndType(SearchTextbox, "TestLeaf");

		WebElement Searchbutton = locateElement("xpath", "(//button[@type='submit'])[1]");
		click(Searchbutton);

		// Click on Places link
		WebElement places_link = locateElement("xpath", "(//div[text()='Places'])[1]");
		click(places_link);

		// Verify TestLeaf is displayed or not
		WebElement Testleaf_link = locateElement("xpath", "//a[text()='TestLeaf']");
		verifyDisplayed(Testleaf_link);

		WebElement likebutton = locateElement("xpath", "(//button[contains(@type,'submit')])[3]");
		String likebutton1 = likebutton.getText();

		System.out.println(likebutton1);

		// Click like button or if its already liked, report as already liked

		if (likebutton.getText().contains("Liked")) {
			System.out.println("The Testleaf site is already liked");
		} else {
			likebutton.click();
		}
		

		// Click and verify the title contains Testleaf
		WebElement Testleaf_link1 = locateElement("xpath", "//a[text()='TestLeaf']");
		click(Testleaf_link1);
		verifyTitle("TestLeaf");
		
		

		WebElement No_of_likes = locateElement("xpath", "//div[contains(text(),'people like this')]");
		driver.navigate().refresh();
		WebElement No_of_likes1 = locateElement("xpath", "//div[contains(text(),'people like this')]");
		System.out.println("The Number of People liked Test Leaf page is " + No_of_likes1.getText());

	}

}
