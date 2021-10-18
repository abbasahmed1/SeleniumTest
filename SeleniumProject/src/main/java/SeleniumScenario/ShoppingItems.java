package SeleniumScenario;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingItems {
	protected WebDriver driver;
	private By HomePage = By.xpath("//*[@class=\"custom-logo-link\"]");
	private By SelectProduct = By.xpath("//a[contains(text(),'pink drop shoulder oversized t shirt')]");
	//private By SelectProduct = By.xpath("//*[@href=\"a[contains(text(),'pink drop shoulder oversized t shirt')]\"]"/////"//*[@img=\"<img width=\"270\" height=\"370\" src=\"https://shop.demoqa.com/wp-content/uploads/2019/04/pink-drop-shoulder-oversized-t-shirt-1-270x370.jpg\"]");
	
	public ShoppingItems(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public void ShoppingItem() throws InterruptedException {
		
		driver.findElement(HomePage).click();
		Thread.sleep(5000);
		driver.findElement(SelectProduct).click();
		
	    
		
	}
}
