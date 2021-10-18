package SeleniumScenario;

import java.util.Random;

public class RandomDataGenerator {
	
	
	public 	String Username() {
		Random random = new Random();
		String UserName = "Abbas" + random.nextInt(10000);
		
		return UserName;
		
	}
	
	public String Email() {
		
		Random random = new Random();
		String mail = "a.abbas" + random.nextInt(10000) + "@gmail.com";
		
		return mail;
	}


}
