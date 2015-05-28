package PageFactory;

import static org.testng.AssertJUnit.assertFalse;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PageObjectPassTest {

			WebDriver driver;
			PageObjectPass passPage;
			String firstpass;
			String secondpass;
			
			
			
			@BeforeClass
			public void startUp()
			{
				driver = new FirefoxDriver();
				//driver = new ChromeDriver();
				driver.get("http://angel.net/~nic/passwd.current.html");
				driver.manage().window().maximize();
				passPage= PageFactory.initElements(driver, PageObjectPass.class);
				
			}
			
			@Test
			public void password_test_clear() throws InterruptedException
			{
				passPage.cleanUp();
				passPage.submitbutton();
				
				System.out.println("Password: "+passPage.getPassValue());
				
				assertFalse(passPage.isPassTextEmpty());
				
			}

			@Test
			public void password_test_using_PassPage()
			{
				passPage.cleanUp();
				passPage.enterMasterPass("wda434fbd");
				passPage.enterSitePass("qwdqwq4q4dfvd");
				passPage.submitbutton();
				
				System.out.println("Password: "+passPage.getPassValue());
				
				assertFalse(passPage.isPassTextEmpty());
				 
			}
			@Test
			public void similar_passwords_test_two()
			{
				passPage.cleanUp();
				passPage.enterMasterPass("wda4342");
				passPage.enterSitePass("qwdqwq4q4");
				passPage.submitbutton();
				
					String firstpass = passPage.getPassValue();
				
				passPage.cleanUp();
				passPage.enterMasterPass("wda4342");
				passPage.enterSitePass("qwdqwq4q4");
				passPage.submitbutton();
				
					String secondpass = passPage.getPassValue();
				
				Assert.assertEquals(firstpass, secondpass);
			}
			@Test
			public void pasword_test_with_ending()
			{
				passPage.cleanUp();
				passPage.enterMasterPass("wda4342rdfd");
				passPage.enterSitePass("qwdqwq4q4dffdf");
				passPage.submitbutton();
				
				String firstpass = passPage.getPassValue();
				
				Assert.assertEquals(firstpass.substring(firstpass.length()-3, firstpass.length()), "@1a");
				
			}
			
			
			
			
			@AfterClass
			public void cleanUp(){
				
				driver.quit();
				
			}
			
			
}
