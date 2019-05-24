package bl.framework.testcases;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import bl.framework.api.SeleniumBase;

public class TC001_LoginAndLogout extends SeleniumBase{

	@Test
	public void login() {
		startApp("chrome", "http://leaftaps.com/opentaps");
		WebElement eleUsername = locateElement("id", "username");
		clearAndType(eleUsername, "DemoSalesManager"); 
		WebElement elePassword = locateElement("id", "password");
		clearAndType(elePassword, "crmsfa"); 
		WebElement eleLogin = locateElement("class", "decorativeSubmit");
		click(eleLogin); 
		WebElement eleLogout = locateElement("class", "decorativeSubmit");
		click(eleLogout);
	}
}








