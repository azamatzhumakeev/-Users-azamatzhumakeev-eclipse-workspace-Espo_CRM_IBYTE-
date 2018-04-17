package com.app.step_definition;


import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.app.pages.AccountsPage;
import com.app.pages.LoginPage;
import com.app.utilities.BrowserUtils;
import com.app.utilities.ConfigurationReader;
import com.app.utilities.Driver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Create_accounts_step_defs {
	
	private WebDriver driver = Driver.getDriver();
	LoginPage loginPage = new LoginPage();
	AccountsPage accountsPage = new AccountsPage();
	
	
	@Given("^User logs into EspoCRM$")
	public void user_logs_into_EspoCRM()  {
		driver.get(ConfigurationReader.getProperty("url"));
		loginPage.login(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));
	
	}
	
	@Given("^User opens accounts page$")
	public void user_opens_accounts_page(){		
		accountsPage.accounts.click();
	}

	@Given("^User clicks on create account button$")
	public void user_clicks_on_create_account_button() {		
	  accountsPage.createAccount.click();
	}

	@Given("^User enters the name for the account \"([^\"]*)\"$")
	public void user_enters_the_name_for_the_account(String name) {
	accountsPage.name.sendKeys(name);
	}

	@Given("^User enters the email for the account \"([^\"]*)\"$")
	public void user_enters_the_email_for_the_account(String email) {
		accountsPage.email.sendKeys(email);
	}

	@Given("^User enters the website for the account \"([^\"]*)\"$")
	public void user_enters_the_website_for_the_account(String website) {
		accountsPage.website.sendKeys(website);
	}

	@Given("^User enters the phone number for the account \"([^\"]*)\"$")
	public void user_enters_the_phone_number_for_the_account(String phoneNumber) {
		accountsPage.phoneNumber.sendKeys(phoneNumber);
	}

	@Given("^User enters the country for the account \"([^\"]*)\"$")
	public void user_enters_the_country_for_the_account(String billingAddressCountry) {
		accountsPage.billingAddressCountry.sendKeys(billingAddressCountry);
	}

	@Given("^User selects the type of the account$")
	public void user_selects_the_type_of_the_account() {
		accountsPage.selectType();
	}

	@When("^User clicks on the save button$")
	public void user_clicks_on_the_save_button() {	
		BrowserUtils.waitFor(2);
		accountsPage.save.click();
		BrowserUtils.waitFor(2);
		try {
			Driver.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			accountsPage.saveDuplicate.click();
		}catch(Exception e) {
			System.out.println("No duplicate found");
		}
		Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}

	@Then("^User should see contact information for \"([^\"]*)\"$")
	public void user_should_see_contact_information_for(String name){
		BrowserUtils.waitFor(4);		
		assertEquals(accountsPage.nameConfirm.getText(), name);
		
	}
	

	
	@Then("^User should see new created account \"([^\"]*)\" on the accounts page$")
	public void user_should_see_new_created_account_on_the_accounts_page(String name) {
		accountsPage.accounts.click();	
		BrowserUtils.waitFor(4);
		assertEquals(accountsPage.nameInTheList.getText(), name);
	}
	
	
	@Then("^\"([^\"]*)\" should be displayed$")
	public void should_be_displayed(String alert) {
		BrowserUtils.waitForVisibility(accountsPage.notification, 5);
		//BrowserUtils.fluentWait(accountsPage.notification, 5);
		System.out.println(accountsPage.notification.getText());
		assertEquals(accountsPage.notification.getText(), alert);
		
	}
	
	@When("^User clicks on the Save button$")
	public void user_clicks_on_the_Save_button() {
		accountsPage.save.click();
	}



}