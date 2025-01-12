package YashadaParabAutomation.standalone;

import java.io.IOException;

import org.openqa.selenium.By;


import org.testng.Assert;
import org.testng.annotations.Test;

import YashadaParabAutomation.TestComponents.Initialization;
import YashadaParabAutomation.pageObjects.*;



public class StandaloneTest extends Initialization {
	@Test
	public void submitOrder() throws IOException, InterruptedException{
		String productName="qwerty";
		String countryName="India";
		CataloguePage cp=creds.credentials("mere@greysloan.com", "Merelove24");
		cp.returnList();
		cp.getWebElement(productName);
//Validate CI CD webhook
		
		CartPage carts=cp.ClickSubmit(productName);
		
		
		Boolean match=carts.matchCart(productName);
		
		Assert.assertTrue(match);
		
		
		
		CheckoutPage last=carts.checkout();
		
		last.selectCountry(countryName);
	
		
		
		String msg=driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(msg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		System.out.println(msg);
		
		
		
	}
	
}


