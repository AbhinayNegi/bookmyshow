package page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.BrowserManager;
import utility.BrowserManager.EPConditions;

public class PrePayPage {

	WebDriver driver;
	
	By btnProceed = By.xpath("(//div[@id='prePay'])[1]");
	By dialogCondition = By.xpath("//div[@id='dPopupMsgText']");
	By btnAccept = By.xpath("//div[@id='btnAduPopupAccept']");
	
	public PrePayPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getProceedButton() {
		return BrowserManager.waitFor(btnProceed, driver, EPConditions.CLICKABLE);
	}
	
	public WebElement getAcceptButton() {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(dialogCondition));
		}catch(Exception e) {
			return null;
		}
		
		return BrowserManager.waitFor(btnAccept, driver, EPConditions.CLICKABLE);
	}

}
