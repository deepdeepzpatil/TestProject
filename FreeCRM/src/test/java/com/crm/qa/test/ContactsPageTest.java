package com.crm.qa.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	String sheetname = "contacts";

	public ContactsPageTest() {
		super();

	}

	@BeforeMethod
	public void setup() {
		initilization();

		loginPage = new LoginPage();
		loginPage.loginButtonclick();
		homePage = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		homePage.contactbuttonclick();
		contactsPage = new ContactsPage();

	}

	@Test(priority = 1)
	public void Framecheck() {
		contactsPage.clickonNew();
		contactsPage.ContactFrameNameCheck();
	}

	@Test(priority = 2)
	public void ClickonNewButton() {
		contactsPage.clickonNew();
		contactsPage.CreateNewContact(prop.getProperty("FirstName"), prop.getProperty("LastName"),
				prop.getProperty("Email"));
		contactsPage.clickSaveButton();
	}

	@DataProvider
	public Object[][] GetTestData() {
		Object data[][] = TestUtil.getTestData(sheetname);
		return data;

	}

	@Test(priority = 3, dataProvider = "GetTestData")
	public void validateCreatenewContatc(String fistname, String lastname, String email) throws InterruptedException {
		contactsPage.clickonNew();
		// contactsPage.CreateNewContact(FN, LN, EM);
		contactsPage.CreateNewContact(fistname, lastname, email);
		contactsPage.clickSaveButton();
		Thread.sleep(2000);

	}

	@AfterMethod
	public void TearDown() {
		driver.quit();

	}

}