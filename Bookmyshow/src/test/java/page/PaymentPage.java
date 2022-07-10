package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.BrowserManager;
import utility.BrowserManager.EPConditions;

public class PaymentPage {

	WebDriver driver;
	
	By paymentPage = By.xpath("//html");
	
	public PaymentPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getPaymentPage() {
		return BrowserManager.waitFor(paymentPage, driver, EPConditions.PRESENCE);
	}

}
