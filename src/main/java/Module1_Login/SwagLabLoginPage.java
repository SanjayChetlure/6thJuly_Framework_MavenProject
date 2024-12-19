package Module1_Login;
import org.openqa.selenium.WebDriver;
//POM class 1
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class SwagLabLoginPage 
{
	//Step1: declaration
	@FindBy(xpath = "//input[@name='user-name']") private WebElement UN;  			 
	@FindBy(xpath = "//input[@id='password']") private WebElement PWD;				
	@FindBy(xpath = "//input[@name='login-button']") private WebElement loginBtn;   
	@FindBy(xpath = "//div[@class='error-message-container error']") private WebElement errorMsg;   
	WebDriver driver;
	
	//step2: initialization
	public SwagLabLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);   //className.methodName(WebDriverObject, this);
		this.driver=driver;
	}
	
	//step3: usage
	public void inpSwagLabLoginPageUsername(String username) 
	{
		UN.sendKeys(username);            
	}
	
	public void inpSwagLabLoginPagePassword(String password) 
	{
		PWD.sendKeys(password);
	}
	
	public void clickSwagLabLoginPageLoginBtn()
	{
		loginBtn.click();
	}
	
	
	public void verifySwagLabLoginPageErrorMsg(String expErrorMsg)
	{
		String actErrorMsg = errorMsg.getText();
		if(actErrorMsg.contains(expErrorMsg))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
	}
	

}
