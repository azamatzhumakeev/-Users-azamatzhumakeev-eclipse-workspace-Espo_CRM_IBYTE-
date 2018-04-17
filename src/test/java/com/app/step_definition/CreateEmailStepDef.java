package com.app.step_definition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.app.pages.EmailPage;
import com.app.pages.LoginPage;
import com.app.utilities.BrowserUtils;
import com.app.utilities.ConfigurationReader;
import com.app.utilities.Driver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateEmailStepDef {
	private WebDriver driver = Driver.getDriver();
	EmailPage AccountEmails = new EmailPage();
	LoginPage loginPage = new LoginPage();

	@Given("^I logged into EspoCRM$")
	public void i_logged_into_EspoCRM() {
		driver.get(ConfigurationReader.getProperty("url"));
		loginPage.login(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));

	}

	@When("^User clicks email button$")
	public void user_clicks_email_button() throws Throwable {
		AccountEmails.emails.click();
		BrowserUtils.waitFor(3);

	}

	@Then("^all buttons should be displayed$")
	public void all_buttons_should_be_displayed() {
		Assert.assertTrue(AccountEmails.buttonAll.isDisplayed());

	}

	@Then("^User clicks sent button$")
	public void user_clicks_sent_button() {
		AccountEmails.ButtonSent.click();
		AccountEmails.ButtonCheckBox.click();
		BrowserUtils.waitFor(4);

	}

	@Then("^User clicks marks is Important$")
	public void user_clicks_marks_is_Important() {
		AccountEmails.ButtonActions.click();
		BrowserUtils.waitFor(2);
		AccountEmails.MarkImportantButton.click();
		BrowserUtils.waitFor(2);
		AccountEmails.ImportantButton.click();

	}

	@Then("^Important massage is displayed in Important box$")
	public void important_massage_is_displayed_in_Important_box() {
		AccountEmails.ImportantButton.click();
		BrowserUtils.waitFor(5);

	}

}
