package com.app.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.app.utilities.Driver;

public class EspoCRM_Create_Contact_Page {
	private WebDriver driver;

	public EspoCRM_Create_Contact_Page() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[contains(@class, 'nav-link')]/span[contains(text(),'Contacts')]")
	public WebElement Contacts;
	
	@FindBy(xpath = "//a[contains(text(),'Create Contact')]")
	public WebElement createContact;
	
	@FindBy(xpath ="//div[@class='col-sm-3 col-xs-3']")
	public WebElement name;
	
	@FindBy(xpath = "//input[@name='firstName']")
	public WebElement firsName;

	@FindBy(xpath = "//input[@name='lastName']")
	public WebElement lastName;

	@FindBy(xpath = "//input[@type='email']")
	public WebElement email;

	@FindBy(xpath = "//input[@class='form-control phone-number no-margin-shifting']")
	public WebElement officePhoneNumber;

	@FindBy(xpath = "//button[text()='Save']")
	public WebElement save;

	@FindBy(xpath = "(//button[text()='Save'])[2]")
	public WebElement saveConfirmation;

	public void save(){
		save.click();
		try {
			Driver.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			saveConfirmation.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
}