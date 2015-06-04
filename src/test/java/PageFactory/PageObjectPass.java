package PageFactory;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class PageObjectPass {

	
	
	@FindBy (xpath="//td[text()='Your master password']/following::input[1]")
	private WebElement master;
	
	@FindBy (xpath="//td[text()='Site name']/following::input[1]")
	private WebElement site;
	
	@FindBy (xpath="//input[@type='submit']")
	private WebElement button;
	
	@FindBy (xpath="//td[text()='Generated password']/following::input[1]")
	private WebElement password;
	
	
	
	public void enterMasterPass(String value)
	{
		master.sendKeys(value);
	}
	
	public void enterSitePass(String value)
	{
		site.sendKeys(value);
	}
	
	public void enterMasterSitePass(String masterValue, String siteValue)
	{
		master.sendKeys(masterValue);
		site.sendKeys(siteValue);
	}
	
	public void submitbutton()
	{
	    
		button.click();
		
	}
	
	public boolean isPassTextEmpty()
	{	
		return password.getAttribute("value").isEmpty();
	}
	
	public String getPassValue()
	{
		return password.getAttribute("value");
	}

	public void cleanUp()
	{
		site.clear();
		master.clear();
		password.clear();
		
	}
	
	
}