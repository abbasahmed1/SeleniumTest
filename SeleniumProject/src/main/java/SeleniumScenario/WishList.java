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


public class WishList {

	protected WebDriver driver;
	private By ReturnHome = By.xpath("//*[@class=\"home\"]");
	private By LikeProduct = By.xpath("//*[@class=\"yith-wcwl-wishlistexistsbrowse\"]");
	private By ProductAdded = By.xpath("//*[@class=\"add_to_wishlist single_add_to_wishlist\"]");
	private By HomePage = By.xpath("//*[@rel=\"home\"]");
	private By WishItem = By.xpath("//a[contains(text(),'My Wishlist')]");
	//private By VerifyItem = By.xpath("//a[contains(text(),'pink drop shoulder oversized t shirt')]");
	private By RemoveProduct = By.xpath("//*[@class=\"remove remove_from_wishlist\"]");

	
	
	
public WishList(WebDriver driver) {
		
		
		this.driver =driver;
	}

public void returnHome () {

driver.findElement(ReturnHome).click();

}

public void WishlistProduct() throws InterruptedException {
	Select itemColor = new Select(driver.findElement(By.id("pa_color")));
	itemColor.selectByVisibleText("Pink");
	Select itemSize = new Select(driver.findElement(By.id("pa_size")));
	itemSize.selectByVisibleText("37");
	Thread.sleep(2000);
	driver.findElement(ProductAdded).click();
	//JavascriptExecutor js =(JavascriptExecutor) driver;
	//js.executeScript("window.scrollBy(0,-450)", "");
	driver.findElement(HomePage).click();
	driver.findElement(WishItem).click();
	//driver.findElement(VerifyItem).click();

		
}

public void RemoveFromWishlist() {
	
	driver.findElement(RemoveProduct).click();
	
	
}


}


