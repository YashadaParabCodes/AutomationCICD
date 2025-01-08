package YashadaParabAutomation.TestComponents;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;


import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import YashadaParabAutomation.pageObjects.CartPage;
import YashadaParabAutomation.pageObjects.CataloguePage;
import YashadaParabAutomation.pageObjects.CheckoutPage;
import YashadaParabAutomation.pageObjects.OrderPage;



public class ErrorValidation extends Initialization{
	String productName="qwerty";
	String countryName="India";
	
	@Test (groups= {"ErrorHandling"},retryAnalyzer=Retry.class)
	public void checkError() {
	creds.credentials("mere@greysloan.com", "Merelove244");
	Assert.assertEquals("Incorrect email or password.",creds.errorHandling());
	
	}

	@Test (dependsOnMethods={"submitOrders"})
	public void submitProduct() throws IOException{
		
		
		CataloguePage cp=creds.credentials("mere@greysloan.com", "Merelove24");
		OrderPage or=cp.gotoOrders();
		Assert.assertTrue(or.matchOrder(productName));
		
		
		
		
	}
	@Test(dataProvider="getData",groups="purchase")
	public void submitOrders(HashMap<String,String> map) throws IOException, InterruptedException{
		
		CataloguePage cp=creds.credentials(map.get("email"), map.get("password"));
		cp.returnList();
		cp.getWebElement(map.get("productName"));
		
		CartPage carts=cp.ClickSubmit(map.get("productName"));
		Boolean match=carts.matchCart(map.get("productName"));
		Assert.assertTrue(match);
	
		CheckoutPage last=carts.checkout();
		last.selectCountry(countryName);
		
		String msg=driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(msg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		System.out.println(msg);	
	}
	
	@DataProvider
	 public Object[][] getData() throws IOException {
		List<HashMap<String, String>> map =getJsonDataToMap(System.getProperty("user.dir")+"\\src\\main\\java\\YashadaParabAutomation\\data\\purchaseOrder.json");
	
		return new Object[][] {{map.get(0)},{map.get(1)}};
	}
	
	
	
//	@DataProvider
//	 public Object[][] getData() {
//		HashMap<String,String> map= new HashMap<>();
//		map.put("mailId", "mere@greysloan.com");
//		map.put("password", "Merelove24");
//		map.put("productName", "ZARA COAT 3");
//		
//		HashMap<String,String> map1= new HashMap<>();
//		map1.put("mailId", "gabss@gmail.com");
//		map1.put("password", "Gs@123456");
//		map1.put("productName", "ADIDAS ORIGINAL");
//		return new Object[][]{{map},{map1}};
//	}
	
	
//	@DataProvider
//	 public Object getData() {
//		return new Object[][]{{"mere@greysloan.com","Merelove24","ZARA COAT 3"},{"gabss@gmail.com","Gs@123456","ADIDAS ORIGINAL"}};
//	}
	

}
