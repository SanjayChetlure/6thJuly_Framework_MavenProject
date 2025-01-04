package Module4_Product_Test;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import LibraryFiles.BaseClass;
import LibraryFiles.UtilityClass;
import Module1_Login.SwagLabHomePage;
import Module1_Login.SwagLabLoginPage;
import Module1_Login.SwagLabOpenMenuPage;
import Module4_Product.SwagLabProductPage;

public class SwagLabProductTest1 extends BaseClass
{
	SwagLabLoginPage login;
	SwagLabHomePage home;
	SwagLabOpenMenuPage openMenu;
	SwagLabProductPage product;
	int TCID;
	
	@Parameters("browserName")
	@BeforeClass
	public void openBrowser(String browserName) throws EncryptedDocumentException, IOException
	{
		initializeBrowser(browserName);
		
		login=new SwagLabLoginPage(driver);  
		home=new SwagLabHomePage(driver);
		openMenu=new SwagLabOpenMenuPage(driver);
		product=new SwagLabProductPage(driver);
	}
	
	@BeforeMethod
	public void loginToApp() throws InterruptedException, EncryptedDocumentException, IOException
	{
		login.inpSwagLabLoginPageUsername(UtilityClass.getPFData("UN"));
		login.inpSwagLabLoginPagePassword(UtilityClass.getPFData("PWD"));
		login.clickSwagLabLoginPageLoginBtn();
		Thread.sleep(2000);
	}

	
	@Test(priority = 1)
	public void verifyAddToCartFeature() throws EncryptedDocumentException, IOException, InterruptedException 
	{
		Thread.sleep(2000);
		home.clickSwagLabHomeAnySpecificProduct(UtilityClass.getTD(5, 0));
		Thread.sleep(2000);
		product.clickSwagLabProductPageAddToCartBtn();
		Thread.sleep(2000);
		boolean actResult = product.getSwagLabProductPageDisplayed();
		Assert.assertTrue(actResult,"Failed-");
	}
	
	

	
	
	
	@AfterMethod
	public void logoutFromApp(ITestResult s1) throws InterruptedException, IOException
	{
		if (s1.getStatus()==ITestResult.FAILURE) 
		{
			UtilityClass.captureSS(driver, TCID);
		}
		
		home.clickSwagLabHomePageOpenMenu();
		Thread.sleep(2000);
		openMenu.clickSwagLabOpenMenuPageLogoutBtn();
		Thread.sleep(2000);
	}
		
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
	}
}
