

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;


public class java_pass_test {

	WebDriver driver;
	
	String firstpass;
	String secondpass;
	String newpassone;
	
	String masterpass = "fddf5445";
	String name = "dfvdfv545";
	
	
	
	
	@BeforeClass
	public void start_up()
	{
		
		driver = new ChromeDriver();
		driver.get("http://angel.net/~nic/passwd.current.html");
		driver.manage().window().maximize();
		
	}
	@Test
	public void javaPassTest() throws InterruptedException
	{
		driver.findElement(By.name("master")).sendKeys(masterpass);
		Thread.sleep(1000);
		driver.findElement(By.name("site")).sendKeys(name);
		Thread.sleep(1000);
		driver.findElement(By.xpath("html/body/form/table/tbody/tr[3]/td/input")).click();
		Thread.sleep(1000);
		String firstpass = driver.findElement(By.name("password")).getText();
		Thread.sleep(1000);
		
		
		driver.get("http://angel.net/~nic/passwd.current.html");
		
		driver.findElement(By.name("master")).sendKeys(masterpass);
		Thread.sleep(1000);
		driver.findElement(By.name("site")).sendKeys(name);
		Thread.sleep(1000);
		driver.findElement(By.xpath("html/body/form/table/tbody/tr[3]/td/input")).click();
		Thread.sleep(1000);
		String secondpass = driver.findElement(By.name("password")).getText();
		
		Assert.assertEquals(firstpass, secondpass);
		
	}
	
	
	
	@Test			
		public void javaPassTestTwo() throws InterruptedException
		{
		
		driver.get("http://angel.net/~nic/passwd.current.html");
				
		
		driver.findElement(By.name("master")).sendKeys(masterpass);
		Thread.sleep(1000);
		driver.findElement(By.name("site")).sendKeys(name);
		Thread.sleep(1000);
		driver.findElement(By.xpath("html/body/form/table/tbody/tr[3]/td/input")).click();
		String newpassone = driver.findElement(By.name("password")).getAttribute("value");	
		Thread.sleep(1000);
		
		
		Assert.assertEquals(newpassone.substring(newpassone.length()-3, newpassone.length()), "@1a");
		Thread.sleep(1000);	
		

                                             
	}
	
	
	
	@AfterClass
	public void shut_down()
	{
		 
		driver.quit();
	}
	
}
