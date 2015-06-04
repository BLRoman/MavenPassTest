package PageFactory;

import static org.testng.AssertJUnit.assertFalse;



//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PageObjectPassTest {

			
			WebDriver driver;
			//WebDriverWait wait = new WebDriverWait(driver, 5);
			PageObjectPass passPage;
			String firstpass;
			String secondpass;
			String site = "http://oxogamestudio.com/passwd.current8.htm";
			
			
			@BeforeClass
			public void startUp()
			{
				driver = new FirefoxDriver();
				//driver = new ChromeDriver();
				driver.get(site);
				driver.manage().window().maximize();
				passPage= PageFactory.initElements(driver, PageObjectPass.class);
				
			}
			
			
			
			@Test
			public void password_test_clear() throws InterruptedException
			{
				
				passPage.cleanUp();
				//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='submit']")));
				passPage.submitbutton();
				

				
				System.out.println("Password: "+passPage.getPassValue());
				
				assertFalse(passPage.isPassTextEmpty());
				
			}

			@Test
			public void password_test_using_PassPage()
			{
				
				driver.get(site);// Для версий с закрытыми полями
				driver.manage().window().maximize();
				
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
				driver.get(site);
				driver.manage().window().maximize();
				
				passPage.cleanUp();
				passPage.enterMasterPass("wda4342");
				passPage.enterSitePass("qwdqwq4q4");
				
				passPage.submitbutton();
				
				
					String firstpass = passPage.getPassValue();

				driver.get(site);
				driver.manage().window().maximize();	
				
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
				driver.get(site);
				driver.manage().window().maximize();
				
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
