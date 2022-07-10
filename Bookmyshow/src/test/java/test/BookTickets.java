package test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import page.HomePage;
import page.MoviePage;
import page.PaymentPage;
import page.PrePayPage;
import page.SeatSelectionPage;
import utility.BConfigFileInitialize;
import utility.BrowserManager;
import utility.DBManager;
import utility.ScreenshotManager;

public class BookTickets extends BConfigFileInitialize{

	WebDriver driver;
	HomePage homePage;
	MoviePage moviePage;
	SeatSelectionPage seatPage;
	PrePayPage payPage;
	PaymentPage paymentPage;
	String[] movieData;
	
	@BeforeTest
	public void init() throws IOException, SQLException {
		initBrowser();
		BrowserManager.setDriver("Firefox");
		driver = BrowserManager.getDriver();
		driver.manage().window().maximize();
		
		homePage = new HomePage(driver);
		moviePage = new MoviePage(driver);
		seatPage = new SeatSelectionPage(driver);
		payPage = new PrePayPage(driver);
		paymentPage = new PaymentPage(driver);
		
		DBManager dbManager = new DBManager();
		movieData = dbManager.getMovieData();
	}
	
	@Test(priority = 1)
	public void bookTickets() {
		
		driver.get(config.getProperty("bookmyshow.com"));
		
		homePage.getCity().click();
		homePage.getSearchFieldButton().click();
		homePage.getSearchFideld().sendKeys(movieData[0]);
		//homePage.getSearchFideld().sendKeys("Khuda Haafiz Chapter 2 - Agni Pariksha");
		selectMovieFromSuggestions(homePage.getAllSuggestions(), "Bhool Bhulaiyaa 2");
		//selectMovieFromSuggestions(homePage.getAllSuggestions(), "Khuda Haafiz Chapter 2 - Agni Pariksha");
		homePage.getBookTicketButton().click();
		homePage.getNotNowButton().click();
		
		
	}
	
	@Test(dependsOnMethods = "bookTickets")
	public void movieDetails() {
		moviePage.getShowTimeButton().click();
		moviePage.getAcceptButton().click();
		
		selectSeats(moviePage.getSeats(), movieData[1]);
		moviePage.getSelectSeatButton().click();
	}
	
	@Test(dependsOnMethods = "movieDetails")
	public void seatSelection() {
		selectSeat(seatPage.getRows(), movieData[1]);
		
		seatPage.getPayButton().click();
	}
	
	@Test(dependsOnMethods = "seatSelection")
	public void payment() throws IOException {
		payPage.getProceedButton().click();
		WebElement acceptButton = payPage.getAcceptButton();
		if(acceptButton != null) {
			acceptButton.click();
		}
		
		ScreenshotManager.takeScreenshotOf(paymentPage.getPaymentPage());
	}
	
	public void selectSeat(List<WebElement> rows, String s) {
		int seats = Integer.parseInt(s);
		
		int adjacentCounter = 0;
		WebElement firstSeat = null;
		for(int i = 1; i <= rows.size(); i++) {
			adjacentCounter = 0;
			List<WebElement> allSeat = driver.findElements(By.xpath("//table[@class='setmain']//tr["+i+"]//td//div//a"));
			for(WebElement e : allSeat) {
				if(e.getAttribute("class").equals("_available")) {
					if(firstSeat == null) {
						firstSeat = e;
					}
					adjacentCounter++;
					if(adjacentCounter == seats) {
						firstSeat.click();
						return;
					}
				}else {
					adjacentCounter = 0;
					firstSeat = null;
				}
			}
		}
	}
	
	public void selectSeats(List<WebElement> seats, String n) {
		
		for(WebElement e : seats) {
			if(e.getText().equals(n)) {
				e.click();
				break;
			}
		}
	}
	public void selectMovieFromSuggestions(List<WebElement> suggestion,String movieName) {
		for(WebElement e : suggestion) {
			if(e.getAttribute("alt").equals(movieName)) {
				e.click();
				break;
			}
		}
	}
}
