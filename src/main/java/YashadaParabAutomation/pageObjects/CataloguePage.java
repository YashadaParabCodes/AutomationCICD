package YashadaParabAutomation.pageObjects;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import YashadaParabAutomation.Reuseable.abstractClass;


public class CataloguePage extends abstractClass {
	WebDriver driver;
	public CataloguePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this.driver);
	}
	
	@FindBy(css=".mb-3")
	List<WebElement> productsAll;
	
	By products=By.cssSelector(".mb-3");
	By addtoCart=By.cssSelector(".card-body button:last-of-type");
	By appear=By.cssSelector("#toast-container");
	By disappear=By.cssSelector(".overlay-container");
	
	public List<WebElement> returnList()  {
		
		waitForElementToAppear(products);
		return productsAll;
	}
	
	public WebElement getWebElement(String productName)  {
		
		WebElement a= returnList().stream().filter(s->s.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
		waitForWebElementToAppear(a);
		return a;	
	}

	
	
	public CartPage ClickSubmit(String productName)  {
		
		WebElement prod=getWebElement(productName);
		
		prod.findElement(addtoCart).click();
		waitForElementToAppear(appear);
		waitForElementToDisappear(disappear);	
		return gotoCart();
		
	}
		
}
