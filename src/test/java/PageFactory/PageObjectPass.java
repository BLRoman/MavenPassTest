package PageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageObjectPass {

	@FindBy (name="master")
	private WebElement master;
	
	@FindBy (name="site")
	private WebElement site;
	
	@FindBy (xpath="html/body/form/table/tbody/tr[3]/td/input")
	private WebElement button;
	
	@FindBy (name="password")
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