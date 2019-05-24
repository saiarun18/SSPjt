package bl.framework.api;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import bl.framework.base.Browser;
import bl.framework.base.Element;
import utils.AdvanceReport;


//public class SeleniumBase extends AdvanceReport implements Browser, Element{

public class SeleniumBaseCopy extends AdvanceReport implements Browser, Element{

	public RemoteWebDriver driver;
	public int i =1;
	Alert alert;
	String AlertText;
	WebDriverWait wait;
	
	public static Properties list = new Properties();

	public SeleniumBaseCopy() throws IOException {
		// super();

		loadPropertyFile(new File(System.getProperty("user.dir").concat("/objectrepository.properties")));
	}

	public void loadPropertyFile(File file) throws IOException {
		
			FileInputStream fis = new FileInputStream(file);
			list.load(fis);
		
	}

	@Override
	public void startApp(String url) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void startApp(String browser, String url) {
		try {
		
			if(browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				ChromeOptions op = new ChromeOptions();
				op.addArguments("--disable-notifications");
				driver = new ChromeDriver(op);
			} else if(browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
				driver = new FirefoxDriver(); 
			} else if(browser.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.ie.driver",
						".//drivers//IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
			driver.manage().window().maximize();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (Exception e) {
			System.err.println("The Browser Could not be Launched. Hence Failed");
			throw new RuntimeException();
		} finally {
			takeSnap();
		}
		}
	
	public void waitElementtobevisible(WebElement e)
	{
		WebDriverWait wait=new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(e));
	}
	
	
	
	
	@Override
	public WebElement locateElement(String locatorType, String value) {
		try {
			switch (locatorType) {
			case "id": return driver.findElementById(value);
			case "name": return driver.findElementByName(value);
			case "class": return driver.findElementByClassName(value);
			case "xpath": return driver.findElementByXPath(value);
			case "linkText":return driver.findElementByLinkText(value);
			case "PartialLinkText":return driver.findElementByPartialLinkText(value);
			case "TagName":return driver.findElementByTagName(value);
			default:
				break;
			}
		} catch (NoSuchElementException e) {
			System.err.println("The Element with locator:"+locatorType+" Not Found with value: "+value);
			throw new RuntimeException();
		}
		return null;
	}

	@Override
	public WebElement locateElement(String value) {
		WebElement findElementById = driver.findElementById(value);
		return findElementById;
	}

	@Override
	public List<WebElement> locateElements(String type, String value) {

		try {
			switch(type) {
			case "id": return driver.findElementsById(value);
			case "Name": return driver.findElementsByName(value);
			case "ClassName" :driver.findElementsByClassName(value);
			case "xpath": return driver.findElementsByXPath(value);
			case "linkText":return driver.findElementsByLinkText(value);
			case "PartialLinkText":return driver.findElementsByPartialLinkText(value);
			case "TagName":return driver.findElementsByTagName(value);
			default:
			break;
			}
		} catch (NoSuchElementException e) {
			System.err.println("The Element with locator:"+type+" Not Found with value: "+value);
			throw new RuntimeException();
		}
		return null;
	}

	@Override
	public void switchToAlert() {
		try {
			driver.switchTo().alert();
		} catch (NoAlertPresentException e) {
			System.err.println("Error message");
		}catch(Exception e) {
			System.out.println();
		}

	}

	@Override
	public void acceptAlert() {
		
		String text = "";		
		try {
			Alert alert = driver.switchTo().alert();
			text = alert.getText();
			alert.accept();
			System.out.println("The alert "+text+" is accepted.");
		} catch (NoAlertPresentException e) {
			System.out.println("There is no alert present.");
		} catch (WebDriverException e) {
			System.out.println("WebDriverException : "+e.getMessage());
		}  

	}

	@Override
	public void dismissAlert() {
		
		String text = "";		
		try {
			Alert alert = driver.switchTo().alert();
			text = alert.getText();
			alert.dismiss();
			System.out.println("The alert "+text+" is accepted.");
		} catch (NoAlertPresentException e) {
			System.out.println("There is no alert present.");
		} catch (WebDriverException e) {
			System.out.println("WebDriverException : "+e.getMessage());
		}  


	}
	

	@Override
	public String getAlertText() {
		String text = "";		
		try {
			Alert alert = driver.switchTo().alert();
			text = alert.getText();
		} catch (NoAlertPresentException e) {
			System.out.println("There is no alert present.");
		} catch (WebDriverException e) {
			System.out.println("WebDriverException : "+e.getMessage());
		} 
		return text;
	}

	@Override
	public void typeAlert(String data) {
		
		try {
			driver.switchTo().alert().sendKeys(data);
		} catch (NoAlertPresentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void switchToWindow(int index) {
		try {
			Set<String> allWindows = driver.getWindowHandles();
			List<String> allhandles = new ArrayList<>(allWindows);
			String exWindow = allhandles.get(index);
			driver.switchTo().window(exWindow);
			System.out.println("The Window With index: "+index+
					" switched successfully");
		} catch (NoSuchWindowException e) {
			System.err.println("The Window With index: "+index+
					" not found");	
		}
	}


	@Override
	public void switchToWindow(String title) {
		try {
			Set<String> allWindows = driver.getWindowHandles();
			for (String eachWindow : allWindows) {
				driver.switchTo().window(eachWindow);
				if (driver.getTitle().equals(title)) {
					break;
				}
			}
			System.out.println("The Window With Title: "+title+
					"is switched ");
		} catch (NoSuchWindowException e) {
			System.err.println("The Window With Title: "+title+
					" not found");
		} finally {
			takeSnap();
		}
	}
	@Override
	public void switchToFrame(int index) {
		try {
			driver.switchTo().frame(index);
		} catch (NoSuchFrameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void switchToFrame(WebElement ele) {
		try {
			driver.switchTo().frame(ele);
		} catch (NoSuchFrameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}

	}

	@Override
	public void switchToFrame(String idOrName) {
		try {
			driver.switchTo().frame(idOrName);
		} catch (NoSuchFrameException e) {
			System.out.println("NoSuchFrame Exception occured");
		}
	}

	@Override
	public void defaultContent() {
		driver.switchTo().defaultContent();

	}

	@Override
	public boolean verifyUrl(String url) {
		if (driver.getCurrentUrl().equals(url)) {
			System.out.println("The url: "+url+" matched successfully");
		return true;
		} else {
			System.out.println("The url: "+url+" not matched");
		}
		return false;
	}

	@Override
	public boolean verifyTitle(String title) {
		if (driver.getTitle().contains(title)) {
			logStep("Page title: "+title+" matched successfully","pass");
		return true;
		} else {
			logStep("Page title: "+title+" is not matched ","fail");
		}
		return false;
	}

	@Override
	public void takeSnap() {
		try {
		File src = driver.getScreenshotAs(OutputType.FILE);
		File des = new File("./snaps/img"+i+".png");
		FileUtils.copyFile(src, des);
		} catch (IOException e) {
			e.printStackTrace();
		}
		i++;
	}

	@Override
	public void close() {
		driver.close();

	}

	@Override
	public void quit() {
		driver.quit();

	}

	
	public void clickWithoutSnap(WebElement ele) {
		try {
			wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			ele.click();
			logStep("The Element "+ele+" clicked","pass");
		} catch (StaleElementReferenceException e) {
			logStep("The Element "+ele+" could not be clicked","fail");
			throw new RuntimeException();
		}

	}

	
	@Override
	public void click(WebElement ele) {
		try {
			wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			ele.click();
			logStep("The Element "+ele+" clicked", "pass"); 
		} catch (StaleElementReferenceException e) {
			logStep("The Element "+ele+" could not be clicked", "fail");
			throw new RuntimeException();
		} finally { 
			takeSnap();
		}
	}
	
	public void Javascriptclick(WebElement ele) {
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", ele);
			ele.click();
			logStep("The Element "+ele+" clicked", "pass"); 
		} catch (StaleElementReferenceException e) {
			logStep("The Element "+ele+" could not be clicked", "fail");
			throw new RuntimeException();
		} finally { 
			takeSnap();
		}
	}
	
	
	
	
	
	@Override
	public void append(WebElement ele, String data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear(WebElement ele) {
		try {
			ele.clear();
			logStep("The field is cleared Successfully","pass");
		} catch (ElementNotInteractableException e) {
			logStep("The field is not Interactable","fail");
			throw new RuntimeException();
		}finally {
			takeSnap();
		}
	}

	@Override
	public void clearAndType(WebElement ele, String data) {
		try {
			ele.clear();
			ele.sendKeys(data);
			logStep("The Data :"+data+" entered Successfully", "pass");
		} catch (ElementNotInteractableException e) {
			logStep("The Element "+ele+" is not Interactable", "fail");
			throw new RuntimeException();
		}finally {
			takeSnap();
		}

	}
	
	public void clearAndTypewithtab(WebElement ele, String data) {
		try {
			ele.clear();
			ele.sendKeys(data,Keys.TAB);
			logStep("The Data :"+data+" entered Successfully", "pass");
		} catch (ElementNotInteractableException e) {
			logStep("The Element "+ele+" is not Interactable", "fail");
			throw new RuntimeException();
		}finally {
			takeSnap();
		}

	}

	@Override
	public String getElementText(WebElement ele) {
		String text = ele.getText();
		return text;
	}

	@Override
	public String getBackgroundColor(WebElement ele) {
		String cssValue = ele.getCssValue("color");
		return cssValue;
	}

	@Override
	public String getTypedText(WebElement ele) {
		String attributeValue = ele.getAttribute("value");
		return attributeValue;
	}


	@Override
	public void selectDropDownUsingText(WebElement ele, String value) {
		Select sl=new Select(ele);
		sl.selectByVisibleText(value);
		
	}

	@Override
	public void selectDropDownUsingIndex(WebElement ele, int index) {
		Select sl=new Select(ele);
		sl.selectByIndex(index);
				
		
	}

	@Override
	public void selectDropDownUsingValue(WebElement ele, String value) {
		Select sl=new Select(ele);
		sl.selectByValue(value);
		
	}

	@Override
	public boolean verifyExactText(WebElement ele, String expectedText) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean verifyPartialText(WebElement ele, String expectedText) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean verifyExactAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean verifyDisplayed(WebElement ele) {
		
		try {
			ele.isDisplayed();
			logStep("The "+ele+" is displaying as expected", "pass");
			return true;
		} catch (ElementNotInteractableException e) {
			logStep("The " +ele+ " is not displaying", "pass");
			throw new RuntimeException();
		}finally {
			takeSnap();
		}

	}
	@Override
	public boolean verifyDisappeared(WebElement ele) {
		
		return false;
	}

	@Override
	public boolean verifyEnabled(WebElement ele) {
		try {
			ele.isEnabled();
			return true;
		} catch (Exception e) {
			System.out.println("The element "+ele+" is not enabled");
			return false;
		}
	}

	@Override
	public boolean verifySelected(WebElement ele) {
		try {
			ele.isSelected();
			return true;
		} catch (ElementNotSelectableException e) {
			System.out.println("The element is not selectable");
			return false;
		}
		
	}

}
