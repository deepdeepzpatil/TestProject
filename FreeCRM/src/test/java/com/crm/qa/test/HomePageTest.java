package com.crm.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;

	public HomePageTest() {

		super();
	}

	@BeforeMethod
	public void setup() {
		initilization();
		loginPage = new LoginPage();

	}

	@Test(priority = 1)
	public void HomePageTitleTest() {
		String titleString = loginPage.HomePageTitle();
		Assert.assertEquals(titleString, "Free CRM software for any Business");
//		 assertEquals(titleString, "Free CRM software for any Business");
	}

	@Test(priority = 2)
	public void ValidateAndroidImageTest() {
		boolean flag = loginPage.ValidateAndroidImage();

		Assert.assertTrue(flag);

	}

	@Test(priority = 1)
	public void LoginTest() {
		loginPage.loginButtonclick();
		homePage = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));

	}

	@AfterMethod

	public void Teardown() {

		driver.quit();
	}
}
