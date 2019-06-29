package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	// Page Factory or Obect OR

	@FindBy(name = "email")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//span[text()='Log In']")
	WebElement LoginButton;

	@FindBy(xpath = "//img[contains(@title,'app for freecrm android')]")
	WebElement AndroidIcon;

	@FindBy(xpath = "//a[@class = 'btn btn-sm btn-white btn-icon btn-icon-left btn-shadow btn-border btn-rect offset-sm-top-60 offset-top-30']")
	WebElement SingUpButton;

	@FindBy(xpath = "//*[@class='ui fluid large blue submit button']")
	WebElement LoginButtonhome;

	public LoginPage() {
		PageFactory.initElements(driver, this);

	}

	public String HomePageTitle() {

		return driver.getTitle();
	}

	public HomePage Login(String un, String pass) {

		username.sendKeys(un);
		password.sendKeys(pass);
		LoginButtonhome.click();

		return new HomePage();

	}

	public boolean ValidateAndroidImage() {

		return AndroidIcon.isDisplayed();

	}

	public void loginButtonclick() {
		LoginButton.click();

	}

}
