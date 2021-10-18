package SeleniumScenario;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppinItemSelected {
	
	protected WebDriver driver;
	private By addToCart = By.xpath("//button[contains(text(),'Add to cart')]");
	private By viewCart = By.xpath("//a[contains(text(),'View cart')]");


public ShoppinItemSelected(WebDriver driver) {
	
	this.driver=driver;
	
	
}

public void SelectedItem() throws InterruptedException {
	
	Select itemColor = new Select(driver.findElement(By.id("pa_color")));
	itemColor.selectByVisibleText("Pink");
	Select itemSize = new Select(driver.findElement(By.id("pa_size")));
	itemSize.selectByVisibleText("37");
	Thread.sleep(2000);
	driver.findElement(addToCart).click();
	WebDriverWait wait = new WebDriverWait(driver, 10);

//	WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'View cart')]")));
	driver.findElement(viewCart).click();
	
}

}