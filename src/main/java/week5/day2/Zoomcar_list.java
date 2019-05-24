package week5.day2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Zoomcar_list {

	ChromeDriver driver;
	int highest_price;
	List<String> carprice = new ArrayList<>();

	@Test
	public void zoomcar() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.zoomcar.com/chennai");
		driver.findElementByClassName("search").click();
		driver.findElementByXPath("//div[@class='component-popular-locations']/div[3]").click();
		driver.findElementByClassName("proceed").click();
	
		// Get the current date
		Date date = new Date();
		// Get only the date (and not month, year, time etc)
		DateFormat sdf = new SimpleDateFormat("dd");
		// Get today's date
		String today = sdf.format(date);
		// Convert to integer and add 1 to it
		int tripstartdate = Integer.parseInt(today)+4;
		// Print tomorrow's date
		
		WebElement daytoselect = driver.findElementByXPath("(//div[contains(text(),'"+tripstartdate +"')])[1]");

		String daytoselect1 = daytoselect.getText();
		String startdate1=daytoselect1.replaceAll("[^0-9]", "");
		
		int startdateorg=Integer.parseInt(startdate1);
		System.out.println(startdateorg);

		daytoselect.click();

		driver.findElementByClassName("proceed").click();
		
		int tripenddate=tripstartdate+1;

		WebElement dayselected = driver.findElementByXPath("(//div[contains(text(),'" + tripenddate +"')])[1]");

		String dayselected1 = dayselected.getText();
		String enddate1 = dayselected1.replaceAll("[^0-9]", "");
		
		int enddateorg=Integer.parseInt(enddate1);
		System.out.println(enddateorg);
		
		
		if (startdateorg+1==enddateorg) {
			driver.findElementByClassName("proceed").click();
		}
		List<WebElement> Carprice = driver.findElementsByXPath("//div[@class='car-list-layout']//div[@class='price']");
		System.out.println("The list of Cars available is " + Carprice.size());

		for (int i = 0; i < Carprice.size() - 1; i++) {
			String carp = Carprice.get(i).getText();
			String carprice_nospl = carp.replaceAll("[^a-zA-Z0-9]", "");
			carprice.add(carprice_nospl);
		}

		System.out.println(carprice);

		String highest_carprice = Collections.max(carprice);

		int highest_carpricevalue = Integer.parseInt(highest_carprice);

		System.out.println("The highest car price is" + highest_carpricevalue);

		WebElement highestprice_carelement = driver
				.findElementByXPath("//div[contains(text(),'" + highest_carpricevalue + "')]/../../..//h3");
		System.out.println("The highest price car brand name is " + highestprice_carelement.getText());
		driver.findElementByXPath("//div[contains(text(),'" + highest_price + "')]/following-sibling::button").click();
		System.out.println("The highest price value car is booked successfully");
	}
}
