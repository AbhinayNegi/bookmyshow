package page;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.BrowserManager;
import utility.BrowserManager.EPConditions;

public class SeatSelectionPage {
	WebDriver driver;
	
	By rows = By.xpath("//table[@class='setmain']//tr");
	By btnPay = By.xpath("(//a[@id='btmcntbook'])[1]");
	
	public SeatSelectionPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public List<WebElement> getRows(){
		return new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(rows));
	}
	
	public WebElement getPayButton() {
		return BrowserManager.waitFor(btnPay, driver, EPConditions.CLICKABLE);
	}

}
