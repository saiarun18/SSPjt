package week5.day2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Zoomcar {

	ChromeDriver driver;
	int highest_price;

	@Test
	public void zoomcar() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.zoomcar.com/chennai");
		driver.findElementByClassName("search").click();
		driver.findElementByXPath("//div[@class='component-popular-locations']/div[4]").click();
		driver.findElementByClassName("proceed").click();
		// driver.findElementByXPath(" //div[@class='days']/div[3]").click();
		// Get the current date

		Date date = new Date();

		// Get only the date (and not month, year, time etc)

		DateFormat sdf = new SimpleDateFormat("dd");

		// Get today's date

		String today = sdf.format(date);

		// Convert to integer and add 1 to it

		int tomorrow = Integer.parseInt(today) + 2;

		// Print tomorrow's date

		System.out.println(tomorrow);

		driver.findElementByXPath("//div[contains(text(),'" + tomorrow + "')]").click();

		driver.findElementByClassName("proceed").click();

		driver.findElementByClassName("proceed").click();

		List<WebElement> Carprice = driver.findElementsByXPath("//div[@class='car-list-layout']//div[@class='price']");

		System.out.println("The list of Cars available is " + Carprice.size());

		String highprice_string = Carprice.get(0).getText();

		String[] splitstring = highprice_string.split(" ");
		String highpirce_stringarray = splitstring[1];
		int initial_highprice = Integer.parseInt(highpirce_stringarray);

		System.out.println(initial_highprice);

		for (int i = 1; i <= Carprice.size() - 1; i++) {
			String carpricelist = Carprice.get(i).getText();
			String[] splitstring1 = carpricelist.split(" ");
			String carprice_stringarray = splitstring1[1];
			int initial_carprice = Integer.parseInt(carprice_stringarray);

			if (initial_carprice > initial_highprice) {
				initial_highprice = initial_carprice;
			}

			highest_price = initial_highprice;
		}
		System.out.println("The highest car price is " + highest_price);

		WebElement highestprice_carelement = driver
				.findElementByXPath("//div[contains(text(),'" + highest_price + "')]/../../..//h3");

		System.out.println("The highest price car brand name is " + highestprice_carelement.getText());

		driver.findElementByXPath("//div[contains(text(),'" + highest_price + "')]/following-sibling::button").click();

		System.out.println("The highest price value car is booked successfully");
	}
}
