package page;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.BrowserManager;
import utility.BrowserManager.EPConditions;

public class HomePage {

	WebDriver driver;
	
	By btnMumbai = By.xpath("//ul//li[1]");
	By btnSearchArea = By.id("4");
	By tfSearch = By.xpath("//input[@type='text']");
	By movieSuggestion = By.xpath("//ul//li//div//div//img");
	By btnBookTicket = By.xpath("(//button//div//span[text()='Book tickets'])[1]");
	By btnNotNow = By.xpath("//button[text()='Not Now']");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getCity() {
		return BrowserManager.waitFor(btnMumbai, driver, EPConditions.CLICKABLE);
	}
	
	public WebElement getSearchFieldButton() {
		return BrowserManager.waitFor(btnSearchArea, driver, EPConditions.CLICKABLE);
	}
	
	public WebElement getSearchFideld() {
		return BrowserManager.waitFor(tfSearch, driver, EPConditions.CLICKABLE);
	}
	
	public List<WebElement> getAllSuggestions(){
		return new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(movieSuggestion));
	}
	
	public WebElement getBookTicketButton() {
		return BrowserManager.waitFor(btnBookTicket, driver, EPConditions.CLICKABLE);
	}
	
	public WebElement getNotNowButton() {
		BrowserManager.waitFor(By.xpath("//div[text()='Get Personalized Updates']"), driver, EPConditions.VISIBLE);
		return BrowserManager.waitFor(btnNotNow, driver, EPConditions.CLICKABLE);
	}
}
