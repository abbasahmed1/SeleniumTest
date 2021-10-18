package SeleniumScenario;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PlaceOrder {
	
	protected WebDriver driver;
	private By Fname = By.xpath("//*[@id=\"billing_first_name\"]");
	private By Lname = By.xpath("//*[@id=\"billing_last_name\"]");
	private By Country = By.xpath("//*[@id=\"select2-billing_country-container\"]");
	private By Address = By.xpath("//*[@id=\"billing_address_1\"]");
	private By City = By.xpath("//*[@id=\"billing_city\"]");
	private By State = By.xpath("//*[@id=\"select2-billing_state-container\"]");
	private By Postcode = By.xpath("//*[@id=\"billing_postcode\"]");
	private By Phone = By.xpath("//*[@id=\"billing_phone\"]");
	private By Email = By.xpath("//*[@id=\"billing_email\"]");
	private By Terms = By.xpath("//*[@id=\"terms\"]");
	private By PlaceOrder = By.xpath("//*[@id=\"place_order\"]");
	private By ReturnHome = By.xpath("//*[@class=\"home\"]");
	

	
	
	public PlaceOrder(WebDriver driver) {
		
		
		this.driver =driver;
	}
	
	public void placeOrderDetails(String FirstName,String LastName,String Addr,String Cit,String Pc,String Ph) throws InterruptedException {

		driver.findElement(Fname).sendKeys(FirstName);
		driver.findElement(Lname).sendKeys(LastName);
		//driver.findElement(Country).sendKeys(Countr);
		driver.findElement(Address).sendKeys(Addr);
		driver.findElement(City).sendKeys(Cit);
		//driver.findElement(State).sendKeys(Stat);
		
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
	//	WebElement elemen = wait.until(ExpectedConditions.elementToBeClickable(By.id("terms")));
		WebElement Term = driver.findElement(By.id("terms"));
		Term.click();
		
		driver.findElement(Postcode).sendKeys(Pc);
		driver.findElement(Phone).sendKeys(Ph);
		
		//JavascriptExecutor js =(JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,-450)", "");
		//WebElement element=driver.findElement(PlaceOrder);
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(2000); 
		driver.findElement(PlaceOrder).click();
		Thread.sleep(2000); 

	}
	
	public void returnHome () {

		driver.findElement(ReturnHome).click();

		}

}
