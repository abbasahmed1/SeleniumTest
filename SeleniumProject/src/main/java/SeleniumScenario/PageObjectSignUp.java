package SeleniumScenario;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageObjectSignUp {

	protected WebDriver driver;
	//static WebDriver driver= new ChromeDriver();
	private By userName = By.id("reg_username");
	private By Password = By.id("reg_password");
	private By Email = By.id("reg_email");
	private By Register = By.name("register");
	private By MyAccount = By.xpath("//*[@href=\"https://shop.demoqa.com/my-account/\"]");
	private By Dismiss = By.xpath("//a[contains(text(),'Dismiss')]");
	//private By Dismiss = By.xpath("//*[@href="#"]");
	
	
	public PageObjectSignUp(WebDriver driver) {
		
		this.driver = driver;
		
	}
	public void SignUp(String user, String password, String Mail) {
		driver.findElement(Dismiss).click();
		driver.findElement(MyAccount).click();
	    driver.findElement(userName).sendKeys(user);
	    driver.findElement(Email).sendKeys(Mail);
	    driver.findElement(Password).sendKeys(password);
	    driver.findElement(Register).click();
	    
	
	}
	
	
}
