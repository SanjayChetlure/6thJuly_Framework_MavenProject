package Module4_Product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabCheckoutInfoPage
{
	@FindBy(xpath = "//input[@name='firstName']")  private WebElement FN;
	@FindBy(xpath = "//input[@name='lastName']")  private WebElement LN;
	@FindBy(xpath = "//input[@name='postalCode']")  private WebElement PC;
	@FindBy(xpath = "//input[@name='continue']")  private WebElement ContinueBtn;
	
	
	public SwagLabCheckoutInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void inpSwagLabCheckoutInfoPageFN(String firstname) 
	{
		FN.sendKeys(firstname);
	}
	
	public void inpSwagLabCheckoutInfoPageLN(String lastname) 
	{
		LN.sendKeys(lastname);
	}
	
	public void inpSwagLabCheckoutInfoPagePC(String postalCode) 
	{
		PC.sendKeys(postalCode);
	}
	
	public void clickSwagLabCheckoutInfoPageContinueBtn() 
	{
		ContinueBtn.click();
	}
	
	
}
