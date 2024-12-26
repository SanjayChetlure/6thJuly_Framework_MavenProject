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
import Module4_Product.SwagLabCheckoutCompletePage;
import Module4_Product.SwagLabCheckoutInfoPage;
import Module4_Product.SwagLabCheckoutOverviewPage;
import Module4_Product.SwagLabProductPage;
import Module4_Product.SwagLabYourCartPage;

public class SwagLabOrderProductTest extends BaseClass
{
	SwagLabLoginPage login;
	SwagLabHomePage home;
	SwagLabOpenMenuPage openMenu;
	SwagLabProductPage product;
	SwagLabYourCartPage yourCart;
	SwagLabCheckoutInfoPage checkoutInfo;
	SwagLabCheckoutOverviewPage checkoutOverview;
	SwagLabCheckoutCompletePage CheckoutComplete;
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
		yourCart=new SwagLabYourCartPage(driver);
		checkoutInfo=new SwagLabCheckoutInfoPage(driver);
		checkoutOverview=new SwagLabCheckoutOverviewPage(driver);
		CheckoutComplete=new SwagLabCheckoutCompletePage(driver);
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
	public void orderAnySpecificProduct() throws EncryptedDocumentException, IOException, InterruptedException 
	{
		Thread.sleep(2000);
		home.clickSwagLabHomeAnySpecificProduct(UtilityClass.getTD(6, 0));
		Thread.sleep(2000);
		product.clickSwagLabProductPageAddToCartBtn();
		Thread.sleep(2000);
		product.clickSwagLabProductPageCartLink();
		Thread.sleep(2000);
		yourCart.clickSwagLabYourCartPageCheckout();
		Thread.sleep(2000);
		checkoutInfo.inpSwagLabCheckoutInfoPageFN(UtilityClass.getTD(6, 1));
		checkoutInfo.inpSwagLabCheckoutInfoPageLN(UtilityClass.getTD(6, 2));
		checkoutInfo.inpSwagLabCheckoutInfoPagePC(UtilityClass.getTD(6, 3));
		Thread.sleep(2000);
		checkoutInfo.clickSwagLabCheckoutInfoPageContinueBtn();
		Thread.sleep(2000);
		checkoutOverview.ckickSwagLabCheckoutOverviewPageFinish();
		Thread.sleep(2000);
		
		String actMsg = CheckoutComplete.getSwagLabCheckoutCompletePageCheckoutCompleteMsg();
		String expMsg=UtilityClass.getTD(6, 4);
		Assert.assertEquals(actMsg, expMsg, "Fqailed-");
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
