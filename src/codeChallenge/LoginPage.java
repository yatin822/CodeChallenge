package codeChallenge;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {
	static WebDriver driver;   

	 @Before
	 public void openBrowser()
	 {
		 //property set
		 System.setProperty("webdriver.chrome.driver", "C:\\Dev\\chromedriver_win32\\chromedriver.exe");
	     driver=new ChromeDriver();
	     
	     //maximize browser window
	     driver.manage().window().maximize();
	     driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	     driver.navigate().to("https://conversations.dealerinspire.com");  
	 } 
	 
	 @Test 
	 public void testInvalidCredentialsandErrorMessage()
	 {

		 //get username element by xpath and send invalid user
		 driver.findElement(By.xpath("//input[@name='username']")).sendKeys("invaliduser");
		 
		 //get password element by xpath and send invalid password
		 driver.findElement(By.xpath("//input[@name='password']")).sendKeys("invalidpassword");  
		 
		 //get login element by xpath and click 
		 driver.findElement(By.xpath("//button[text()='Login']")).click();
		 
		 String expectedMessage = "The username or password you entered is not correct." ;
		 
		 //get error text by xpath
		 String actualMessage = driver.findElement(By.xpath("//div[@class='auth-errors']")).getText();
		
		 //verify the actual message to expected message
		 assertEquals(expectedMessage,actualMessage );
		 
		 System.out.print(expectedMessage + " == " + actualMessage);
	 }	 
	 
	 @Test 
	 public void testInvalidUserNameandErrorMessageandVerifyTextColor()
	 {
		 
		 driver.findElement(By.xpath("//a[@class='forgot-password']")).click();
		 
		 driver.findElement(By.xpath("//input[@name='username']")).sendKeys("invaliduser");
		 
		 driver.findElement(By.xpath("//button[@type='submit']")).click();
		 
		 String expectedMessage = "We can't find a user with that username." ;
		 
		 String actualMessage = driver.findElement(By.xpath("//div[@class='auth-errors']")).getText();
		 
		//verify the actual message to expected message 
		 assertEquals(expectedMessage,actualMessage );
		 
		 System.out.print(expectedMessage + " == " + actualMessage);
		 
		 //Verify the color #a94442
		 String colorString = driver.findElement(By.xpath("//div[@class='auth-errors']")).getCssValue("color");
		 System.out.print("\n" + colorString); 
		 
		 String[] hexValue = colorString.replace("rgba(", "").replace(")", "").split(",");    

		 hexValue[0] = hexValue[0].trim();

		 int hexValue1 = Integer.parseInt(hexValue[0]);                   

		 hexValue[1] = hexValue[1].trim();

		 int hexValue2 = Integer.parseInt(hexValue[1]);                   

		 hexValue[2] = hexValue[2].trim();

		 int hexValue3 = Integer.parseInt(hexValue[2]);                   

		 String actualColor = String.format("#%02x%02x%02x", hexValue1, hexValue2, hexValue3);
		 
		 System.out.print("\n" + actualColor);
		 
		 Assert.assertTrue(actualColor.equals("#a94442"));
	 }	 
	 
	 @After
	 public  void closeBrowser()
	 {
		 driver.close();
	 }

}
