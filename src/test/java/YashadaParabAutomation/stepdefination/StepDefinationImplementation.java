
package YashadaParabAutomation.stepdefination;
import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;

import YashadaParabAutomation.TestComponents.Initialization;
import YashadaParabAutomation.pageObjects.CartPage;
import YashadaParabAutomation.pageObjects.CataloguePage;
import YashadaParabAutomation.pageObjects.CheckoutPage;
import YashadaParabAutomation.pageObjects.LandingPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class StepDefinationImplementation extends Initialization {
	
	public LandingPage creds;
	public CataloguePage cp;
	public CartPage carts;
	
	@Given("I land on the ecommerce website")
	public void I_land_on_the_ecommerce_website() throws IOException  {
		creds=launchApp();	
		
	}
	
	@Given("Logged in with username {string} and password {string}")
	public void Logged_in_with_username_and_password(String username, String password)  {
	    cp = creds.credentials(username, password);
	    
	}
	
	


	
	@When("I add productname {string} and click on add to cart")
	public void I_add_productname_and_clickonCart (String productName) throws InterruptedException {
		cp.returnList();
		cp.getWebElement(productName);
		
		 carts=cp.ClickSubmit(productName);
		 Boolean match=carts.matchCart(productName);
			Assert.assertTrue(match);
		
			CheckoutPage last=carts.checkout();
			last.selectCountry("India");		
	}

	
	@Then("{string} confirmation message is displayed")
	public void confirmation_msg(String m1) {
		String msg=driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(msg.equalsIgnoreCase(m1));
		driver.close();
		
	}
	
	@Then("{string} message is appeared")
	public void message_appeared(String m1) {
		Assert.assertEquals(m1,creds.errorHandling());
		driver.close();
		
	}

}
