package YashadaParabAutomation.pageObjects;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import YashadaParabAutomation.Reuseable.abstractClass;


public class CartPage extends abstractClass {
	WebDriver driver;
	public CartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this.driver);
	}
	By cartsection=By.cssSelector(".cartSection h3");
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartlist;
	
	@FindBy(css=".totalRow button")
	WebElement buttons;
	
	
	public boolean matchCart(String productName) {
		waitForElementToAppear(cartsection);
		Boolean match= cartlist.stream().anyMatch(s->s.getText().equalsIgnoreCase(productName));	
		 return match;
	}
	
	public CheckoutPage checkout() {
		buttons.click();
		return new CheckoutPage(driver);
	}

}
