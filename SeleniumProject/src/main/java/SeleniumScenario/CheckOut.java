package SeleniumScenario;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckOut {
	
	protected WebDriver driver;
	protected By checkO = By.xpath("//a[contains(text(),'Proceed to checkout')]");

	
	public CheckOut(WebDriver driver) {
		
		this.driver=driver;
		
	}	
	
	public void checkOutItem() {
		
		driver.findElement(checkO).click();
		
	}
	
}
