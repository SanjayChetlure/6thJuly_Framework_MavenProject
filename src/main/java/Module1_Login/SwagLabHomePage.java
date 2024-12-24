package Module1_Login;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//POM class 2
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class SwagLabHomePage 
{
	//step1: declaration
	@FindBy(xpath = "//div[@class='app_logo']")  private WebElement logo;
	@FindBy(xpath = "//button[@id='react-burger-menu-btn']") private WebElement openMenu;
	@FindBy(xpath = "//a[@id='item_2_title_link']") private WebElement onesieProduct;
	@FindBy(xpath = "(//div[@class='inventory_item_price'])[5]") private WebElement onesieProductPrice;
	@FindBy(xpath = "//div[@class='inventory_item_name ']")  private List<WebElement> allProducts;
	@FindBy(xpath = "//div[@class='inventory_item_price']")  private List<WebElement> allProductsPrice;
	WebDriver driver;
	
	//step2: initialization
	public SwagLabHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	
	
	public String getSwagLabHomePageLogoText() 
	{
		String LogoText = logo.getText();
		return LogoText;
	}
	
	public void clickSwagLabHomePageOpenMenu() 
	{
		openMenu.click();
	}
	
	
	public String getSwagLabHomePageOnesieProduct()
	{
		String actText = onesieProduct.getText();
		return actText;
	}
	
	public double getSwagLabHomePageOnesieProductPrice()
	{
		String productPrice = onesieProductPrice.getText();  //  $7.99 
		productPrice=productPrice.substring(1);               //7.99
		
		double PriceInDouble = Double.parseDouble(productPrice);    //String -> Double
		
		return PriceInDouble;
	}
	
	
	public int getSwagLabHomePageAllProductSize() 
	{
		int size = allProducts.size();
		return size;
	}
	
	
	public double getSwagLabHomePageAllProductPriceSum() 
	{
		double sum=0;
		for(WebElement singleProductPrice:allProductsPrice)
		{
			String price = singleProductPrice.getText();      //$5.12  -> 5.12(String)
			price=price.substring(1);                              // 5.12(String)
			double priceInDouble = Double.parseDouble(price);
			
			sum=sum+priceInDouble;
		}
		
		return sum;
	}
	
	public void clickSwagLabHomeAnySpecificProduct(String ProductName) 
	{
		driver.findElement(By.xpath("//div[text()='"+ ProductName+ "']")).click();
	}

}
