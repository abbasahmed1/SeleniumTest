package SeleniumScenario;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class PageObjectSignIn {

	protected WebDriver driver;
	private By MyAccount = By.xpath("//*[@href=\"https://shop.demoqa.com/my-account/\"]");
	private By userName = By.id("user_login");
	private By Password = By.id("user_pass");
	private By NormaluserName = By.id("username");
	private By NormalPassword = By.id("password");
	private By Login = By.name("wp-submit");
	private By NormalLogin = By.name("login");
	private By Dismiss = By.xpath("//a[contains(text(),'Dismiss')]");
	
	public PageObjectSignIn(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public void SignIn(String user, String password) {
		
	    driver.findElement(userName).sendKeys(user);
	    driver.findElement(Password).sendKeys(password);
	    driver.findElement(Login).click();
	    
	
	}
	
	public void normalSignIn(String user, String password) {
		driver.findElement(Dismiss).click();
		driver.findElement(MyAccount).click();
		driver.findElement(NormaluserName).sendKeys(user);
	    driver.findElement(NormalPassword).sendKeys(password);
	    driver.findElement(NormalLogin).click();
		
	}
	
	
}
	
