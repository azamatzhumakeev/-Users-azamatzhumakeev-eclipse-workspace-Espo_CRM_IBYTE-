package com.app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.app.utilities.Driver;

public class AccountsPage {

	private WebDriver driver;

	public AccountsPage() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Accounts")
	public WebElement accounts;

	@FindBy(linkText = "Create Account")
	public WebElement createAccount;

	@FindBy(name = "name")
	public WebElement name;

	@FindBy(xpath = "//input[@type='email']")
	public WebElement email;

	@FindBy(xpath = "//input[@name='website']")
	public WebElement website;

	@FindBy(xpath = "//input[@class='form-control phone-number no-margin-shifting']")
	public WebElement phoneNumber;

	@FindBy(name = "billingAddressCountry")
	public WebElement billingAddressCountry;

	@FindBy(name = "type") // select[@name='type']
	public WebElement selectType;

	@FindBy(xpath = "//button[.='Save']")
	public WebElement save;

	@FindBy(xpath = "//button[@class='btn btn-danger']")
	public WebElement saveDuplicate;

	@FindBy(xpath = "//button[.=' Yes ']")
	public WebElement yesButton;

	@FindBy(xpath = "(//div[@data-name='name'])[2]")
	public WebElement nameConfirm;

	@FindBy(xpath = "//tbody/tr[1]/td//a[1]")
	public WebElement nameInTheList;

	@FindBy(id = "nofitication")
	public WebElement notification;

	@FindBy(xpath = "//input[@class='record-checkbox']")
	public WebElement checkmarkAccount;

	@FindBy(linkText = "Remove")
	public WebElement remove;

	@FindBy(xpath = "//button[@class='btn btn-danger']")
	public WebElement popupRemove;

	@FindBy(xpath = "//button[@class='btn btn-default dropdown-toggle actions-button']")
	public WebElement actionsButton;

	@FindBy(id = "popup-notifications-container")
	public WebElement popupNotofication;

	@FindBy(xpath = "//button[.='Cancel']")
	public WebElement popupCancel;

	@FindBy(xpath = "//div[@class='text-muted total-count']")
	public WebElement totalNumberOfAccounts;

	@FindBy(xpath = "//button[@data-action='reset']")
	public WebElement resetButton;

	public void selectType() {
		Select select = new Select(selectType);
		select.selectByVisibleText("Customer");
	}

}