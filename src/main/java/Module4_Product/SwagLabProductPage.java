package Module4_Product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabProductPage 
{
	@FindBy(xpath = "//button[text()='Add to cart']")  private WebElement AddToCartBtn;
	@FindBy(xpath = "//button[text()='Remove']")  private WebElement RemoveBtn;
	@FindBy(xpath = "//span[@class='shopping_cart_badge']")  private WebElement CartLink;
	
	
	public SwagLabProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickSwagLabProductPageAddToCartBtn() 
	{
		AddToCartBtn.click();
	}
	
	
	public boolean getSwagLabProductPageDisplayed() 
	{
		boolean result = RemoveBtn.isDisplayed();
		return result;
	}
	
	public void clickSwagLabProductPageCartLink() 
	{
		CartLink.click();
	}

}
