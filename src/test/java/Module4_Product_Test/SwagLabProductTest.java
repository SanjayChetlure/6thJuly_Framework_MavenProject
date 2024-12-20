package Module4_Product_Test;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import LibraryFiles.BaseClass;
import LibraryFiles.UtilityClass;
import Module1_Login.SwagLabHomePage;
import Module1_Login.SwagLabLoginPage;
import Module1_Login.SwagLabOpenMenuPage;

public class SwagLabProductTest extends BaseClass
{
	SwagLabLoginPage login;
	SwagLabHomePage home;
	SwagLabOpenMenuPage openMenu;
	int TCID;
	
	@BeforeClass
	public void openBrowser() throws EncryptedDocumentException, IOException
	{
		initializeBrowser();
		
		login=new SwagLabLoginPage(driver);  
		home=new SwagLabHomePage(driver);
		openMenu=new SwagLabOpenMenuPage(driver);
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
	public void verifyProductName() throws EncryptedDocumentException, IOException 
	{
		TCID=102;
		String actProductName = home.getSwagLabHomePageOnesieProduct();
		String expProductName=UtilityClass.getTD(1, 0);
		Assert.assertEquals(actProductName, expProductName,"Failed TC2-act & exp ProductName mis match    :");
	}
	
	

	@Test(priority = 2)
	public void verifyProductPrice() throws EncryptedDocumentException, IOException 
	{
		TCID=103;
		double actProductPrice = home.getSwagLabHomePageOnesieProductPrice();
		double expProductPrice=UtilityClass.getTDDouble(2, 0);
		
		Assert.assertEquals(actProductPrice, expProductPrice,"Failed TC3-act & exp ProductPrice mis match    :");
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
