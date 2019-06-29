//Helo Deepak

package com.crm.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;

	public LoginPageTest() {
		super();

	}

	@BeforeMethod
	public void setup() {
		initilization();
		loginPage = new LoginPage();
		loginPage.loginButtonclick();
		homePage = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 1)
	public void ContactbuttonClick() {
		homePage.contactbuttonclick();

	}

	@Test(priority = 2)
	public void Dealuttonclick() {
		homePage.dealsbuttonlcick();
	}

	@Test(priority = 3)
	public void userlabletest() {

		String string = homePage.userlabelVerify();
		Assert.assertEquals(string, prop.getProperty("UserLable"), "Lable is  not match");
	}

	@AfterMethod
	public void Teardown() {
		driver.quit();
	}

}