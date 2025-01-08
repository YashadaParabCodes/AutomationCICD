package YashadaParabAutomation.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import YashadaParabAutomation.Reuseable.abstractClass;

public class OrderPage extends abstractClass {
	WebDriver driver;
	public OrderPage(WebDriver driver){
		super (driver);
		this.driver=driver;
	}
	@FindBy(xpath="//tr/td[2]")
	List<WebElement> orderlist;
	By orders=By.xpath("//tr/td[2]");
	
	public boolean matchOrder(String productName) {
		waitForElementToAppear(orders);
		Boolean match= orderlist.stream().anyMatch(s->s.getText().equalsIgnoreCase(productName));	
		 return match;
	}

}
