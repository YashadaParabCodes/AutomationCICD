package YashadaParabAutomation.pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import YashadaParabAutomation.Reuseable.abstractClass;


public class CheckoutPage extends abstractClass {
	WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this.driver);
	}
	
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement country;
	
	@FindBy(css=".ta-item:nth-of-type(2)")
	WebElement selectCountry;
	
	@FindBy(xpath="//a[contains(@class,'btnn')]")
	WebElement placeOrders;
	
	By countryList=By.cssSelector(".form-group .ta-results");
	By placeOrder=By.xpath("//a[contains(@class,'btnn')]");
	
	public void selectCountry(String countryName) throws InterruptedException {
		Actions act= new Actions(driver);
		act.sendKeys(country,Keys.chord(Keys.CONTROL,"a",Keys.BACK_SPACE),countryName).build().perform();
		waitForElementToAppear(countryList);
		selectCountry.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		waitToBeClickable(placeOrder);
		placeOrders.click();
		
	}
	
	

	
	

}
