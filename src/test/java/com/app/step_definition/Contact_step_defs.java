package com.app.step_definition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.app.pages.EspoCRM_Create_Contact_Page;
import com.app.pages.LoginPage;
import com.app.utilities.BrowserUtils;
import com.app.utilities.ConfigurationReader;
import com.app.utilities.Driver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Contact_step_defs {
	private WebDriver driver = Driver.getDriver();
	LoginPage login = new LoginPage();
	EspoCRM_Create_Contact_Page ContactPage = new EspoCRM_Create_Contact_Page();
	
	@Given("^User logged into EspoCRM$")
	public void user_logged_into_EspoCRM() throws Throwable {
		driver.get(ConfigurationReader.getProperty("url"));
		login.login(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));
	}

	@Given("^User opens the create contact page$")
	public void user_opens_the_create_contact_page() throws Throwable {
		ContactPage.Contacts.click();
		BrowserUtils.waitFor(3);
		ContactPage.createContact.click();
	}

	@Given("^user enters the Name$")
	public void user_enters_the_Name() throws Throwable {
		
	}

	@Given("^User enters the first Name \"([^\"])\" and the last Name \"([^\"])\"$")
	public void user_enters_the_first_Name_and_the_last_Name(String firstNAMe, String LastName) throws Throwable {
		ContactPage.firsName.sendKeys("Kai");
		ContactPage.lastName.sendKeys("Lee");
	}

	@Given("^User enters the email address \"([^\"]*)\"$")
	public void user_enters_the_email_address(String email) throws Throwable {
		ContactPage.email.sendKeys("kailee@gmail.com");
	}

	@Given("^User enters the phone number \"([^\"]*)\"$")
	public void user_enters_the_phone_number(String Phone) throws Throwable {
		ContactPage.officePhoneNumber.sendKeys("3125679809");
	}
	@When("^User clicks on the Save Button$")
	public void user_clicks_on_the_Save_Button() throws Throwable {
		BrowserUtils.waitFor(3);
		ContactPage.save();
		
		try {
			Driver.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			ContactPage.save.click();
		}catch(Exception e) {
			System.out.println("No duplicate found");
		}
		Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	

	@Then("^User should see Contact Information for \"([^\"]*)\"$")
	public void user_should_see_Contact_Information_for(String arg1) throws Throwable {
	   
	}

}