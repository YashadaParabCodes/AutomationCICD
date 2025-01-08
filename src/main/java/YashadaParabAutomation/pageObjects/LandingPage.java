package YashadaParabAutomation.pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import YashadaParabAutomation.Reuseable.abstractClass;

public class LandingPage extends abstractClass {
	WebDriver driver;
	public LandingPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this.driver);
	}
	
	@FindBy(id="userEmail")
	WebElement mailID;
	
	@FindBy(id="userPassword")
	WebElement passwordID;
	
	@FindBy(id="login")
	WebElement submit;
	@FindBy(css="[class*='toast-message']")
	WebElement errorMessage;
	
	public CataloguePage credentials(String mail,String password) {
		mailID.sendKeys(mail);
		passwordID.sendKeys(password);
		submit.click();
		return new CataloguePage(driver);
	}
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client/");
	}
	
	public String errorHandling() {
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}
	

}
