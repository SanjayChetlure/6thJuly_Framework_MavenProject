package Module4_Product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabCheckoutCompletePage
{
	@FindBy(xpath = "//h2[@class='complete-header']")  private WebElement checkoutCompleteMsg;
	
	
	public SwagLabCheckoutCompletePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public String getSwagLabCheckoutCompletePageCheckoutCompleteMsg() 
	{
		return checkoutCompleteMsg.getText();
	}
	
	
}
