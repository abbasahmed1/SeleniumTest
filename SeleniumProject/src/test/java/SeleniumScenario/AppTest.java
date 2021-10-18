package SeleniumScenario;
import static org.junit.jupiter.api.Assertions.*;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;





@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AppTest 
{

	
	static String UserName = "";
	static String Email = "";
	
	
	
	public static WebDriver driver = null ;
	
	
	
	@BeforeAll
	public static void LoadData () {
		
		RandomDataGenerator random = new RandomDataGenerator();
		UserName = random.Username();
		Email = random.Email();

		
	}

	@BeforeEach

	public void OpenChrome () {


		//WebDriverManager.chromedriver().setup();
		
		System.setProperty("webdriver.chrome.driver", ".\\Driver\\chromedriver.exe");
		//ChromeOptions opt = new ChromeOptions();
		//opt.setHeadless(true);
		//driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.get("https://shop.demoqa.com/");
		//driver.navigate().to("https://shop.demoqa.com/");
		//Thread.sleep(1000);
	
		
	}
	
	


	@Test
    @Order(1)
    public void RegistrationAndLogin(){
    	
		PageObjectSignUp Sign = new PageObjectSignUp(driver);
		Sign.SignUp(UserName, "TestSelenium12345@",Email);
		
		PageObjectSignIn signIn = new PageObjectSignIn(driver);
		signIn.SignIn(UserName,"TestSelenium12345@");
		String actualString = driver.findElement(By.xpath("//*[contains(text(),'" + UserName + "')]")).getText();
		assertEquals(actualString.contains(UserName),true);

    }
    
	@Test 
    @Order(2)
    public void OrderProduct() throws InterruptedException{


 		PageObjectSignIn signIn = new PageObjectSignIn(driver);
 		signIn.normalSignIn(UserName,"TestSelenium12345@");
 		
 		String actualStr = driver.findElement(By.xpath("//*[contains(text(),'" + UserName + "')]")).getText();
		assertEquals(actualStr.contains(UserName),true);
 		ShoppingItems shop = new ShoppingItems(driver);
		
 		shop.ShoppingItem();
		
		ShoppinItemSelected item = new ShoppinItemSelected(driver);
		item.SelectedItem();
		
		
		CheckOut check = new CheckOut(driver);
		check.checkOutItem();
		
		PlaceOrder PO = new PlaceOrder(driver);
		PO.placeOrderDetails(UserName, "Abbas","Delhi town", "New Delhi", "110005", "01001428212");

		String actualString = driver.findElement(By.xpath("//h1[contains(text(),'Checkout')]")).getText();

		
		assertEquals(actualString.contains("CHECKOUT"),true);
		System.out.println("The Order is been Placed");
		
		PO.returnHome();

 		

 		
     }
    
    
    @Test
    @Order(3)
    public void AddProductToWishlist() throws InterruptedException {
    	
    	PageObjectSignIn signIn = new PageObjectSignIn(driver);
 		signIn.normalSignIn(UserName,"TestSelenium12345@");
 		
 		String actualStr = driver.findElement(By.xpath("//*[contains(text(),'" + UserName + "')]")).getText();
		assertEquals(actualStr.contains(UserName),true);
 		
 		ShoppingItems shop = new ShoppingItems(driver);
 		shop.ShoppingItem();
 		
 		WishList wish = new WishList(driver);
 		wish.WishlistProduct();
 		String actualString = driver.findElement(By.xpath("//a[contains(text(),'pink drop shoulder oversized t shirt')]")).getText();
 		assertEquals(actualString.contains("PINK DROP SHOULDER OVERSIZED T SHIRT"),true);
		System.out.println("The Right Product");
		
		wish.RemoveFromWishlist();
		driver.navigate().refresh();
		String RemoveMessage = driver.findElement(By.xpath("//*[@class=\"wishlist-empty\"]")).getAttribute("outerHTML");
 		assertEquals(RemoveMessage.contains("No products added to the wishlist"),true);
 		System.out.println("Product Successfully Removed");
 		
 		wish.returnHome();
 		
 				
    	
    }

   @AfterEach
    
    public void CloseChrome() {

	 driver.close();
   } 
}
