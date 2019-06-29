package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath = "//button[contains(text(),'New')]")
	@CacheLookup
	WebElement NewButton;

	@FindBy(name = "first_name")
	WebElement firstName;

	@FindBy(name = "middle_name")
	WebElement middleName;

	@FindBy(name = "last_name")
	WebElement lastName;

	@FindBy(xpath = "//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/form/div[4]/div/div/div/div/div[1]/input")
	WebElement EmailID;

	@FindBy(xpath = "//button[contains(text(),'Save')]")
	WebElement SaveButton;

	@FindBy(xpath = "//div[@class='ui header item mb5 light-black' and text()='Create New Contact']")
	WebElement contactFrameName;

	public ContactsPage() {
		PageFactory.initElements(driver, this);

	}

	public void clickonNew() {
		NewButton.click();

	}

	public void CreateNewContact(String FN, String LN, String EM) {

		firstName.sendKeys(FN);
		lastName.sendKeys(LN);
		EmailID.sendKeys(EM);
	}

	public void clickSaveButton() {
		SaveButton.click();

	}

	public ContactsPage ContactFrameNameCheck() {

		boolean bl = contactFrameName.isDisplayed();
		String frameNameString = contactFrameName.getText();
		System.out.println(frameNameString);
		System.out.println(bl);
		return new ContactsPage();
	}

}
