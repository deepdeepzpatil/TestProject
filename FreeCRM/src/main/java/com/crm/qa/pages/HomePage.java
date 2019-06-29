package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//span[@class ='item-text' and contains(text(),'Contacts')]")
	WebElement Contactbutton;

	@FindBy(xpath = "//span[@class ='item-text' and contains(text(),'Deals')]")
	WebElement Dealsbutton;

	@FindBy(xpath = "//span[@class ='item-text' and contains(text(),'Tasks')]")
	WebElement Taskbutton;

	@FindBy(xpath = "//span[contains(text(),'Deepak Patil')]")
	WebElement userLable;

	public HomePage() {
		PageFactory.initElements(driver, this);

	}

	public ContactsPage contactbuttonclick() {
		Contactbutton.click();
		return new ContactsPage();
	}

	public DealsPage dealsbuttonlcick() {
		Dealsbutton.click();
		return new DealsPage();

	}

	public TasksPage TasksbuttonClick() {
		Taskbutton.click();
		return new TasksPage();
	}

	public String verifyHomepagetitle() {

		return driver.getTitle();

	}

	public String userlabelVerify() {
		String string = userLable.getText();
		System.out.println(string);
		return string;
	}

}