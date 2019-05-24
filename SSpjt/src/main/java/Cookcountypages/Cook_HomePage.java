package Cookcountypages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import bl.framework.api.SeleniumBase;
import bl.framework.api.SeleniumBaseCopy;

public class Cook_HomePage extends SeleniumBase{

	public Cook_HomePage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
public static String rowscount;
	
	public static List<WebElement> listelement=null;
	
	public static WebDriver driver;
	
	 private static WebElement element = null;
	 
	 public static WebElement Agreebutton() {
		 element=driver.findElement(By.xpath("//input[@class='blue_button']"));
		    return element;
		}
	
	 public static WebElement Email_Address() {
		 element=driver.findElement(By.xpath("//input[@name='txtEmail']"));
		    return element;
		}
	
	 public static WebElement Password() {
		 element=driver.findElement(By.xpath("//input[@name='txtPassword']"));
		    return element;
		}

	 public static WebElement Login_button() {
	      return element=driver.findElement(By.xpath("//input[@value='Login']"));
}}
