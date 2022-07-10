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

public class MoviePage {

	WebDriver driver;
	
	By btnShowTime = By.xpath("(//ul[@id='venuelist']//div//following-sibling::div[@class='body showtimes-details-container '])[1]//a");
	By btnAccept = By.xpath("//div[@id='btnPopupAccept']");
	By seats = By.xpath("//ul[@id='popQty']//li");
	By btnSelectSeat = By.xpath("//div[@id='proceed-Qty']");
	
	public MoviePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getShowTimeButton() {
		return BrowserManager.waitFor(btnShowTime, driver, EPConditions.CLICKABLE);
	}
	
	public WebElement getAcceptButton() {
		return BrowserManager.waitFor(btnAccept, driver, EPConditions.CLICKABLE);
	}
	
	public List<WebElement> getSeats(){
		return new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(seats));
	}
	
	public WebElement getSelectSeatButton() {
		return BrowserManager.waitFor(btnSelectSeat, driver, EPConditions.CLICKABLE);
	}
}
