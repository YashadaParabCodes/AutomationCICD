package YashadaParabAutomation.Reuseable;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import YashadaParabAutomation.pageObjects.CartPage;
import YashadaParabAutomation.pageObjects.OrderPage;

public class abstractClass {
	WebDriver driver;
	public abstractClass(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css="button[routerlink*='cart']")
	WebElement cart;
	
	@FindBy(css="[routerlink=\"/dashboard/myorders\"]")
	WebElement ordersButton;

	public void waitForElementToAppear(By findby) {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findby));
	}
	public void waitForWebElementToAppear(WebElement findby) {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(findby));
	}
	public void waitForElementToDisappear(By findby) {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(findby));
	}
	
	public void waitToBeClickable(By findby) {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(findby));
	}
	
	
	public CartPage gotoCart() {
		cart.click();
		CartPage page= new CartPage(driver);
		return page;
	}
	
	public OrderPage gotoOrders() {
		ordersButton.click();
		OrderPage order= new OrderPage(driver);
		return order;
	}
	
	
}

